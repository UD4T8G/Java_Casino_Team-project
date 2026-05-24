package slotmachine.slot;

public enum Symbol {
    SEVEN(128, 7, "7"),
    SIX(64, 6, "6"),
    FIVE(32, 5, "5"),
    FOUR(16, 4, "4"),
    THREE(8, 3, "3"),
    TWO(4, 2, "2"),
    ONE(2, 1, "1");

	private final int jackpotMultiplier;
    private final int luckydogMultiplier;
    private final String icon;

    Symbol(int jackpotMultiplier, int luckydogMultiplier, String icon) {
        this.jackpotMultiplier = jackpotMultiplier;
        this.luckydogMultiplier = luckydogMultiplier;
        this.icon = icon;
    }

    public int getJackpotMultiplier() { return jackpotMultiplier; }
    public int getLuckydogMultiplier() { return luckydogMultiplier; }
    public String getIcon() { return icon; }
}