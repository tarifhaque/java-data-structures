import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       
        /* Create empty binary tree */
        BinaryTree tree = new BinaryTree();

        /* Populate binary tree with data from input file. */ 
        File file = new File("input.txt");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextInt()) {
                int i = scanner.nextInt();
                tree.insert(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
       
        /* Depth-first traversals. */
        tree.preorder();
        tree.inorder();
        tree.postorder();

        /* Breadth-first traversal. */
        tree.levelorder();

        /* Find median. */
        tree.printInorder();
        double x = tree.findMedian();
        System.out.println("Median: " + Double.toString(x));
    }

}
