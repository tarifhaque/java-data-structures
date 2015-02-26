public class Main {

    public static void main(String[] args) {

        /* Construct an 8-bit binary counter. */
        BinaryCounter counter = new BinaryCounter(2);

        /* Initial counter. */
        System.out.println("Initial counter: " + counter.string());
        counter.increment(4);
        counter.printCounter();

    }
    
}
