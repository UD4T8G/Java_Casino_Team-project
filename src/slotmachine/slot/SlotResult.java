package slotmachine.slot;

public class SlotResult {
    private final SlotExitStatus status;
    private final int gamesPlayed;
    private final int finalCoin; // 외부 반환 코인

    public SlotResult(SlotExitStatus status, int gamesPlayed, int finalCoin) {
        this.status = status;
        this.gamesPlayed = gamesPlayed;
        this.finalCoin = finalCoin;
    }

    public SlotExitStatus getStatus() { return status; }
    public int getGamesPlayed() { return gamesPlayed; }
    public int getFinalCoin() { return finalCoin; } // 외부 호출 코인
}