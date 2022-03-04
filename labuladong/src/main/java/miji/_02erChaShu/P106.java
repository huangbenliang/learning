package miji._02erChaShu;

import miji._00commonUtils.TreeNode;

public class P106 {
	public static void main(String[] args) {
		TreeNode root = new P106().buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
		System.out.println(root);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return bulid(inorder, 0, inorder.length - 1,
				postorder, 0, postorder.length - 1);
	}

	private TreeNode bulid(int[] inorder, int inStart, int inEnd,
						   int[] postorder, int postStart, int postEnd) {
		if (postStart > postEnd) {
			return null;
		}
		//中序遍历中查找root节点及其下标
		int value = postorder[postEnd];
		int index = inStart;
		while (index <= inEnd) {
			if (inorder[index] == value) {
				break;
			}
			index++;
		}
		int count = index - inStart;
		TreeNode root = new TreeNode(value);
		root.left = bulid(inorder, inStart, index - 1,
				postorder, postStart, postStart + count - 1);
		root.right = bulid(inorder, index + 1, inEnd,
				postorder, postStart + count, postEnd - 1);
		return root;
	}
}
