/* * *
 * Write a method to print all permutations of a string with unique 
 * characters.
 * * */

import java.util.*;

public class StringPermutations {

    public static void printList(ArrayList<String> strings) {
        for (String word : strings) {
            System.out.print(word + " "); 
        }
        System.out.println();
    }
    
    public static ArrayList<String> permutations(String in) {
        // add the empty string to a new list of strings 
        ArrayList<String> stringlist = new ArrayList<String>();
        stringlist.add("");
        return permutations(in, stringlist, 1); 
    }

    private static ArrayList<String> permutations(String in, ArrayList<String>
            stringlist, int count) {
       
        // populate with permutations of size count
        ArrayList<String> allwords  = new ArrayList<String>();

        // base case 
        if (count == in.length() + 1) return stringlist;
        else {
            for (String s : stringlist) {
                allwords.addAll(insertCharInString(in.charAt(count - 1), s));
            }
        }
        
        count++;

        return permutations(in, allwords, count); 

    }

    /* * * * *
     * Given a character and string, inserts the character between 
     * each letter in the string, creating a list of new strings with 
     * the character.
     * * */
    private static ArrayList<String> insertCharInString(char letter, String word) {
        ArrayList<String> strings = new ArrayList<String>();
        
        for (int i = 0; i < word.length() + 1; i++) {
            String x = word.substring(0,i) + letter + 
                word.substring(i, word.length());
            strings.add(x);
        }

        return strings;
    
    }

    public static void main(String[] args) {
        ArrayList<String> words = StringPermutations.permutations("young"); 
        StringPermutations.printList(words); 
    }

}
