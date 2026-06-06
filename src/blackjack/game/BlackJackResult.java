package blackjack.game;

public class BlackJackResult {
    private final BlackJackExitStatus status;
    private final int gamesPlayed;
    private final int finalCoin;

    public BlackJackResult(BlackJackExitStatus status, int gamesPlayed, int finalCoin) {
        this.status = status;
        this.gamesPlayed = gamesPlayed;
        this.finalCoin = finalCoin;
    }

    public BlackJackExitStatus getStatus() { return status; }
    public int getGamesPlayed() { return gamesPlayed; }
    public int getFinalCoin() { return finalCoin; }
}