package com.MBS.Connection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;


public class Connection_Plugin{
	public static void setPlugin(String plugin,String version){
		Connection_Utill.pluginlist.add(plugin+" v"+version);
		Connection_Update.lookPluginUpdate(plugin, version);
	}
	public static void setPremium(String plugin)
	{
		try {
			URLConnection uc = new URL("http://owjs3901.github.io/MBS_WEB_DB/MBS_Premium/"+plugin+".txt").openConnection();
			InputStream in=uc.getInputStream();BufferedReader r=new BufferedReader(new InputStreamReader(in));
			boolean user=false;
			while(true){
				String a=r.readLine();
				if(a==null)
					break;
				if(a.equalsIgnoreCase(Connection_Utill.getIP()))
					user=true;
			}
			if(!user){
				Bukkit.getConsoleSender().sendMessage("[알림] "+plugin+" 플러그인을 실행할 수 없는 계정입니다.");
				Connection_Error.setError(5);
				System.exit(0);}
		}
		catch (IOException e){Bukkit.reload();}
		catch(Exception e){Connection_Error.setError(0);}
	}
}
