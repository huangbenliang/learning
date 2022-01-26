package com.hbl._01graph;

public class GraphTest {

	public static void main(String[] args){
//	public static void main(String[] args) {

//		String[] vertexs = {"A", "B", "C", "D", "E"};

		String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
		Graph graph = new Graph(vertexs.length);
		graph.insertVertex(vertexs);

//		graph.insertEdge(0, 1);
//		graph.insertEdge(0, 2);
//		graph.insertEdge(1, 2);
//		graph.insertEdge(1, 3);
//		graph.insertEdge(1, 4);

		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(1, 4);
		graph.insertEdge(3, 7);
		graph.insertEdge(4, 7);
		graph.insertEdge(2, 5);
		graph.insertEdge(2, 6);
		graph.insertEdge(5, 6);

		graph.showGraph();

		System.out.println("dfs");
		graph.dfs();
		System.out.println("\n"+"bfs");
		graph.bfs();

	}
}
