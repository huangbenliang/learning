package com.hbl._01graph;

import org.junit.jupiter.api.Test;

public class GraphTest {
	@Test
	public void test(){
//	public static void main(String[] args) {
		int n = 5;
		String[] vertexs = {"A", "B", "C", "D", "E"};
		Graph graph = new Graph(n);
		graph.insertVertex(vertexs);

		graph.insertEdge(0, 1);
		graph.insertEdge(0, 2);
		graph.insertEdge(1, 2);
		graph.insertEdge(1, 3);
		graph.insertEdge(1, 4);

		graph.showGraph();

	}
}
