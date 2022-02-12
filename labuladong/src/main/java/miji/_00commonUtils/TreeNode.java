package miji._00commonUtils;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}

	@Override
	public String toString() {
		if (this == null) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder("[");
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(this);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				sb.append("#,");
				continue;
			} else {
				sb.append(node.val + ",");
			}
			if (node.left == null && node.right == null) {
				continue;
			}
			queue.offer(node.left);
			queue.offer(node.right);
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
	}
}
