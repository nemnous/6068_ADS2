import java.util.Scanner;

/**
 * Class for graph class.
 */

class GraphClass {
    /**
     * number of vertices.
     */
    private int vertex;
    /**
     * number of edges.
     */
    private int edge;
    /**
     * adj array of bag class type.
     */
    Bag<Integer>[] adj;

    /**
     * Gets the e.
     * The time complexity is O(1).
     *
     * @return     The e of int type.
     */

    public int getedge() {
        return edge;
    }
    /**
     * Constructs the object.
     * The time complexity is O(N).
     *
     *
     * @param      vertex1     { number of vertices }
     */

    GraphClass(final int vertex1) {
        this.vertex = vertex1;
        adj = (Bag<Integer>[]) new Bag[vertex1];
        for (int v = 0; v < vertex1; v++) {
            adj[v] = new Bag<Integer>();
        }
    }
    /**
     * number of integers.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */

    public int vertex() {
        return vertex;
    }

    /**
     * number of vertices.
     * The time complexity is O(1).
     *
     *
     * @return     { int }
     */

    public int edge() {
        return edge;
    }
    /**
     * Adds an edge.
     * The time complexity is O(N).
     *
     *
     * @param      v     { vertex }
     * @param      w     { edge }
     */

    public void addEdge(final int v, final int w) {
        if (v == w) {
            return;
        }
        if (!hasedgedge(v, w)) {
            edge++;
        }

        adj[v].add(w);
        adj[w].add(v);
    }
    /**
     * determines if vertices are connected or not.
     * The time complexity is O(N).
     *
     *
     * @param      v     { vertex. }
     * @param      w     { edge }
     *
     * @return     True if has edge, False otherwise.
     */

    public boolean hasedgedge(final int v, final int w) {
        if (adj[v].contains(w)) {
            return true;
        }
        return false;

    }
    /**
     * prints the list of cities connected to other cities.
     * The time complexity is O(N^2).
     *
     *
     * @param      cities  The cities
     *
     * @return     { description_of_the_return_value }
     */

    public String printList(final String[] cities) {
        StringBuilder s = new StringBuilder();
            for (int v = 0; v < vertex; v++) {
            s.append(cities[v] + ": ");
            for (int w : adj[v]) {
                s.append(cities[w] + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
/**
 * Class for solution.
 * reads input.
 */

final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { creates object for graphclass }.
     *
     * @param      args  The arguments.
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        String api = input.nextLine();
        int vertex = Integer.parseInt(input.nextLine());
        // System.out.println(vertex);
        int edge = Integer.parseInt(input.nextLine());
        // System.out.println();
        String[] cities = input.nextLine().split(",");
        GraphClass gc = new GraphClass(vertex);
        // System.out.println(gc);
        for (int i = 0; i < edge; i++) {
            String[] tokens = input.nextLine().split(" ");
            gc.addEdge(Integer.parseInt(tokens[0]),
                Integer.parseInt(tokens[1]));
        }
        System.out.println(vertex + " vertices, " + gc.getedge()
            + " edges");

        if (edge == 0 || edge == 1 || vertex == 1) {
            System.out.println("No edges");
            return;
        }
        switch (api) {
            case "Matrix":
            for (int i = 0; i < vertex; i++) {
                for (int j = 0; j < vertex; j++) {
                    if (gc.hasedgedge(i, j)) {
                        System.out.print("1 ");
                    } else {
                        System.out.print("0 ");
                    }
                }
                if (i != vertex - 1) {
                    System.out.println();
                }
            }
            break;
            case "List":
            System.out.println(gc.printList(cities));
            break;
            default:
            break;
        }
    }
}