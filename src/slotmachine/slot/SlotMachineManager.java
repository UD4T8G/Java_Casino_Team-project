package slotmachine.slot;

import java.util.Scanner;

public class SlotMachineManager {
    private final Reel[] reels = {new Reel(), new Reel(), new Reel()};
    private final Scanner scanner = new Scanner(System.in);

    public SlotResult playSlotGame(int currentCoin) {
        System.out.println("\n=== 슬롯머신에 입장합니다. ===");
        int gamesPlayed = 0;

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("보유 코인: " + currentCoin + "C");
            
            if (currentCoin <= 0) {
                System.out.println("코인이 없습니다. 슬롯머신에서 퇴장합니다.");
                // 최종 코인과 함께 결과 반환
                return new SlotResult(SlotExitStatus.BANKRUPT, gamesPlayed, currentCoin);
            }

            System.out.print("베팅할 코인을 입력하세요.(0 입력 시 슬롯머신 종료): ");
            int betAmount;
            try {
                betAmount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            if (betAmount == 0) {
                System.out.println("슬롯머신에서 퇴장합니다.");
                return new SlotResult(SlotExitStatus.USER_EXIT, gamesPlayed, currentCoin);
            }

            if (betAmount < 0 || betAmount > currentCoin) {
                System.out.println("코인이 부족하거나 잘못된 입력입니다.");
                continue;
            }

            currentCoin -= betAmount;
            gamesPlayed++; 

            currentCoin = spinAndPrintResult(currentCoin, betAmount);
        }
    }

    private int spinAndPrintResult(int currentCoin, int betAmount) {
        Symbol[] result = new Symbol[3];
        for (int i = 0; i < reels.length; i++) {
            result[i] = reels[i].spin();
        }

        System.out.println("\n잠시만 기다려주세요...");
        System.out.printf("[ %s | %s | %s ]\n", result[0].getIcon(), result[1].getIcon(), result[2].getIcon());

        if (result[0] == result[1] && result[1] == result[2]) {
            int winnings = betAmount * result[1].getJackpotMultiplier();
            currentCoin += winnings;
            System.out.println("JACKPOT!");
            System.out.println("상금: " + winnings + "C");
        }
        else if (result[0] == result[1] || result[0] == result[2]) {
        	int winnings = betAmount * result[0].getLuckydogMultiplier();
            currentCoin += winnings;
            System.out.println("LUCKY DOG!");
            System.out.println("상금: " + winnings + "C");
        }
        else if (result[1] == result[2]) {
        	int winnings = betAmount * result[1].getLuckydogMultiplier();
            currentCoin += winnings;
            System.out.println("LUCKY DOG!");
            System.out.println("상금: " + winnings + "C");
        }
        else {
            System.out.println("NO PRIZE!");
            System.out.println("상금: 0C");
        }
        
        return currentCoin; // 코인 반환
    }
}