package miji._02erChaShu;

import miji._00commonUtils.TreeUtils;
import miji._00commonUtils.TreeNode;

public class P226 {
	public static void main(String[] args) {
		System.out.println(new TreeUtils().get226());
		System.out.println(new P226().invertTree(new TreeUtils().get226()));

	}
	public TreeNode invertTree(TreeNode root) {
		if (root==null){ return null;}
		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		return root;
	}

}
