public class NumberGrid {

    private int[][] grid;

    public NumberGrid(int[][] array2D) {
        this.grid = array2D;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NumberGrid grid = new NumberGrid(grid); 
    }

}
