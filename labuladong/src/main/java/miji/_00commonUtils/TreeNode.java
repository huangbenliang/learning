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

	public String toString1() {
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
				sb.append(node.val);
			}
			if (node.left == null && node.right == null) {
				sb.append("*,");
				continue;
			} else {
				sb.append(",");
			}
			queue.offer(node.left);
			queue.offer(node.right);
		}
		sb.setCharAt(sb.length() - 1, ']');
		return sb.toString();
		//5
	}

	@Override
	public String toString() {
		if (this == null) {
			return "[]";
		}
		StringBuffer sb = new StringBuffer();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(this);

		while (!q.isEmpty()) {
			for (int i = 0; i < q.size(); i++) {
				TreeNode cur = q.poll();
				if (cur == null) {
					sb.append("* ");
					continue;
				} else {
					sb.append(cur.val + " ");
				}

				if (cur.left != null) {
					q.offer(cur.left);
				} else {
					q.offer(null);
				}
				if (cur.right != null) {
					q.offer(cur.right);
				} else {
					q.offer(null);
				}
			}
		}
		int k = sb.length();
		while (k > 0) {
			if (sb.charAt(k - 2) == '*') {
				k -= 2;
			} else {
				break;
			}
		}
		return sb.substring(0, k);
	}
}
