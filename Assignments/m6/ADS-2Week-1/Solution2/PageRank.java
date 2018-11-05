/**
 * Class for page rank.
 * this class calculates the page rank of all the
 * websites and stores the values of Double in array.
 */
class PageRank {
	int[][] path;
	Digraph graph;
	int vertices;
	public Double pagerank[] = new Double[10];
	/**
	 * Constructs the object.
	 */
	PageRank() {
		/**
		 * do nothing.
		 */
	}
	/**
	 * Constructs the object.
	 *
	 * @param      path  The path
	 * which is the adjacency matrix given.
	 *
	 */
	public PageRank(int[][] path) {
		this.path = path;
		int vertices = path[0].length;

		graph = new Digraph(vertices);
		matrixToGraph(path);
		calc(Double.valueOf(vertices));
	}
	/**
	 * this converts the matrix to graph.
	 *
	 * @param      path  The path
	 * complexity is N*N
	 */
	void matrixToGraph(int[][] path) {
		for (int i = 0; i < vertices; i++) {
			for (int j = 0; j < vertices; j++) {
				if (path[i][j] == 1) {
					graph.addEdge(i, j);
				}
			}
		}
	}
	// /**
	//  * gives Out Degree of the function.
	//  *
	//  *
	//  * @param      ExNodeNum  The external node number
	//  *
	//  * @return     { description_of_the_return_value }
	//  */
	// Double outDegree(int ExNodeNum) {
	// 	Double OutgoingLinks = 0.0; // Count the Number of Outgoing Links for each ExNodeNum
	// 	int k = 1;
	// 	while (k <= vertices) {
	// 		if (this.path[ExNodeNum][k] == 1 ) {
	// 			OutgoingLinks = OutgoingLinks + 1; // Counter for Outgoing Links

	// 		}
	// 		k = k + 1;
	// 	}
	// 	return OutgoingLinks;
	// }

	// int inDegree(int InNodeNum) {
	// 	Double inLinks = 0.0; // Count the Number of Outgoing Links for each ExNodeNum
	// 	int k = 1;
	// 	while (k <= totalNodes) {
	// 		if (this.path[k][InNodeNum] == 1 ) {
	// 			inLinks = inLinks + 1; // Counter for Outgoing Links
	// 		}
	// 		k = k + 1;
	// 	}
	// 	return inLinks;
	// }


	/**
	 * this function calculates the pagerank of the sites.
	 * this function takes 1000 iterations to complete the
	 * calculation.
	 *
	 * @param      totalNodes  The total nodes
	 * 
	 * complexity is N^3.
	 */
	public void calc(Double totalNodes) {

		Double InitialPageRank;
		Double OutgoingLinks = 0.0;
		Double TempPageRank[] = new Double[10];

		int ExNodeNum;
		int InNodeNum;
		int k = 1; // For Traversing
		int ITERATION_STEP = 1;

		InitialPageRank = 1 / totalNodes;
		//inititates the page rank.
		for (k = 1; k <= totalNodes; k++) {
			this.pagerank[k] = InitialPageRank;
		}

		while (ITERATION_STEP <= 1000) {
			// Store the PageRank for All Nodes in Temporary Array
			for (k = 1; k <= totalNodes; k++) {
				TempPageRank[k] = this.pagerank[k];
				this.pagerank[k] = 0.0;
			}

for (InNodeNum = 1; InNodeNum <= totalNodes; InNodeNum++) {
	for (ExNodeNum = 1; ExNodeNum <= totalNodes; ExNodeNum++) {
		if (this.path[ExNodeNum][InNodeNum] == 1) {
			k = 1;
			// Count the Number of Outgoing Links for each ExNodeNum
			OutgoingLinks = 0.0; 
			while (k <= totalNodes) {
				if (this.path[ExNodeNum][k] == 1 ) {
					OutgoingLinks = OutgoingLinks + 1; // Counter for Outgoing Links
				}
				k = k + 1;
			}
			// Calculate PageRank
		this.pagerank[InNodeNum] += TempPageRank[ExNodeNum] * (1 / OutgoingLinks);
		}
	}
}

	ITERATION_STEP = ITERATION_STEP + 1;
}

	}

/**
 * prints the graph and the page ranks.
 * 
 * COmplexity is N.
 */
	public void print() {
		System.out.println(graph);
		for (int i = 0; i < vertices; i++) {
			System.out.println(i + " - " + pagerank[i]);
		}
	}

}