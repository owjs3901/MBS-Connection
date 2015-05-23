/*
 * [오류 : 0] 알 수 없는 오류
 * [오류 : 1] EULA 파일이 없음
 * [오류 : 2] 정상적인 EULA 파일이 아님
 * [오류 : 200] 문서 확인중 오류
 */
package com.MBS.Connection;

import java.io.*;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import com.MBS.Connection.Connection_EULA.NetworkEULA;

public class Connection_main extends JavaPlugin{
	static Connection_Network network=new Connection_Network();
	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(new com.MBS.Connection.Connection_Event(), this);
		title();
		File eula=new File("M's Plugins EULA.txt");
		PluginDescriptionFile d=this.getDescription();
		Connection_Update.lookUpdate(d.getVersion());
		Connection_Update.lookBlackList();
		if(!(eula.exists())){
			Connection_Error.setError(1);
			NetworkEULA.createEULA();
			}
		NetworkEULA.lookEULA();
		Connection_EULA.lookEulaStat();
		network.start();
		if(Connection_Utill.updatelist>0){
			Bukkit.getConsoleSender().sendMessage("[알림] 내려받은 플러그인이 "+Connection_Utill.updatelist+"개 있습니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] 플러그인 적용을 위하여 서버를 재시작 합니다.");
			Bukkit.reload();
		}
	}
	@SuppressWarnings("deprecation")
	@Override
	public void onDisable(){
		title();
		network.stop();
	}
	public void title() {
		Bukkit.getConsoleSender().sendMessage("□■□■□□□□");
		Bukkit.getConsoleSender().sendMessage("■□■□■□□□");
		Bukkit.getConsoleSender().sendMessage("■□■□■□□□");
		Bukkit.getConsoleSender().sendMessage("■□■□■□□□");
		Bukkit.getConsoleSender().sendMessage("□□□□■■■□");
		Bukkit.getConsoleSender().sendMessage("□□□□■□□■");
		Bukkit.getConsoleSender().sendMessage("■■■■■■■□");
		Bukkit.getConsoleSender().sendMessage("■□□□■□□■");
		Bukkit.getConsoleSender().sendMessage("■■■□■■■□");
		Bukkit.getConsoleSender().sendMessage("□□■□□□□□");
		Bukkit.getConsoleSender().sendMessage("■■■□□□□□  Project MBS");
	}
}
