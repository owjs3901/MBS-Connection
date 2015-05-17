/*
* [오류 : 0] 알 수 없는 오류
* [오류 : 1] EULA 파일이 없음
* [오류 : 2] 정상적인 EULA 파일이 아님
* [오류 : 3] 문서를 읽는 도중 오류
* [오류 : 4] EULA 문서를 수락 안함
* [오류 : 10] 로그인 실패
* [오류 : 11] 서버에서 받은 정보가 없음
* [오류 : 12] 서버에 접근 불가능(꺼진듯)
* [오류 : 13] 연결된 커넥션 서버가 연결을 끊음
* [오류 : 14] 이미 포트를 사용중
* [오류 : 15] 패킷 전송 오류
* [오류 : 44] 블랙리스트에 등록되어 있음
* [오류 : 45] 권한이 없는 플러그인을 로딩
* [오류 : 404] EULA 문서 네트워크 다운로드 중 오류
* [오류 : 405] EULA 문서 네트워크 판별 중 오류 
*/
package com.MBS.Connection;

import org.bukkit.Bukkit;

class Connection_Error{
	static void setError(int a)
	{
		try{
		switch(a){
			case 0:
				Bukkit.getConsoleSender().sendMessage("[오류 : 0] 알 수 없는 오류입니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 0] 서버를 종료합니다.");
				System.exit(0);
				break;
			case 1:
				Bukkit.getConsoleSender().sendMessage("[오류 : 1] EULA 파일이 없습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 1] 다운로드를 진행합니다.");
				break;
			case 2:
				Bukkit.getConsoleSender().sendMessage("[오류 : 2] 정상적인 EULA 파일이 아닙니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 2] \"M's Plugins EULA.txt\" 를 지운 후 다시 서버를 실행해 주세요.");
				System.exit(0);
				break;
			case 3:
				Bukkit.getConsoleSender().sendMessage("[오류 : 3] 문서를 읽기 혹은 쓰는 도중 오류가 생겼습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 3] 서버를 다시 실행 합니다.");
				Bukkit.reload();
				break;
			case 4:
				Bukkit.getConsoleSender().sendMessage("[오류 : 4] EULA 문서를 수락하지 않았습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 4] 서버를 종료합니다.");
				System.exit(0);
				break;
			case 10:
				Bukkit.getConsoleSender().sendMessage("[오류 : 10] 데이터베이스 서버가 열려있지 않습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 10] 정보를 보내지 않습니다.");
				break;
			case 13:
				Bukkit.getConsoleSender().sendMessage("[오류 : 13] MBS Connection 서버에서 연결을 끊었습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 13] Connection 서버를 다시 실행합니다.");
//				Connection_Utill.serversocket.close();
//				Connection_Utill.AcceptNetwork.run();
				break;
			case 14:
				Bukkit.getConsoleSender().sendMessage("[오류 : 14] MBS Connection 이 사용 중인 포트를 사용중입니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 14] Connection 서버를 다시 실행합니다.");
//				Connection_Utill.serversocket.close();
//				Connection_Utill.AcceptNetwork.run();
				break;
			case 15:
				Bukkit.getConsoleSender().sendMessage("[오류 : 15] 패킷 전송중 오류가 생겼습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 15] 서버를 종료합니다.");
				System.exit(0);
				break;
			case 44:
				Bukkit.getConsoleSender().sendMessage("[오류 : 44] 블랙리스트에 등록되어 있습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 44] 자세한것은 관리자에게 연락을 주세요.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 44] 서버를 종료합니다.");
				System.exit(0);
				break;
			case 45:
				Bukkit.getConsoleSender().sendMessage("[오류 : 45] 일부 플러그인이 화이트리스트에 등록되어 있지 않습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 45] 자신이 구매하지 않은 플러그인을 빼주세요.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 45] 서버를 종료합니다.");
				System.exit(0);
				break;
			case 404:
				Bukkit.getConsoleSender().sendMessage("[오류 : 404] EULA 문서를 내려받던 중 오류가 생겼습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 404] 로컬 EULA 문서를 내려받습니다.");
				break;
			case 405:
				Bukkit.getConsoleSender().sendMessage("[오류 : 405] EULA 문서를 확인하던 중 오류가 생겼습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 405] 로컬 EULA 문서 정보로 EULA 문서를 인증합니다.");
				break;
			case 406:
				Bukkit.getConsoleSender().sendMessage("[오류 : 406] MBS Connection 최신버전을 내려받는 중 오류가 생겼습니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 406] 서버를 재시작 합니다.");
				break;
			default:
				Bukkit.getConsoleSender().sendMessage("[오류 : 불명] 정의되지 않은 오류입니다.");
				Bukkit.getConsoleSender().sendMessage("[오류 : 불명] 서버를 종료합니다.");
				System.exit(0);
				break;
			}
		}
		catch(Exception e){setError(0);}
	}
}
