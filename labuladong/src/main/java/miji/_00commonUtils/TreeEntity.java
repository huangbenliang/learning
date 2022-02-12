package miji._00commonUtils;

public class TreeEntity {
	TreeNode root;

	public TreeNode getRoot() {
		return root;
	}

	/**
	 * [4,2,7,1,3,6,9]
	 *
	 * @return
	 */
	public TreeNode get226() {
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


}
