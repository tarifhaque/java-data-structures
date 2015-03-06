public class Main {
    
    public static void main(String[] args) {
        WordSpacer spacer = new WordSpacer();
        System.out.println(spacer.getWordList());
        String spaced = spacer.space("hellohowareyou");
        System.out.println(spaced);
    }

}
