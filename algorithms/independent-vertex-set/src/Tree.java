public class Tree {

    private class Vertex {
        int value;
        Vertex parent;
        Vertex firstChild;
        Vertex nextSibling;

        public Vertex(int value) {
            this.value = value;
        }

        public String string() {
            return Integer.toString(value);
        }
    }

    Vertex root;
    int treeSize;

    public Tree() {

    }

    public void insert(int i) {
        Vertex vertex = new Vertex(i);
        insert(this.root, vertex);
    }

    private void insert(Vertex root, Vertex vertex) {

    }

    public void insert(int[] numbers) {

    }

    public void traverse(Vertex root) {
        System.out.print(root.string() + " ");
        if (root.firstChild == null) return;
        traverse(root.firstChild);
    }

}
