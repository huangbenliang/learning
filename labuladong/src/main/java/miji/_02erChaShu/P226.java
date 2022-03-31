package miji._02erChaShu;

import miji._00commonUtils.TreeEntity;
import miji._00commonUtils.TreeNode;

public class P226 {
	public static void main(String[] args) {
		System.out.println(new TreeEntity().get226());
		System.out.println(new P226().invertTree(new TreeEntity().get226()));

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
	//test1
	//test2
	//test3

	//1
	//2
	//3

	//1
}
