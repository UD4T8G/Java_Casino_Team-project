package core;

import java.util.Scanner;

public class DebtManager {
	
	void moneyToDebt(User u) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("얼마만큼 빚지겠습니까? : ");
		int debt = s.nextInt();
		int UserDebt = u.getDebt();
		UserDebt += debt;
		u.setDebt(UserDebt); //유저의 빚늘리기
		
		int UserMoney = u.getMoney();
		UserMoney += debt;
		u.setMoney(UserMoney);
		
		System.out.print("빚내기 완료");
		if(u.getDebtTime() == -1) {
			u.setDebtTime(72); //처음 빚 냈을때 72시간 설정
		}
		
	}
	
	void debtToMoney(User u) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("얼마만큼 빚을 상환하시겠습니까? : ");
		int debt = s.nextInt();
		int UserDebt = u.getDebt();
		UserDebt -= debt;
		u.setDebt(UserDebt); //유저의 빚줄이기
		
		int UserMoney = u.getMoney();
		UserMoney -= debt;
		u.setMoney(UserMoney);
		
		System.out.print("빚 상환 완료");
		if(u.getDebtTime() > 0 && u.getDebt() == 0) {
			u.setDebtTime(-1);
			System.out.println("빚을 모두 상환했습니다!");
		}
		
	}
}
