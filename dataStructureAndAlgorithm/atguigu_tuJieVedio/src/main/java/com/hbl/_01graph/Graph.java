package com.hbl._01graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graph {
	private ArrayList<String> vertexList;  //存储顶点集合
	private int[][] edges;  //邻接矩阵
	private int numOfEdges;    //边的数量

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

	public int getNUmOfVertex() {
		return vertexList.size();
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	public String getVertexByIndex(int index) {
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

}
