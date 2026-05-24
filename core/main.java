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
		System.out.print("보유 현금 입력 : ");
		System.out.println();
		int money = s.nextInt();
		User u = new User(name, money);
		
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
					System.out.println("cheat ON");
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
