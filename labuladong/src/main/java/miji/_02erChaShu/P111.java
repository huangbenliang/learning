package miji._02erChaShu;

import miji._00commonUtils.TreeNode;
import miji._00commonUtils.TreeUtils;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

class P111 {
	int depth;
	int minDepth;
	Queue<TreeNode> queue = new LinkedList<>();

	//采用前序遍历方式
	public int minDepth(TreeNode root) {
		depth = 0;
		minDepth = Integer.MAX_VALUE;
		traverse(root);
		return minDepth;
	}

	private void traverse(TreeNode root) {
		if (root == null) return;

		depth++;
		if (root.left == null && root.right == null) {
			minDepth = depth < minDepth ? depth : minDepth;
		}
		traverse(root.left);
		traverse(root.right);
		depth--;
	}

	//采用后续遍历方式
	public int minDepth1(TreeNode root) {
		if (root == null) return 0;
		int left = minDepth1(root.left);
		int right = minDepth1(root.right);
		if (left == 0) {
			return right + 1;
		}
		if (right == 0) {
			return left + 1;
		}
		return Math.min(left, right) + 1;
	}

	//采用层序遍历方式
	public int levelTraverse(TreeNode root) {
		if (root == null) return 0;
		queue.offer(root);
//		第一个while循环用于向下遍历
		while (!queue.isEmpty()) {
			depth++;
			//for循环用于从左向右遍历,注意这里的size必须单独些,因为在for中会改变queue的大小.
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				if (cur.left == null && cur.right == null) {
					return depth;
				}
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
		}
		return depth;
	}

	@Test
	public void test() {
		TreeNode root = TreeUtils.getSimpleTree();
		int min = minDepth(root);
		System.out.println("min = " + min);
		int houXu = minDepth1(root);
		System.out.println("houXu = " + houXu);
		depth = 0;
		int level = levelTraverse(root);
		System.out.println("level = " + level);

	}
}