package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class DFSDemo {
	LinkedList<Integer> queue; //存放刚被访问过的邻接结点
	/**
	 * 1. 存储顶点的集合arrayList
	 * 2. 存储顶点之间的边信息的数组int[indexOfV1][indexOfV2] edges;
	 * 3. 记录边的实际数量 numOfEdges
	 */
	ArrayList<String> vertexs;
	//材料
	int[][] edges;
	int numOfEdges;
	boolean[] isVisited;

	//构造器, 初始化
	public DFSDemo(int n) {
		vertexs = new ArrayList<String>(n);
		edges = new int[n][n];
		numOfEdges = 0;
		isVisited = new boolean[n];
		queue = new LinkedList<>();
	}

	//测试方法
	public static void main(String[] args) {
		String[] str = {"A", "B", "C", "D", "E", "F", "G", "H"};
		DFSDemo bg = new DFSDemo(str.length);
		for (String v : str) {
			bg.addVertex(v);
		}
		bg.addEdges(0, 2, 1);
		bg.addEdges(0, 3, 1);
		bg.addEdges(2, 3, 1);
		bg.addEdges(2, 1, 1);
		bg.addEdges(5, 6, 1);
		bg.addEdges(5, 0, 1);
		bg.addEdges(6, 4, 1);

		System.out.println(" " + Arrays.toString(str));
		bg.showGraph();
		bg.dfsTraverse();
		System.out.println("广度优先");
		bg.bfsTraverse();
	}

	//1. 添加顶点
	public void addVertex(String vertex) {
		vertexs.add(vertex);
	}
	//2.添加顶点之间的边信息

	/**
	 * @param v1     顶点A的索引
	 * @param v2     顶点B的索引
	 * @param weight 反映两个 顶点之间是否存在边
	 *               weight=1, 存在; weight=0, 不存在;
	 */
	public void addEdges(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges += 1;
	}

	public void showGraph() {

//        for (int[] v : edges) {
//            System.out.println(Arrays.toString(v));
//        }
		for (int i = 0; i < edges[0].length; i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < edges.length; j++) {
				System.out.print(edges[i][j] + ", ");
			}
			System.out.println();
		}
	}

	//dfs

	/**
	 * 从起始节点开始进行深度优先遍历
	 * 不断往下查找(isVisited==false && edges[index][0->length]==1)
	 * isVisited[index]=true, 已经访问过, =false未访问过;
	 *
	 * @param index 起始节点的索引
	 */
	public void dfs(int index) {
		if (isVisited[index]) return;

		System.out.print(vertexs.get(index) + "->");
		isVisited[index] = true;
		for (int j = 0; j < vertexs.size(); j++) {
			if (edges[index][j] == 1) {
				dfs(j);
			}
		}
	}

	public void dfsTraverse() {
		for (int i = 0; i < vertexs.size(); i++) {
			dfs(i);
		}
		System.out.println();
	}

	public void bfsTraverse() {
		isVisited = new boolean[vertexs.size()];
		for (int i = 0; i < vertexs.size(); i++) {
			if (!isVisited[i]) {
				bfs(i);
			}
		}
	}

	//广度优先遍历BFS
	public void bfs(int vIndex) {
		//设置起始顶点为访问过, 并把它输出
		//这两条语句也是下面递归的出口哦
		isVisited[vIndex] = true;
		System.out.print(vertexs.get(vIndex) + "->");

		//输出起始顶点的所有的邻接结点, 并把这些节点的索引存放到队列中
		for (int i = 0; i < vertexs.size(); i++) {
			if (edges[vIndex][i] == 1 && !isVisited[i]) {
				String targetVertex = vertexs.get(i);
				isVisited[i] = true;
				queue.addLast(i);
			}
		}
		//上面的工作(起始顶点的邻接顶点)完成后, 从队首中取出这些邻接顶点,挨个进行递归的BFS
		while (queue.size() > 0) {
			bfs(queue.remove());

		}
	}    //广度优先遍历BFS
}


