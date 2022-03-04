package miji._02erChaShu;

import miji._00commonUtils.TreeNode;

public class P889 {
	public static void main(String[] args) {
		TreeNode root = new P889().constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
		System.out.println(root);
	}
	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		return build(preorder, 0, preorder.length - 1,
				postorder, 0, postorder.length - 1);
	}

	private TreeNode build(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
		if (preStart > preEnd) {
			return null;
		}
		if (preStart == preEnd) {
			return new TreeNode(preorder[preStart]);
		}
		//root节点
		int rootVal=preorder[preStart];
		//在后续遍历中查找左子树根节点的位置
		int leftRootVal=preorder[preStart+1];
		int index=postStart;
		while (index <= postEnd) {
			if (postorder[index] == leftRootVal) {
				break;
			}
			index++;
		}
		//计算左子树的总节点数
		int count=index-postStart;
		TreeNode root = new TreeNode(rootVal);
		root.left=build(preorder, preStart+1, preStart+count+1, postorder, postStart, index-1);
		root.right=build(preorder,preStart+count+2 ,preEnd , postorder,index+1 ,postEnd );
		return root;

	}

	// 定义：根据 preorder[preStart..preEnd] 和 postorder[postStart..postEnd]
	// 构建二叉树，并返回根节点。
	TreeNode build1(int[] preorder, int preStart, int preEnd,
				   int[] postorder, int postStart, int postEnd) {
		if (preStart > preEnd) {
			return null;
		}
		if (preStart == preEnd) {
			return new TreeNode(preorder[preStart]);
		}

		// root 节点对应的值就是前序遍历数组的第一个元素
		int rootVal = preorder[preStart];
		// root.left 的值是前序遍历第二个元素
		// 通过前序和后序遍历构造二叉树的关键在于通过左子树的根节点
		// 确定 preorder 和 postorder 中左右子树的元素区间
		int leftRootVal = preorder[preStart + 1];
		// leftRootVal 在后序遍历数组中的索引
		int index = 0;
		for (int i = postStart; i < postEnd; i++) {
			if (postorder[i] == leftRootVal) {
				index = i;
				break;
			}
		}
		// 左子树的元素个数
		int leftSize = index - postStart + 1;

		// 先构造出当前根节点
		TreeNode root = new TreeNode(rootVal);
		// 递归构造左右子树
		// 根据左子树的根节点索引和元素个数推导左右子树的索引边界
		root.left = build(preorder, preStart + 1, preStart + leftSize,
				postorder, postStart, index);
		root.right = build(preorder, preStart + leftSize + 1, preEnd,
				postorder, index + 1, postEnd - 1);

		return root;
	}


}
