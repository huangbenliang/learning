package miji._02erChaShu;

import miji._00commonUtils.TreeNode;
import miji._00commonUtils.TreeUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BinaryTreeTest {
	TreeNode root;

	@BeforeAll
	public void prepare() {
		root = TreeUtils.getSimpleTree();
	}

	@Test
	public void test114() {
		new P114().flatten1(root);
		System.out.println("root = " + root);
	}

	@Test
	public void test654() {
		TreeNode treeNode = new P654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
		System.out.println("treeNode = " + treeNode);
	}
}
