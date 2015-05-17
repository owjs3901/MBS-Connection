package com.MBS.Connection;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

class Connection_EULA {
	static void lookEulaStat(){
		try(BufferedReader in=new BufferedReader(new FileReader(new File("M's Plugins EULA.txt")))){
			Bukkit.getConsoleSender().sendMessage("[알림] 정상적인 EULA 문서입니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] EULA 수락 및 거절 여부를 확인합니다.");
			ArrayList<String> eula=new ArrayList<String>();
			String instring;
			while(true){
				instring=in.readLine();
				if(instring==null)break;
				eula.add(instring);
			}
			String a=eula.get(23);String b=eula.get(44);
			String[] a1=a.split(":");String[] b1=b.split(":");
			boolean a2=Boolean.parseBoolean(a1[1]);
			boolean b2=Boolean.parseBoolean(b1[1]);
			if(a2) Bukkit.getConsoleSender().sendMessage("[알림] 1장 EULA 수락 여부 : 수락");
			else Bukkit.getConsoleSender().sendMessage("[알림] 1장 EULA 수락 여부 : 거절");
			if(b2) Bukkit.getConsoleSender().sendMessage("[알림] 2장 EULA 수락 여부 : 수락");
			else Bukkit.getConsoleSender().sendMessage("[알림] 2장 EULA 수락 여부 : 거절");
			if(!(a2&&b2))
				Connection_Error.setError(4);
			Bukkit.getConsoleSender().sendMessage("[알림] EULA를 수락하셨습니다.");
		}
		catch(IOException e){Connection_Error.setError(3);}
		catch(Exception e){Connection_Error.setError(0);}
	}
	static class NetworkEULA{
		static void createEULA(){
				Bukkit.getConsoleSender().sendMessage("[알림] 파일 다운로드 진행 중...");
				try{
				int len=-1;
				URLConnection uc=new URL("http://mbsserver.oa.to/MBS_web_DB/eula.txt").openConnection();
				InputStream in=uc.getInputStream();
				FileOutputStream fos = new FileOutputStream(new File("M's Plugins EULA.txt"));
				byte[] buffer = new byte[512];
				while((len = in.read(buffer)) != -1)
			         fos.write(buffer, 0, len); 
				fos.close();
				Bukkit.getConsoleSender().sendMessage("[알림] EULA 문서 다운이 완료되었습니다.");
				Bukkit.getConsoleSender().sendMessage("[알림] EULA를 잘 읽고 수락 혹은 거절해주세요.");
			}
			catch(IOException e){Connection_Error.setError(404);LocalEULA.createEULA();}
			catch (Exception e){Connection_Error.setError(0);}
			finally{System.exit(0);}
		}
		static ArrayList<String> getEULA()throws Exception
		{
			ArrayList<String> eula=new ArrayList<String>();
			URLConnection uc = new URL("http://mbsserver.oa.to/MBS_web_DB/eula.txt").openConnection();
			BufferedReader in=new BufferedReader(new InputStreamReader( uc.getInputStream(),"MS949"));
			String a;
			while(true){
				a=in.readLine();
				if(a==null)break;
				eula.add(a);
			}
			in.close();
			return eula;
		}
		static void lookEULA(){
			try(BufferedReader in=new BufferedReader(new FileReader(new File("M's Plugins EULA.txt")));){
				ArrayList<String> eula=getEULA();
				Bukkit.getConsoleSender().sendMessage("[알림] 네크워크 문서를 이용한 EULA 문서 검토 중...");
				int count=0;String a;
				for(String e:eula){
					a=in.readLine();
					if(count==23||count==44){
						if(!(a.equals("1장 EULA 동의:false")||a.equals("2장 EULA 동의:false")||a.equals("1장 EULA 동의:true")||a.equals("2장 EULA 동의:true")))
							Connection_Error.setError(2);count++;continue;}
					if(!(a.equals(e)))
						Connection_Error.setError(2);
					count++;
				}
			}
			catch(IOException e){Connection_Error.setError(405);LocalEULA.lookEULA();}
			catch(Exception e){Connection_Error.setError(0);}
		}
	}
	static class LocalEULA{
		static void createEULA(){
			try(BufferedWriter out=new BufferedWriter(new FileWriter(new File("M's Plugins EULA.txt")))){
			List<String> eula=getEULA();
			for(String e:eula){
				out.write(e);out.newLine();
				}
			Bukkit.getConsoleSender().sendMessage("[알림] EULA 문서 다운이 완료되었습니다.");
			Bukkit.getConsoleSender().sendMessage("[알림] EULA를 잘 읽고 수락 혹은 거절해주세요.");
			Bukkit.shutdown();
			}
			catch(IOException e){Connection_Error.setError(3);}
			catch(Exception e){Connection_Error.setError(0);}
		}
		static ArrayList<String> getEULA(){
			ArrayList<String> eula=new ArrayList<String>();
			eula.add("이 계약서는 2015년 05월 04일에 작성 되었습니다.");
			eula.add("EULA를 잘 읽고 전부 수락해주세요.");
			eula.add("거절시에는 플러그인을 사용할 수 없습니다.");
			eula.add("이 문서를 변형, 변경하면 서버를 실행 할 수 없습니다.");
			eula.add("이 문서는 무료로 배포되는 플러그인에 적용됩니다.");
			eula.add("이 플러그인을 넣고 문서를 수락후 다시 실행될 시에 정보가 모두 저장됩니다.");
			eula.add("정보가 저장되면 무조건 이 문서의 계약에 동의한것으로 간주합니다.");
			eula.add("수락 거절만 눌러주세요.");
			eula.add("true 수락/false 거절");
			eula.add("단어 정의");
			eula.add("1. 사용자 - 플러그인을 사용 및 다운한 사람");
			eula.add("2. 제작자 - 플러그인을 제작한 사람");
			eula.add("플러그인 다운시 적용되는 규칙");
			eula.add("1장 - 플러그인 보호 계약");
			eula.add("1조. 사용자는 아래 정의 되어있는 규칙을 지켜야 합니다.");
			eula.add("1. 플러그인을 변조, 변형하지 않는다.");
			eula.add("플러그인 실행시 적용되는 규칙");
			eula.add("1장 - 사용자 정보 수집 계약");
			eula.add("1조. 사용자는 제작자에게 아래 정의 되어있는 정보를 제공합니다.");
			eula.add("1. 자신 서버의 아이피");
			eula.add("2. 자신이 사용중인 플러그인 목록");
			eula.add("3. 서버의 버전");
			eula.add("4. 서버의 온/오프라인 상태");
			eula.add("1장 EULA 동의:false");//24
			eula.add("2장 - 사용자 및 제작자의 의무 및 권한");
			eula.add("1조. 제작자는 아래 정의 되어있는 권한을 사용할 수 있습니다.");
			eula.add("1. 정당한 이유로 서버에게 플러그인을 제공하는것을 막을 권한");
			eula.add("2. 사용자의 플러그인 중 제작자가 제작한 플러그인을 업데이트 할 수 있는 권한");
			eula.add("3. 정당한 이유로 서버를 종료할 권한");
			eula.add("4. 플러그인을 변조해서 사용한 유저를 신고 및 고소 할 권한");
			eula.add("5. 유료 플러그인에 대한 값을 먼저 지불받을 권한");
			eula.add("2조. 제작자는 아래 정의 되어있는 의무를 지켜야 합니다.");
			eula.add("1. 빠르게 오류 수정할 의무");
			eula.add("2. 사용자의 정보를 수집용으로만 쓸 의무");
			eula.add("3. 돈을 지급받았을때 플러그인을 지급할 의무");
			eula.add("3조. 사용자는 아래 정의 되어있는 권한을 사용할 수 있습니다.");
			eula.add("1. 서버나 플러그인 사용이 차단된 경우 이의를 제기할 수 있는 권한");
			eula.add("2. 유료 플러그인 구매 후 지급 받기 전에 환불을 요청할 수 있는 권한");
			eula.add("4조. 사용자는 아래 정의 되어있는 의무를 지켜야 합니다.");
			eula.add("1. 플러그인을 변조, 변형하지 않을 의무");
			eula.add("2. 플러그인을 사용 설명서에 맞게 사용할 의무");
			eula.add("3. 플러그인을 무조건 최신 버전으로 업데이트할 의무");
			eula.add("4. 계약에 동의하고 이의를 주장하지 않을 의무");
			eula.add("5. 이 모든 플러그인 규칙을 지킬 의무");
			eula.add("2장 EULA 동의:false");//45
			return eula;
		}
		static void lookEULA(){
			try(BufferedReader in=new BufferedReader(new FileReader(new File("M's Plugins EULA.txt")));){
				ArrayList<String> eula=getEULA();
				int count=0;String a;
				Bukkit.getConsoleSender().sendMessage("[알림] 로컬 문서를 이용한 EULA 문서 검토 중...");
				for(String e:eula)
				{
					a=in.readLine();
					if(count==23||count==44){
						if(!(a.equalsIgnoreCase("1장 EULA 동의:false")||a.equalsIgnoreCase("2장 EULA 동의:false")||a.equalsIgnoreCase("1장 EULA 동의:true")||a.equalsIgnoreCase("2장 EULA 동의:true")))
							Connection_Error.setError(2);
						count++;continue;}
					if(!(a.equals(e)))
						Connection_Error.setError(2);
					count++;
				}
			}
			catch(IOException e){Connection_Error.setError(3);}
			catch(Exception e){Connection_Error.setError(0);}
		}
	}
}
