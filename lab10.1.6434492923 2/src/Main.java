public class Main {

    public static void main(String[] args) {
	// write your code here
        AVLTree tree = new AVLTree();         tree.add(8);         tree.add(4);         tree.add(7);         tree.add(40);         tree.add(15);         tree.add(13);         tree.add(13);         tree.printTree();         tree.remove(40); tree.printTree();
    }
}
