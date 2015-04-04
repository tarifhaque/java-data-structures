/* * * * * * * * * * * * * * * * * * *
 * Given two strings, write a method to determine if one is a 
 * permutation of the other.
 * * * * */ 

public class StringPermutation {

    public static boolean isPermutation(String a, String b) {
        if (a.length() != b.length()) return false; 
        
        int[] aCounts = new int[128];
        int[] bCounts = new int[128];
     
        for (int i = 0; i < a.length(); i++) {
          aCounts[a.charAt(i)]++;
          bCounts[b.charAt(i)]++; 
        }

        for (int i = 0; i < a.length(); i++) {
            if (aCounts[i] != bCounts[i]) return false;  
        }
     
        return true; 
    }

    public static void testPermutation(String a, String b) {
        boolean result = isPermutation(a, b);
        String output = "is a permutation of";
        if (!result) output = "is not a permutation of";
        System.out.printf("\"%s\" %s \"%s\"\n", a, output, b);
    }

    public static void main(String[] args) {
       testPermutation("abc", "bca");
       testPermutation("you are crazy!", "!crazy you are");
       testPermutation("hello?", "hello");
    }
}
