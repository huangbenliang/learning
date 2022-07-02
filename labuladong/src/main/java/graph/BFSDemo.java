package graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BFSDemo {
	/**
	 * 1. 存储顶点的vertexs 集合
	 * 2. 存储顶点之间边信息的 edges数组
	 * 3. 标记是否访问过顶点对应索引的boolean数组 isVisited
	 * 4. 顺序存储刚刚遍历过的顶点的索引的队列 queue(linkedlist集合实现)
	 */
	ArrayList<String> vertexs; //存储图中的顶点;
	int[][] edges; //存储顶点之间的边信息

	boolean[] isVisited; //标记对应顶点的索引是否被访问
	LinkedList<Integer> queue; //存放刚被访问过的邻接结点

	int numOfEdges;

	//构造器
	public BFSDemo(int n) {
		vertexs = new ArrayList<String>(n);
		edges = new int[n][n];
		isVisited = new boolean[n];
		queue = new LinkedList<Integer>();
	}

	//测试方法
	public static void main(String[] args) {
		String[] str = {"A", "B", "C", "D", "E", "F", "G", "H"};
		BFSDemo bfs = new BFSDemo(str.length);
		for (String x : str) {
			bfs.addVertex(x);
		}
		bfs.addEdges(0, 2, 1);
		bfs.addEdges(0, 3, 1);
		bfs.addEdges(2, 3, 1);
		bfs.addEdges(2, 1, 1);
		bfs.addEdges(5, 6, 1);
		bfs.addEdges(5, 0, 1);
		bfs.addEdges(6, 4, 1);

		bfs.showGraph();
		bfs.bfsTraverse();
	}

	//添加结点到集合中
	public void addVertex(String str) {
		vertexs.add(str);
	}
	//添加边

	/**
	 * @param v1Index 顶点1的索引
	 * @param v2Index 顶点2的索引
	 * @param weight  顶点1,2之间边的关系, =1有边相连接, =0 无边连接;
	 */
	public void addEdges(int v1Index, int v2Index, int weight) {
		edges[v1Index][v2Index] = weight;
		edges[v2Index][v1Index] = weight;
		numOfEdges += 1;
	}

	//以矩阵的形式反映出图
	public void showGraph() {
		System.out.println(" " + vertexs);

		for (int i = 0; i < edges[0].length; i++) {
			System.out.print((char) ('A' + i) + " ");
			for (int j = 0; j < edges.length; j++) {
				System.out.print(edges[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println();
	}


	public void bfs(int vIndex) {
		//设置起始顶点为访问过, 并把它输出
		queue.add(vIndex);
		isVisited[vIndex] = true;

		//上面的工作(起始顶点的邻接顶点)完成后, 从队首中取出这些邻接顶点,挨个进行递归的BFS
		while (queue.size() > 0) {
			Integer pop = queue.pop();
			System.out.print(vertexs.get(pop) + "->");
			//输出起始顶点的所有的邻接结点, 并把这些节点的索引存放到队列中
			for (int i = 0; i < vertexs.size(); i++) {
				if (edges[pop][i] == 1 && !isVisited[i]) {
					isVisited[i] = true;
					queue.addLast(i);
				}
			}
		}
	}

	public void bfsTraverse() {
		for (int i = 0; i < vertexs.size(); i++) {
			if (!isVisited[i]) {
				bfs(i);
			}
		}
	}
}

