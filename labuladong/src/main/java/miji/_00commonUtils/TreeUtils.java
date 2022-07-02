package miji._00commonUtils;

public class TreeUtils {
	static TreeNode n1 = new TreeNode(1);
	static TreeNode n2 = new TreeNode(2);
	static TreeNode n3 = new TreeNode(3);
	static TreeNode n4 = new TreeNode(4);
	static TreeNode n5 = new TreeNode(5);
	static TreeNode n6 = new TreeNode(6);
	static TreeNode n7 = new TreeNode(7);

	public static TreeNode getSimpleTree() {

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
//		n3.left = n6;
//		n3.right = n7;
		return n1;
	}

	/**
	 * [4,2,7,1,3,6,9]
	 *
	 * @return
	 */
	public static TreeNode get226() {
		n1 = new TreeNode(4);
		TreeNode r11 = new TreeNode(2);
		TreeNode r12 = new TreeNode(7);
		TreeNode r21 = new TreeNode(1);
		TreeNode r22 = new TreeNode(3);
		TreeNode r23 = new TreeNode(6);
		TreeNode r24 = new TreeNode(9);
		n1.left = r11;
		n1.right = r12;
		r11.left = r21;
		r11.right = r22;
		r12.left = r23;
		r12.right = r24;
		return n1;
	}

	public TreeNode getRoot() {
		return n1;
	}

	public static TreeNode get111() {
		n1.right = n2;
		n2.right = n3;
		n3.right = n4;
		n4.right = n5;
		return n1;
	}
}
