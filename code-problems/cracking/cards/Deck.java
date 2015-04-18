import java.util.*;

public class Deck {
    
    private ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();

        // Populate the list of cards with a standard 52-card deck
        for (Suit suit : Suit.values()) {
            for (short i = 2; i <= 14; i++) {
                cards.add(new Card(suit, i)); 
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < cards.size(); i++) {
            if (i == cards.size() - 1) 
                sb.append(cards.get(i).toString());
            else 
                sb.append(cards.get(i).toString() + ", ");
        }
        sb.append("]");
        return sb.toString();
    }
    
}
