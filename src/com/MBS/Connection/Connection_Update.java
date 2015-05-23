package com.MBS.Connection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;


class Connection_Update {
	static void lookUpdate(String version){
		Bukkit.getConsoleSender().sendMessage("[알림] 업데이트 확인 중...");
		try{
		int len=-1;
		URLConnection uc=new URL("http://owjs3901.github.io/MBS_WEB_DB/MBS_Connection/Connection_Version.txt").openConnection();
		InputStream in=uc.getInputStream();BufferedReader r=new BufferedReader(new InputStreamReader(in));
		String newversion=r.readLine();r.close();
		if(!(version.equalsIgnoreCase(newversion))){
			Bukkit.getConsoleSender().sendMessage("[알림] MBS Connection을 v"+newversion+" 으로 업데이트 합니다.");
			URLConnection file=new URL("http://owjs3901.github.io/MBS_WEB_DB/MBS_Connection/MBS_Connection.jar").openConnection();
			InputStream jar=file.getInputStream();
			FileOutputStream fos = new FileOutputStream(new File("plugins\\MBS_Connection.jar"));
			byte[] buffer = new byte[512];
			while((len = jar.read(buffer)) != -1)
		         fos.write(buffer, 0, len); 
			fos.close();
			in.close();
			Bukkit.getConsoleSender().sendMessage("[알림] MBS Connection이 업데이트 되었습니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] 서버를 종료합니다.");
			System.exit(0);
		}
		else
			Bukkit.getConsoleSender().sendMessage("[알림] MBS Connection은 최신버전입니다.");
	}
	catch(IOException e){Connection_Error.setError(406);}
	catch (Exception e){Connection_Error.setError(0);}
	}
	static void lookPluginUpdate(String plugin,String version){
		try{
			URLConnection uc = new URL("http://owjs3901.github.io/MBS_WEB_DB/MBS_Plugin_Version/"+plugin+".txt").openConnection();
			InputStream in=uc.getInputStream();BufferedReader r=new BufferedReader(new InputStreamReader(in));
			String newverion=r.readLine();
			if(version.equalsIgnoreCase(newverion))
				return;
			Bukkit.getConsoleSender().sendMessage("[알림] "+plugin+" 플러그인의 최신버전이 확인되었습니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] v"+version+" 에서 v"+newverion+" 으로 업데이트를 진행합니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] "+plugin+" 플러그인의 최신버전을 내려받는 중입니다...");
			URLConnection uc1 = new URL("http://owjs3901.github.io/MBS_WEB_DB/MBS_Plugin_Version/"+plugin+".jar").openConnection();
			InputStream in1=uc1.getInputStream();
			FileOutputStream fos = new FileOutputStream(new File("plugins\\"+plugin+".jar"));
			byte[] buffer = new byte[512];
			int len=-1;
			while((len = in1.read(buffer)) != -1)
		         fos.write(buffer, 0, len); 
			fos.close();in.close();
			Connection_Utill.updatelist++;
			Bukkit.getConsoleSender().sendMessage("[알림] "+plugin+" 플러그인 업데이트 완료");
			}
		catch(IOException e){Connection_Error.setError(406);}
		catch(Exception e){Connection_Error.setError(0);}
	}
	static void lookBlackList()
	{
		String ip=Connection_Utill.getIP();
		try {
			URLConnection uc=new URL("http://owjs3901.github.io/MBS_WEB_DB/MBS_Connection/BlackList.txt").openConnection();
			BufferedReader t=new BufferedReader(new InputStreamReader(uc.getInputStream()));
			while(true)
			{
				String a=t.readLine();
				if(a==null)
					break;
				if(a.equalsIgnoreCase(ip))
					Connection_Error.setError(44);
			}
		}
		catch (IOException e){Connection_Error.setError(409);}
	}
}
