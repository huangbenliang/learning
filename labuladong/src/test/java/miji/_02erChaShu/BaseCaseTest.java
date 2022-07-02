package miji._02erChaShu;

import miji._00commonUtils.TreeNode;
import miji._00commonUtils.TreeUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseCaseTest {
	TreeNode root;
	@BeforeAll
	public void prepare(){
		root= TreeUtils.get226();
	}
	@Test
	public void printTest(){
		System.out.println("root = " + root);
	}


}
