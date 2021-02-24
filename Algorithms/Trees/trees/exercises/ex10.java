package trees.exercises;

/**
 * T1 and T2 are two very large binary trees, with T1 much bigger than T2. 
 * Create an algorithm to determine if T2 is a subtree of T1.
 * 
 * A tree is a subtree of another one if there exists a node n in T1 such 
 * that the subtree of n is identical to T2. That is, if you cut off the 
 * tree at node n, the two trees would be identical
 * 
 * DISCALIMER: this code has not been properly tested and it has some errors 
 * that should be fixed
 * 
 * @author luisa
 * */

public class ex10 {
	
	public static class BinaryTree<Integer>{
		Node root;
		public class Node{
			Integer value;
			Node left, right = null;
			
			public Node(Integer element) {
				this.value = element;
			}
			
		}
		
		/**
		 * Compare the tree with another binary tree and returns 
		 * true if so. False otherwise
		 * 
		 * @param BinaryTree
		 * @return boolean
		 * */
		public boolean isEqual(BinaryTree tree) {
			return this.isEqual(this.root, tree.root);
		}
		
		/**
		 * Returns true if two nodes are equal. False otherwise
		 * 
		 * @param Node
		 * @param Node
		 * @return boolean
		 * */
		private boolean isEqual(Node node1, Node node2) {
			if(node1 == null || node2 == null)
				return true;
			
			return (node1 == node2 &&
					isEqual(node1.left, node2.left) &&
					isEqual(node1.right, node2.right));
		}
		
		/**
		 * Returns the maximu depth of the tree 
		 * 
		 * @return int
		 * */
		public int getHeigh() {
			return getHeigh(this.root, 0);
		}
		
		private int getHeigh(Node node, int count) {
			if(node == null)
				return count;
			
			return Math.max(getHeigh(node.left, count+1),
					getHeigh(node.right, count+1));
		}
		
		/**
		 * Returns tree if a given binary tree is subtree.
		 * 
		 * @param BinaryTree
		 * @return boolean
		 * */
		public boolean isSubtree(BinaryTree tree) {
			if(tree.getHeigh() < this.getHeigh())
				return false;
			
			return isSubtree(tree.root);
		}
		
		public boolean isSubtree(Node node) {
			if(node == null)
				return false;
			
			if(isEqual(node, this.root))
				return true;
			else {
				 isSubtree(node.left);
				 isSubtree(node.right);
			}
			return true;
		}
		
	}
	
}
