package com.hbl._01graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private ArrayList<String> vertexList;  //存储顶点集合
	private int[][] edges;  //邻接矩阵
	private int numOfEdges;    //边的数量

	//定义给数组boolean[], 记录某个结点是否被访问
	private boolean[] isVisited;

	/**
	 * @param n 顶点个数
	 */
	public Graph(int n) {
		vertexList = new ArrayList<>(n);
		edges = new int[n][n];
	}

	public Graph() {
	}

	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}

	public void insertVertex(String[] vertexs) {
		insertVertex(Arrays.asList(vertexs));
	}

	public void insertVertex(List<String> vertexList) {
		this.vertexList.addAll(vertexList);
	}

	public int getNumOfVertex() {
		return vertexList.size();
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	public String getValueByIndex(int index) {
		return vertexList.get(index);
	}

	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	public void showGraph() {
		for (int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}

	public void insertEdge(int v1, int v2) {
		insertEdge(v1, v2, 1);
		insertEdge(v2, v1, 1);
		numOfEdges++;
	}

	private void insertEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
	}

	/**====================深度优先遍历==================*/
	//得到第一个邻接结点的下标 w

	/**
	 * @param index
	 * @return 如果存在就返回对应的下标，否则返回-1
	 */
	public int getFirstNeighbor(int index) {
		for (int j = 0; j < vertexList.size(); j++) {
			if (edges[index][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	//根据前一个邻接结点的下标来获取下一个邻接结点
	public int getNextNeighbor(int v1, int v2) {
		for (int j = v2 + 1; j < vertexList.size(); j++) {
			if (edges[v1][j] > 0) {
				return j;
			}
		}
		return -1;
	}

	//深度优先遍历算法
	//i 第一次就是 0
	private void dfs(boolean[] isVisited, int i) {
		//首先我们访问该结点,输出
		System.out.print(getValueByIndex(i) + "->");
		//将结点设置为已经访问
		isVisited[i] = true;
		//查找结点i的第一个邻接结点w
		int w = getFirstNeighbor(i);
		while (w != -1) {//说明有
			if (!isVisited[w]) {
				dfs(isVisited, w);
			}
			//如果w结点已经被访问过
			w = getNextNeighbor(i, w);
		}

	}

	//对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
	public void dfs() {
		isVisited = new boolean[vertexList.size()];
		//遍历所有的结点，进行dfs[回溯]
		for (int i = 0; i < getNumOfVertex(); i++) {
			if (!isVisited[i]) {
				dfs(isVisited, i);
			}
		}
	}


	/**===============广度优先==============*/
	//对一个结点进行广度优先遍历的方法
	private void bfs(boolean[] isVisited, int i) {
		int u ; // 表示队列的头结点对应下标
		int w ; // 邻接结点w
		//队列，记录结点访问的顺序
		LinkedList queue = new LinkedList();
		//访问结点，输出结点信息
//		System.out.print(getValueByIndex(i) + "=>");
		//标记为已访问
		isVisited[i] = true;
		//将结点加入队列
		queue.addLast(i);

		while( !queue.isEmpty()) {
			//取出队列的头结点下标
			u = (Integer)queue.removeFirst();
			System.out.print(getValueByIndex(u) + "=>");
			//得到第一个邻接结点的下标 w
			w = getFirstNeighbor(u);
			while(w != -1) {//找到
				//是否访问过
				if(!isVisited[w]) {
					//System.out.print(getValueByIndex(w) + "=>");
					//标记已经访问
					isVisited[w] = true;
					//入队
					queue.addLast(w);
				}
				//以u为前驱点，找w后面的下一个邻结点
				w = getNextNeighbor(u, w); //体现出我们的广度优先
			}
		}

	}

	//遍历所有的结点，都进行广度优先搜索
	public void bfs() {
		isVisited = new boolean[vertexList.size()];
		for(int i = 0; i < getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				bfs(isVisited, i);
			}
		}
	}

}
