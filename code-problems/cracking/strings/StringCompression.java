public class StringCompression {

    public static String stringCompression(String input) {
        String str = "";
        if (input.length() < 1) return str;
        char[] array = input.toCharArray();
        int counter = 1; // because string has at least one char

        char prev = array[0];
        char next;

        // while the next letter == prev letter, increment count
        for (int i = 1; i < array.length; i++) {
            prev = array[i - 1];
            next = array[i];
            if (next == prev) counter++;
            else {
                str = str + prev + Integer.toString(counter);
                counter = 1;
            }
        }

        // handle the last character
        str = str + prev + Integer.toString(counter);

        if (str.length() < input.length()) return str;
        else return input;
    }

    public static void main(String[] args) {
        String compressed = stringCompression("aabbccdddeeee");
        System.out.println(compressed);
    }

}
