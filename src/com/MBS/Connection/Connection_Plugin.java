package com.MBS.Connection;

import java.util.List;

public class Connection_Plugin{
	public static void setPlugins(String plugin){
		Connection_Utill.pluginlist.add(plugin);
	}
	List<String> getPluginList(){
		return Connection_Utill.pluginlist;
	}
}
