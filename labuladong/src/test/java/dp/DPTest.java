package dp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Arrays;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class DPTest {
	@Test
	public void test0_1BeiBao(){
		int res = new Knapsack().knapsack(4, 3, new int[]{2, 1, 3}, new int[]{4, 2, 3});
		System.out.println("res = " + res);
	}
	@Test
	public void testTwoSum(){
		int[] res = new TwoSum().twoSum(new int[]{5, 3, 1, 6}, 9);
		System.out.println("res = " + Arrays.toString(res));
	}
	@Test
	public void test15(){
		List<List<Integer>> lists = new P15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
		System.out.println("lists = " + lists);
	}
}
