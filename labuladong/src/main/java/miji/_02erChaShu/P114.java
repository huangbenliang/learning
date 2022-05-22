package miji._02erChaShu;

import miji._00commonUtils.TreeUtils;
import miji._00commonUtils.TreeNode;

public class P114 {
	public static void main(String[] args) {
		TreeNode root = new TreeUtils().get226();
		System.out.println(root);
		new P114().flatten(root);
		System.out.println(root);
	}
	// 定义：将以 root 为根的树拉平为链表
	void flatten(TreeNode root) {
		// base case
		if (root == null) return;

		flatten(root.left);
		flatten(root.right);

		/**** 后序遍历位置 ****/
		// 1、左右子树已经被拉平成一条链表
		TreeNode left = root.left;
		TreeNode right = root.right;

		// 2、将左子树作为右子树
		root.left = null;
		root.right = left;

		// 3、将原先的右子树接到当前右子树的末端
		TreeNode p = root;
		while (p.right != null) {
			p = p.right;
		}
		p.right = right;
	}

}
