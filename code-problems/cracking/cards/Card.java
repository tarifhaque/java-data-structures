public class Card {

    private short kind; // can be values 2 - 14 
    private Suit suit; 

    public Card(Suit suit, short kind) {
        this.kind = kind;
        this.suit = suit;
    }

    private String kindToString(short k) {
        if (k <= 10) return String.valueOf(kind);
        else if (k == 11) return "Jack";
        else if (k == 12) return "Queen";
        else if (k == 13) return "King";
        else return "Ace";
    }

    public String toString() {
        return kindToString(kind) + " of " + suit.toString();  
    }

}
