package core;

public class TimeManager {
	
	// DebtTime을 time으로 설정
	void debtTimeSet(User u,int time) {
		u.setDebtTime(time);
	}
	
	// DebtTime에서 time을 뺌
	void debtTimeDown(User u,int time) {
		int timeNow;
		timeNow = u.getDebtTime();
		if(timeNow != -1) {
			timeNow -= time;
			u.setDebtTime(timeNow);
		}
		
	}
	
	// 1이면 정상 0이면 타임오버
	int debtTimeCheck(User u) {
		if(u.getDebtTime() == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
}
