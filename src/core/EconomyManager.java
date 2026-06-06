package core;

import java.util.Scanner;

public class EconomyManager {
	private int Scale = 10000;
	
	void changeToCoin(User u) {
		Scanner s = new Scanner(System.in);

		System.out.println("💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎");
		System.out.println("돈을 코인으로 얼마나 바꾸시겠습니까? (10000원 = 1코인)");
		System.out.println("💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎");
		System.out.print("입력 >");
		int MoneyForCoin = s.nextInt();
		int UserMoney = u.getMoney();
		
		if((UserMoney - MoneyForCoin) < 0) {
			System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
			System.out.println("소지하고 계신 금액이 부족해 보입니다 손님.");
			System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
			return;
		}
		
		UserMoney -= MoneyForCoin;
		u.setMoney(UserMoney); //유저의 현금줄이기
		u.add_ending_money(MoneyForCoin); //통계용 사용한 돈 증가
		
		int ChargedCoin = MoneyForCoin / Scale; //환전
		
		if (u instanceof VIP_User) {
			System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
			System.out.println("VIP혜택 1.2배로 인한 추가 코인을 획득하였습니다");
			System.out.println("✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨✨");
			ChargedCoin += (MoneyForCoin / 50000); //1.2배의 효율을 줌
		}
		
		ChargedCoin += u.getCoin(); //유저의 코인늘리기
		u.setCoin(ChargedCoin);
		System.out.print("돈 -> 코인 환전완료");
		
		return;
	}
	
	
	
	void changeToMoney(User u) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎");
		System.out.println("코인을 돈으로 얼마나 바꾸시겠습니까? (1코인 = 10000원)");
		System.out.println("💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎💎");
		System.out.print("입력 >");
		int CoinForMoney = s.nextInt();
		int UserCoin = u.getCoin();
		if((UserCoin - CoinForMoney) < 0) {
			System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
			System.out.println("소지하고 계신 코인이 부족해 보입니다 손님.");
			System.out.println("❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗❗");
			return;
		}
		UserCoin -= CoinForMoney;
		u.setCoin(UserCoin); //유저의 코인줄이기
		
		int ChargedMoney = CoinForMoney*Scale; //코인 -> 돈 환전
		
		ChargedMoney += u.getMoney(); //유저의 돈늘리기
		u.setMoney(ChargedMoney);
		
		System.out.print("코인 -> 돈 환전완료");
		
		return;
	}
	
}
