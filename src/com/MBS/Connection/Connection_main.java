/*
 * [오류 : 0] 알 수 없는 오류
 * [오류 : 1] EULA 파일이 없음
 * [오류 : 2] 정상적인 EULA 파일이 아님
 * [오류 : 200] 문서 확인중 오류
 */
package com.MBS.Connection;

import java.io.*;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.MBS.Connection.Connection_EULA.NetworkEULA;

public class Connection_main extends JavaPlugin{
	public Connection_main() {
		// TODO 자동 생성된 생성자 스텁
	}
	@Override
	public void onEnable(){
		File eula=new File("M's Plugins EULA.txt");
		title();
		if(!(eula.exists())){
			Connection_Error.setError(1);
			NetworkEULA.createEULA();
			}
		NetworkEULA.lookEULA();
		Connection_EULA.lookEulaStat();
		Connection_Network network=new Connection_Network();network.start();
	}
	@Override
	public void onDisable(){
		try{
		}
		catch(Exception e){e.getMessage();}
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
