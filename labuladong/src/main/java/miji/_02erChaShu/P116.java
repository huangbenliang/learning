package miji._02erChaShu;


import miji._00commonUtils.TreeUtils;
import miji._00commonUtils.TreeNode;


public class P116 {
	public static void main(String[] args) {
		TreeNode root = new TreeUtils().get226();
		System.out.println(new P116().connect(root));
		System.out.println();

	}
	// 主函数
	TreeNode connect(TreeNode root) {
		if (root == null) return null;
		connectTwoNode(root.left, root.right);
		return root;
	}

	// 辅助函数
	void connectTwoNode(TreeNode node1, TreeNode node2) {
		if (node1 == null || node2 == null) {
			return;
		}
		/**** 前序遍历位置 ****/
		// 将传入的两个节点连接
		node1.next = node2;
		// 连接跨越父节点的两个子节点
		connectTwoNode(node1.right, node2.left);

		// 连接相同父节点的两个子节点
		connectTwoNode(node1.left, node1.right);
		connectTwoNode(node2.left, node2.right);
	}
}
