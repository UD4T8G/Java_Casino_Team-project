package core;

public class GameManager {
	void status(User u) {
		
		
		System.out.println();

	    System.out.println("╔════════════ PLAYER STATUS ════════════╗");
	    System.out.printf("║ 이름 : %-28s   \n",u.getName());
	    System.out.printf("║ 현금 : %,-28d   \n",u.getMoney());
	    System.out.printf("║ 코인 : %,-28d   \n",u.getCoin());
	    System.out.printf("║ 빚   : %,-28d   \n",u.getDebt());
	    
	    if(u.getDebtTime() == -1) {
	    		System.out.printf("║ 남은 기간 : 빚이 없음!               \n");
		}else {
			System.out.printf("║ 남은 기간 : %-23d\n",u.getDebtTime());
		}
	    
	    System.out.println("╚═══════════════════════════════════════╝");
		
		
		
		
		
		
	}
}