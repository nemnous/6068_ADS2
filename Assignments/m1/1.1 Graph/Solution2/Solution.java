import java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;

interface Graph {
	public int V();
	public int E();
	public void addEdge(int v, int w);
	// public Iterable<Integer> adj(int v);
	public boolean hasEdge(int v, int w);
}


class GraphAPI implements Graph {
	int v;
	int e;
	HashMap hmap;
	boolean[][] array;

	GraphAPI(int v, HashMap hmap) {
		this.v = v;
		this.hmap = hmap;
		this.array = new boolean[v][v];
	}

	public int V() {
		return v;
	}

	public int E() {
		return e;
	}

	public void addEdge(int n1, int n2) {
		array[n1][n2] = true;
	}

	public boolean hasEdge(int v, int w) {
		return array[v][w];
	}

	public void print() {
		for(int i =0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				// if(array[i][j]) {
				// 	System.out.print("1");
				// } else {
				// 	System.out.print("0");
				// }
				System.out.println(array[i][j]);
			}
			System.out.println();
		}
	}

}


class Solution {
	public static void main(String[] args) {
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		Scanner scan = new Scanner(System.in);
		String impl = scan.nextLine();
		int vertices = scan.nextInt();
		int edges = scan.nextInt();

		scan.nextLine();
		switch(impl) {
			case "Matrix":
				String[] nodes = scan.nextLine().split(",");
				System.out.println(Arrays.toString(nodes));
				for(int i = 0; i < vertices; i++) {
					hmap.put(i, nodes[i]);
				}
				GraphAPI graph = new GraphAPI(vertices, hmap);
				String[] str = scan.nextLine().split(" ");
				System.out.println(str[0]+ " " + str[1]);
				for(int i = 0; i < edges; i++) {
					graph.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
				}

				graph.print();
		}
	}
}