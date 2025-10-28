package lab_8_bst_validity_checker;

import java.util.*;

public class BSTChecker {
	static HashSet<Node> visited = new HashSet<Node>();

	private static Node recurse(int min, int max, Node node) {
		if (node == null) {
			return null;
		}
		if (!((min <= node.key) && (node.key <= max))) {
			return node;
		}
		visited.add(node);

		if (visited.contains(node.left)) {
			return node;
		}
		Node leftInvalid = recurse(min, node.key, node.left);
		if (leftInvalid != null) {
			return leftInvalid;
		}

		if (visited.contains(node.right)) {
			return node;
		}
		Node rightInvalid = recurse(node.key, max, node.right);
		if (rightInvalid != null) {
			return rightInvalid;
		}
		return null;
	}

	public static Node checkBSTValidity(Node rootNode) {
		return recurse(Integer.MIN_VALUE, Integer.MAX_VALUE, rootNode);
	}
}
