/* * * * * * * * * * * * * * * * * * * * * * * * * * *  
 * Implement an algorithm to determine if a string has 
 * all unique characters.
 * * * * * * */

import java.util.*;

public class UniqueCharacters {

    public static boolean hasUniqueCharacters(String string) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < string.length(); i++) {
            Integer count = map.get(string.charAt(i));
            if (count == null) map.put(string.charAt(i), 1);
            else return false; 
        }

        return true;
    }

    public static void testString(String string) {
        boolean result = hasUniqueCharacters(string);
        String output = "has all unique characters!";
        if (!result) output = "does not have all unique characters!";
        System.out.printf("\"%s\" %s\n", string, output);
    }

    public static void main(String[] args) {
        testString("young");
        testString("how are you?");
    }

}
