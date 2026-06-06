package blackjack.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
    }

    private void initializeDeck() {
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                int value = (i < 9) ? i + 2 : (ranks[i].equals("A") ? 11 : 10);
                cards.add(new Card(suit + ranks[i], value));
            }
        }
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            initializeDeck(); // 카드가 다 떨어지면 새로 섞기
        }
        return cards.remove(0);
    }
}