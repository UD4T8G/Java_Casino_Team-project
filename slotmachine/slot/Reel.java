package slotmachine.slot;

import java.util.Random;

public class Reel {
    private static final Symbol[] SYMBOLS = Symbol.values();
    private final Random random = new Random();

    public Symbol spin() { 
        return SYMBOLS[random.nextInt(SYMBOLS.length)]; 
    }
}