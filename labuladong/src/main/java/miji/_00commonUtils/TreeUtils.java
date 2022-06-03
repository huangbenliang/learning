package miji._00commonUtils;

public class TreeUtils {
	static TreeNode root;

	public static TreeNode getSimpleTree() {
		root = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		root.left = n2;
		root.right = n3;
		n2.left = n4;
		n2.right = n5;
//		n3.left = n6;
		n3.right = n7;
		return root;
	}

	/**
	 * [4,2,7,1,3,6,9]
	 *
	 * @return
	 */
	public static TreeNode get226() {
		root = new TreeNode(4);
		TreeNode r11 = new TreeNode(2);
		TreeNode r12 = new TreeNode(7);
		TreeNode r21 = new TreeNode(1);
		TreeNode r22 = new TreeNode(3);
		TreeNode r23 = new TreeNode(6);
		TreeNode r24 = new TreeNode(9);
		root.left = r11;
		root.right = r12;
		r11.left = r21;
		r11.right = r22;
		r12.left = r23;
		r12.right = r24;
		return root;
	}

	public TreeNode getRoot() {
		return root;
	}


}
