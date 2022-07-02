package graph;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class P797 {
	List<List<Integer>> res;
	LinkedList<Integer> track;


	@Test
	public void test() {

		List<List<Integer>> lists = allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
		System.out.println("lists = " + lists);
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		res = new LinkedList<>();
		track = new LinkedList<>();
		traverse(graph, 0);
		return res;
	}

	private void traverse(int[][] graph, int start) {
		track.add(start);

		if (start == graph.length - 1) {
			res.add(new LinkedList<>(track));
			track.removeLast();
			return;
		}
		for (int v : graph[start]) {
			traverse(graph, v);
		}
		track.removeLast();
	}
}