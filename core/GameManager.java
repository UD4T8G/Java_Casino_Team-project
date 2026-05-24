package core;

public class GameManager {
	void status(User u) {
		System.out.println("당신의 이름 : " + u.getName());
		System.out.println("현재 소지금 : " + u.getMoney());
		System.out.println("현재 코인 : " + u.getCoin());
		System.out.println("현재 빛 : " + u.getDebt());
		if(u.getDebtTime() == -1) {
			System.out.println("남은 상환 기간 : 빚이 없습니다!");
		}else {
			System.out.println("남은 상환 기간 : " + u.getDebtTime());
		}
		
		System.out.println("행동 선택");
		
		System.out.printf("1. 게임장1 이동\n2. 게임장2 이동\n3. 코인으로 환전하기\n4. 돈으로 환전하기\n5. 빚 신청하기\n6. 빚 탕감하기\n7. 게임 종료하기");
		
	}
}