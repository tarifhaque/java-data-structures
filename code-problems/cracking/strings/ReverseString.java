/* * * * * * * * * 
 * Simple static method that reverses a String.
 * Done in-place.
 * * * * * * * * * * */

public class ReverseString {
 
  public static String reverseString(String str) {
    char[] array = str.toCharArray();
    for (int i = 0; i < array.length / 2; i++) {
        char temp = array[i];
        array[i] = array[array.length - 1 - i];
        array[array.length - 1 - i] = temp;
    }
    return new String(array);
  }

  public static void main(String[] args) {
    String string = "helloworld!";
    System.out.println("String to reverse: " + string);
    String reversedString = reverseString(string);
    System.out.println("Reversed string: " + reversedString);
  }

}
