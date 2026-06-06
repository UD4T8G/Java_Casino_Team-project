package core;

import java.util.Scanner;

public class EconomyManager {
	private int Scale = 10000;
	
	void changeToCoin(User u) {
		Scanner s = new Scanner(System.in);

		
		System.out.println("돈을 코인으로 얼마나 바꾸시겠습니까? : ");
		int MoneyForCoin = s.nextInt();
		int UserMoney = u.getMoney();
		UserMoney -= MoneyForCoin;
		u.setMoney(UserMoney); //유저의 현금줄이기
		
		int ChargedCoin = MoneyForCoin / Scale; //환전
		
		if (u instanceof VIP_User) {
			System.out.println("VIP혜택 1.2배로 인한 추가 코인을 획득하였습니다");
			ChargedCoin += (MoneyForCoin / 50000); //1.2배의 효율을 줌
		}
		
		ChargedCoin += u.getCoin(); //유저의 코인늘리기
		u.setCoin(ChargedCoin);
		System.out.print("돈 -> 코인 환전완료");
		

	}
	
	
	
	void changeToMoney(User u) {
		Scanner s = new Scanner(System.in);

		System.out.println("코인을 돈으로 얼마나 바꾸시겠습니까? : ");
		int CoinForMoney = s.nextInt();
		int UserCoin = u.getCoin();
		UserCoin -= CoinForMoney;
		u.setCoin(UserCoin); //유저의 코인줄이기
		
		int ChargedMoney = CoinForMoney*Scale; //코인 -> 돈 환전
		
		ChargedMoney += u.getMoney(); //유저의 돈늘리기
		u.setMoney(ChargedMoney);
		
		System.out.print("코인 -> 돈 환전완료");
		

	}
	
}
