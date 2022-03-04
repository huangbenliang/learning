package miji._02erChaShu;

import miji._00commonUtils.TreeNode;

public class P654 {
	public static void main(String[] args) {
		TreeNode treeNode = new P654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
		System.out.println(treeNode);
	}
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return construct(nums, 0, nums.length - 1);
	}

	public TreeNode construct(int[] nums, int left, int right) {
		if (left > right) {
			return null;
		}
		//找到数组最大值
		int maxValue = nums[left];
		int index = left;
		for (int i = left + 1; i <= right; i++) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				index = i;
			}
		}
		TreeNode root = new TreeNode(maxValue);

		//递归调用构造左右子树
		root.left = construct(nums, left, index - 1);
		root.right = construct(nums, index + 1, right);
		return root;
	}
}
