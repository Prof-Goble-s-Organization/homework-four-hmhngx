package hw04;

import java.util.ArrayList;

/**
 * Find the key associated with the minimum value in a tree.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {

	private String minKey;
	private Integer minValue;

	public MinKeyFinder() {
		this.minKey = null;
		this.minValue = null;
	}

	/**
	 * {@inheritDoc}
	 */
	public void visit(String key, Integer value) {
		if(minValue == null || value < minValue) {
			minKey = key;
			minValue = value;
		}
	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {		
		return minKey;
	}

	public static void main(String[] args) {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",};
		Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		CS232LinkedBinaryTree<String, Integer> tree = new CS232LinkedBinaryTree<>(keys, values);
		MinKeyFinder mkf = new MinKeyFinder();
		tree.visitPreOrder(mkf);
		System.out.println("The key of the minimum value in the tree is: " + mkf.getMinKey());

	}
}
