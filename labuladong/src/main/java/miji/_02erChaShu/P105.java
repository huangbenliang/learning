package miji._02erChaShu;

import miji._00commonUtils.TreeNode;

public class P105 {
	public static void main(String[] args) {
		TreeNode root = new P105().buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
		System.out.println(root);
	}
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode build(int[] preorder, int preStart, int preEnd,
						   int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd) {
			return null;
		}
		int value=preorder[preStart];
		int index=inStart;
		while (index <= inEnd) {
			if (inorder[index] == value) {
				break;
			}
			index++;
		}
		TreeNode root = new TreeNode(value);
		int numbersCount=index-inStart;
		root.left=build(preorder, preStart+1,preStart+numbersCount , inorder, inStart, index-1);
		root.right=build(preorder,preStart+numbersCount+1,preEnd , inorder, index+1, inEnd);
		return root;
	}
}
