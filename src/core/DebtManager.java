package core;

import java.util.Scanner;

public class DebtManager {
	
	void moneyToDebt(User u) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("💲💲💲💲💲💲💲💲💲💲💲💲💲💲💲💲💲");
		System.out.println(" 얼마만큼 빚지겠습니까?(빚은 1억 초과 불가능)");
		System.out.println("💲💲💲💲💲💲💲💲💲💲💲💲💲💲💲💲💲");
		System.out.print("입력 >");
		int debt = s.nextInt();
		int UserDebt = u.getDebt();
		if((UserDebt + debt) > 100000000) {
			System.out.println("빚은 1억을 넘기실 수 없습니다....고.객.님?");
			return;
		}
		UserDebt += debt;
		u.setDebt(UserDebt); //유저의 빚늘리기
		
		int UserMoney = u.getMoney();
		UserMoney += debt;
		u.setMoney(UserMoney); //유저의 돈늘리기
		
		u.add_ending_debt(debt); //통계용 늘어난 빚 증가
		
		System.out.print("🪙빚내기 완료🪙");
		if(u.getDebtTime() == -1) {
			u.setDebtTime(72); //처음 빚 냈을때 72시간 설정
		}
		
		return;
	}
	
	void debtToMoney(User u) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("💲💲💲💲💲💲💲💲💲💲💲💲");
		System.out.println(" 얼마만큼 빚을 상환하시겠습니까?");
		System.out.println("💲💲💲💲💲💲💲💲💲💲💲💲");
		System.out.print("입력 >");
		int debt = s.nextInt();
		int UserDebt = u.getDebt();
		int UserMoney = u.getMoney();
		
		if(UserMoney < debt) {
			System.out.println(" \"소지금이 부족해 보이십니다.\"");
			return;
		}
			
		if((UserDebt - debt) < 0) {
			UserMoney = u.getMoney();
			UserMoney -= UserDebt;
			u.setMoney(UserMoney); //유저의 돈 줄이기(최대치만큼)
			u.setDebt(0); //유저의 빚 없애기
			u.setDebtTime(-1);
			System.out.println(" \"가지신 빚보다 돈을 더 주시다니.. 기부하시려구요?\"");
			System.out.println(" \"거스름돈은 돌려드리겠습니다.\"");
			System.out.println(" 🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙");
			System.out.println("🪙  빚을 모두 상환했습니다!  🪙");
			System.out.println(" 🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙");
			return;
		}
		
		UserDebt -= debt;
		u.setDebt(UserDebt); //유저의 빚줄이기
		
		
		UserMoney -= debt;
		u.setMoney(UserMoney); //유저의 돈 줄이기
		
		System.out.print("🪙빚 상환 완료🪙");
		if(u.getDebtTime() > 0 && u.getDebt() == 0) {
			u.setDebtTime(-1);
			System.out.println(" 🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙");
			System.out.println("🪙  빚을 모두 상환했습니다!  🪙");
			System.out.println(" 🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙🪙");
		}
		return;
	}
}
