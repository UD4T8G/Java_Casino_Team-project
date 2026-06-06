package core;

public class User {
	private String name;
	private int money;
	private int coin;
	private int debt;
	private int debtTime = -1;
	private int ending_money = 0;
	private int ending_debt = 0;
	
	
	User(String name, int money){
		this.name = name;
		this.money = money;
	}
	
	// 필드값 참조
	
	String getName() { return name; }
	
	public int getMoney() { return money; }
	
	public int getCoin() { return coin; }
	
	public int getDebt() { return debt; }
	
	public int getDebtTime() { return debtTime; }
	
	public int get_ending_money() { return ending_money; }

	public int get_ending_debt() { return ending_debt; }
	
	// 필드 재설정
	
	public void setName(String name) { this.name = name; }
	
	public void setMoney(int money) { this.money = money; }
	
	public void setCoin(int coin) { this.coin = coin; }
	
	public void setDebt(int debt) { this.debt = debt; }
	
	public void setDebtTime(int debtTime) { this.debtTime = debtTime; }
	
	//엔딩 때 출력할 통계용 메소드
	
	public void add_ending_money(int add) {
		ending_money += add;
		return;
	}
	
	public void add_ending_debt(int add) {
		ending_debt += add;
		return;
	}
	
	//빚시간줄이기
	
	public void decreaseDebtTime(int hours) {
		if(debtTime != -1) {
			this.debtTime -= hours;
		}
	}
	
}
