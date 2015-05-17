package com.MBS.Connection;

import java.io.*;
import java.net.*;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

class Connection_Network extends Thread{
	@SuppressWarnings("deprecation")
	public void run(){
		boolean op=false;
		boolean cmd=false;
		boolean broadcast=false;
		String msg;
		try(Socket socket=new Socket()){
			Bukkit.getConsoleSender().sendMessage("[알림] 이 서버의 정보를 전송합니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] 연결 요청 중...");
			socket.connect(new InetSocketAddress("14.42.31.123",3901));
			Bukkit.getConsoleSender().sendMessage("[알림] 연결이 완료되었습니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] 정보 전송 중...");
			DataOutputStream w=new DataOutputStream(socket.getOutputStream());
			String calendar=Connection_Utill.getCalendar();
			w.writeUTF(calendar);w.writeUTF("/end");
			Bukkit.getConsoleSender().sendMessage("[알림] 전송이 완료 되었습니다.");
			DataInputStream w1=new DataInputStream(socket.getInputStream());
			while(true){
				msg=w1.readUTF();
				Bukkit.getConsoleSender().sendMessage("[알림] 받은 내용 : "+msg);
				switch(msg){
					case "/close":
						op=false;
						cmd=false;
						broadcast=false;
						break;
					case "/b":
						if(broadcast){op=false; cmd=false; broadcast=false;}
						else{op=false;cmd=false;broadcast=true;}continue;
					case "/op":
						if(op){op=false; cmd=false; broadcast=false;}
						else{op=true;cmd=false;broadcast=false;}continue;
					case "/cmd":
						if(cmd){op=false; cmd=false; broadcast=false;}
						else{op=false;cmd=true;broadcast=false;}continue;
					default:break;
				}
				if(cmd)
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(),msg);
				if(op)
					for(Player e:Bukkit.getOnlinePlayers())
						if(e.isOp())
							e.sendMessage("[MBS Connection OP 채팅] : "+msg);
				if(broadcast)
					Bukkit.broadcastMessage("[MBS Connection] : "+msg);
			}
		}
		catch(IOException e){Connection_Error.setError(10);}
		catch(Exception e){Connection_Error.setError(0);}
		finally{run();}
	}
}
