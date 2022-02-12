package miji._02erChaShu;

import miji._00commonUtils.TreeNode;

public class P654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		//找到数组最大值
		int maxValue=6;
		TreeNode root = new TreeNode(maxValue);

		//递归调用构造左右子树
		root.left=constructMaximumBinaryTree(new int[]{3,2,1});
		root.right=constructMaximumBinaryTree({0,5});
		return root;
	}
}
