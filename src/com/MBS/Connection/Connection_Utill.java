package com.MBS.Connection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;


class Connection_Utill {
	static int updatelist=0;
	static ArrayList<String> pluginlist=new ArrayList<String>();
	static String getCalendar(){
		Calendar c=Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH)+1;
		int day=c.get(Calendar.DAY_OF_MONTH);
		int weekint=c.get(Calendar.DAY_OF_WEEK);
		int hour=c.get(Calendar.HOUR_OF_DAY);
		int min=c.get(Calendar.MINUTE);
		int se=c.get(Calendar.SECOND)+1;
		String weekString=null;
		switch(weekint){
		case 2:
			weekString="월요일";break;
		case 3:
			weekString="화요일";break;
		case 4:
			weekString="수요일";break;
		case 5:
			weekString="목요일";break;
		case 6:
			weekString="금요일";break;
		case 7:
			weekString="토요일";break;
		case 1:
			weekString="일요일";break;
		default:
			Connection_Error.setError(0);break;
		}
		String today=year+"년-"+month+"월-"+day+"일-"+weekString+"-"+hour+"시-"+min+"분-"+se+"초";
		return today;
	}
	static String getIP()
	{
		String ip="";
		try {
			URL url = new URL("http://bot.whatismyipaddress.com"); //아이피 보는 사이트
			 BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream())); //사이트에 연결해서
	         ip = reader.readLine().trim();
		}
		catch (Exception e){Connection_Error.setError(408);}
		return ip;
	}
}
