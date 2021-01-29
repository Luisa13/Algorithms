package tree;

public class App {

	public static void main(String[] args) {
		BinaryTree<Integer> bt = new BinaryTree<Integer>(1);
		bt.appendLeft(8);
		bt.appendRight(2);
		bt.left().appendLeft(4);
		bt.left().appendRight(9);
		bt.right().appendRight(6);
		
		bt.inOrder(); 
		bt.preOrder(); 
		bt.postOrder();
		


		
	}

}
