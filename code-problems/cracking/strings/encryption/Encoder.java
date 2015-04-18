public class Encoder {

    public String encode(String message) {
        String encoded = "";
        for (int i = 0; i < message.length(); i++) {
            char letter = (char) (message.charAt(i) + 2); 
            encoded = encoded + letter;
        }
        return encoded;
    }

    public String decode(String message) {
        String decoded = "";
        for (int i = 0; i < message.length(); i++) {
            char letter = (char) (message.charAt(i) - 2);
            decoded = decoded + letter;
        }
        return decoded;
    }

    public static void main(String[] args) {
        String originalMessage = "My name is Tarif!"; 
        
        Encoder encoder = new Encoder();
        String encodedMessage = encoder.encode(originalMessage);
        String decodedMessage = encoder.decode(encodedMessage);

        System.out.println("Original message: " + originalMessage);
        System.out.println("Encoded message: " + encodedMessage);
        System.out.println("Decoded encoded message: " + decodedMessage);
    }

}
