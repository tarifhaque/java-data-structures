/* * * * * *
 * This class offers the space() method, which breaks up
 * a string of words with no spaces into a string with
 * the appropriate spaces.
 *
 * Tarif Haque
 * */

import java.util.*;
import java.io.*;

public class WordSpacer {

    HashSet<String> words;

    public WordSpacer() {
        words = new HashSet<String>();
        fillWords(words);
    }

    private void fillWords(HashSet<String> words) {
        Scanner sc; 
        try {
            sc = new Scanner(new File("words.txt"));
            while(sc.hasNext()) {
                words.add(sc.next()); 
            }
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String wordsToString(HashSet<String> words) {
        Iterator iterator = words.iterator();
        String wordlist = ""; 
        while (iterator.hasNext()) {
            wordlist += iterator.next() + " "; 
        }
        return wordlist;
    }

    public String getWordList() {
        return wordsToString(words); 
    }

    public String space(String sequence) {
        String output = "";
        String currentword = "";

        for (int i = 0; i < sequence.length(); i++) {
            currentword += sequence.substring(i, i+1); 
            if (words.contains(currentword)) {
                output += currentword + " ";
                currentword = ""; 
            }
        }
        
        return output; 
    }

}
