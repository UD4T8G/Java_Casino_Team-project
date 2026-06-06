package blackjack;

import blackjack.game.BlackJackManager;
import blackjack.game.BlackJackResult;

public class BlackJack {
    private final BlackJackManager gameManager;

    public BlackJack() {
        this.gameManager = new BlackJackManager();
    }

    public int startBlackJackModule(int initialCoin) {
        if (initialCoin <= 0) {
            System.out.println("코인이 부족합니다.");
            return initialCoin;
        }
        
        BlackJackResult result = gameManager.playBlackJack(initialCoin);

        System.out.println("기록: 총 " + result.getGamesPlayed() + "회 라운드 진행");
        
        return result.getFinalCoin(); // 코인 반환
    }
}