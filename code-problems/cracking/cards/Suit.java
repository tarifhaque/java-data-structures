public enum Suit {
    HEARTS ("Hearts"), 
    CLUBS ("Clubs"),
    SPADES ("Spades"),
    DIAMONDS ("Diamonds");
   
    private final String suitName;

    Suit(String name) {
        this.suitName = name;
    }

    public String toString() {
        return suitName; 
    }
}
