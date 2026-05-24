package core;

public class StatusView {

    public void printStatus(User user) { 
        System.out.println("\n=================================");
        System.out.printf("이름: %s\n", user.getName());
        System.out.printf("현재 돈: %,d 원\n", user.getMoney());
        System.out.printf("현재 코인: %,d C\n", user.getCoin());
        System.out.printf("남은 빚: %,d 원\n", user.getDebt());
        System.out.printf("남은 시간: %d 시간\n", user.getDebtTime());
        System.out.println("=================================");
    }
}