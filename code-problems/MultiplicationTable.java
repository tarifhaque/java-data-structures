public class MultiplicationTable {

    private static void printMultiplicationTable(int row, int col) {
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                System.out.print(Integer.toString(i * j) + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printMultiplicationTable(12, 12);
    }

}
