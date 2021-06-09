package Exerise28_03;

import Exerise28_03.UnweightedGraph;

public interface Graph<V> {
	/** Return the number of vertices in the graph */
	int getSize();

	/** Return the vertices in the graph */
	java.util.List<V> getVertices();

	/** Return the object for the specified vertex index */
	V getVertex(int index);

	/** Return the index for the specified vertex object */
	int getIndex(V v);

	/** Return the neighbors of vertex with the specified index */
	java.util.List<Integer> getNeighbors(int index);

	/** Return the degree for a specified vertex */
	int getDegree(int v);

	/** Print the edges */
	void printEdges();

	/** Clear the graph */
	void clear();

	/** Add a vertex to the graph */
	boolean addVertex(V vertex);

	/** Add an edge (u, v) to the graph */
	boolean addEdge(int u, int v);

	/** Add an edge to the graph */
	boolean addEdge(Edge e);

	/** Remove a vertex v from the graph */  
	default boolean remove(V v) {
		return true; // Implementation left as an exercise
	}

	/** Remove an edge (u, v) from the graph */  
	default boolean remove(int u, int v) {
		return true; // Implementation left as an exercise
	}
	
	/** Obtain a depth-first search tree */
	UnweightedGraph<V>.SearchTree dfs(int v);

	/** Obtain a breadth-first search tree */
	UnweightedGraph<V>.SearchTree bfs(int v);
}