package core;

import java.util.Scanner;
import game1.Game1;
import game2.game2_main;

public class main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		GameManager GM = new GameManager();
		EconomyManager EM = new EconomyManager();
		DebtManager DM = new DebtManager();
		TimeManager TM = new TimeManager();
		Game1 game1 = new Game1(); //태현이 메인
		
		
		
		System.out.println("JAVA 게임장에 오신 걸 환영합니다!");
		
		System.out.print("유저 이름 입력 : ");
		System.out.println();
		String name = s.next();
		
		System.out.print("VIP이시라면 비밀번호 네자리를 입력해주세요 : ");
		System.out.println();
		int VIP_Code = s.nextInt();
		
		
		
		System.out.print("보유 현금 입력 : ");
		System.out.println();
		int money = s.nextInt();
		
		User u; 
		
		if(VIP_Code == 2005) {
			u = new VIP_User(name,money);
			System.out.println("VIP께서 입장하셨습니다.");
		}else {
			System.out.println("손님 한 분 입장하셨습니다.");
		}
		
		if (money == -67) {
			// 입력받은 돈이 -67이면 다형성을 이용해 Admin_User 객체를 u에 대입
			u = new Admin_User(name, money);
			System.out.println("★ [시스템] 관리자 권한(Admin_User)이 활성화되었습니다. ★");
		} else if (VIP_Code == 2005){
			// 그 외의 경우는 일반 User 객체를 생성
			u = new VIP_User(name, money);
		} else {
			u = new User(name, money);
		}
		
		
		int select = 0;
		

		while(select != 7) {
			if(TM.debtTimeCheck(u) == 0) { //게임오버
				select = 7;
				break;
			}
			GM.status(u);
			select = s.nextInt();
			switch(select) {
				case 1:
					game1.start(u, s);
					if(TM.debtTimeCheck(u) == 0) {
						select = 7;
						System.out.println("빚을 갚지 못했습니다 게임오버");
					}
					break;
				case 2:
					game2_main.start(u,s);
					if(TM.debtTimeCheck(u) == 0) {
						select = 7;
						System.out.println("빚을 갚지 못했습니다 게임오버");
					}
					TM.debtTimeDown(u,1);
					break;
				case 3:
					EM.changeToCoin(u);
					break;
				case 4:
					EM.changeToMoney(u);
					break;
				case 5:
					DM.moneyToDebt(u);
					break;
				case 6:
					DM.debtToMoney(u);
					break;
				case 7:
					select = 7;
					break;
				case 67 :
					if (u instanceof Admin_User) {
				        // 형변환(Downcasting)을 통해 Admin_User 고유 기능에 접근
				        Admin_User admin = (Admin_User) u;
				        System.out.println("관리자 버프 발동! 치트 코드: " + admin.getCheat());
				        System.out.print("금액을 설정하세요(입력된 금액으로 설정됩니다) : "); // 값을 바로 옆에 입력받도록 print로 수정
				        
				        int cheatMoney = s.nextInt(); 
				        u.setMoney(cheatMoney); 
				        
				        System.out.println("치트 적용 완료! 현재 자산: " + u.getMoney() + "원");
				    } else {
				        System.out.println("치트 권한이 없습니다.");
				    }
					break;
				default:
					System.out.println("올바른 숫자를 입력하세요");
					break;
			}
		}
		
		System.out.print("게임오버");


		
		
		s.close();
	}

}
