package blackjack.game;

import java.util.Scanner;

public class BlackJackManager {
    private final Scanner scanner = new Scanner(System.in);
    private final Deck deck = new Deck(); 

    public BlackJackResult playBlackJack(int currentCoin) {
        System.out.println("\n=== 블랙잭에 입장합니다. ===");
        int gamesPlayed = 0;

        while (true) {
            System.out.println("----------------------------------------");
            System.out.println("보유 코인: " + currentCoin + "C");

            if (currentCoin <= 0) {
                System.out.println("코인이 없습니다. 블랙잭에서 퇴장합니다.");
                return new BlackJackResult(BlackJackExitStatus.BANKRUPT, gamesPlayed, currentCoin);
            }

            System.out.print("베팅할 코인을 입력하세요 (0 입력 시 테이블 떠나기): ");
            int betAmount;
            try {
                betAmount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력해주세요.");
                continue;
            }

            if (betAmount == 0) {
                System.out.println("블랙잭에서 퇴장합니다.");
                return new BlackJackResult(BlackJackExitStatus.USER_EXIT, gamesPlayed, currentCoin);
            }

            if (betAmount < 0 || betAmount > currentCoin) {
                System.out.println("코인이 부족하거나 잘못된 입력입니다.");
                continue;
            }

            currentCoin -= betAmount;
            gamesPlayed++;

            currentCoin = playSingleRound(currentCoin, betAmount);
        }
    }

    private int playSingleRound(int currentCoin, int betAmount) {
        Card playerCard1 = deck.drawCard();
        Card playerCard2 = deck.drawCard();
        int playerSum = playerCard1.getValue() + playerCard2.getValue();

        Card dealerCard1 = deck.drawCard();
        Card dealerCard2 = deck.drawCard();
        int dealerSum = dealerCard1.getValue() + dealerCard2.getValue();

        System.out.println("\n[딜러의 공개된 카드 1장]: " + dealerCard1.getName()); 
        System.out.println("[당신의 카드]: " + playerCard1.getName() + ", " + playerCard2.getName() + " (합: " + playerSum + ")");

        while (playerSum < 21) {
            System.out.print("카드를 더 받으시겠습니까? (1: Hit, 2: Stand): ");
            String choice = scanner.nextLine();
            
            if (choice.equals("1")) {
                Card newCard = deck.drawCard();
                playerSum += newCard.getValue();
                System.out.println("뽑은 카드: " + newCard.getName() + " | 현재 합: " + playerSum);
            } else if (choice.equals("2")) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        if (playerSum > 21) {
            System.out.println("Bust! 21을 초과하여 패배했습니다.");
            return currentCoin; 
        }

        // 딜러 턴 (16 이하면 무조건 Hit)
        System.out.println("\n딜러가 카드를 뒤집습니다. (숨겨진 카드: " + dealerCard2.getName() + ") 딜러의 최종 합: " + dealerSum);
        while (dealerSum <= 16) {
            Card newCard = deck.drawCard();
            dealerSum += newCard.getValue();
            System.out.println("딜러가 카드를 뽑습니다: " + newCard.getName() + " | 딜러의 합: " + dealerSum);
        }

        // 승패 판정
        if (dealerSum > 21 || playerSum > dealerSum) {
            int winnings = betAmount * 2;
            currentCoin += winnings;
            System.out.println("승리하셨습니다! 상금: " + winnings + "C");
        } else if (playerSum == dealerSum) {
            currentCoin += betAmount;
            System.out.println("무승부(Push)입니다. 베팅금을 돌려받습니다.");
        } else {
            System.out.println("딜러 승리. 패배하셨습니다.");
        }

        return currentCoin;
    }
}