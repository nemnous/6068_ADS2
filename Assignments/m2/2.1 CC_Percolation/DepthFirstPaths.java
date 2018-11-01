/**
 * Class for depth first paths.
 */
public class DepthFirstPaths {
    /**
     * marked[v] - is there an s-v path.
     */
    private boolean[] marked;
    /**
     * edegeTo[v] - last edge on s-v path.
     */
    private int[] edgeTo;
    /**
     * source vertex.
     */
    private final int s;
    /**
     * Computes a path between {@code s}.
     * and every other vertex in graph {@code graph}.
     * @param graph the graph
     * @param src the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DepthFirstPaths(final GraphClass graph, final int src) {
        this.s = src;
        edgeTo = new int[graph.vertex()];
        marked = new boolean[graph.vertex()];
        dfs(graph, s);
    }

    /**
     * depth from search from v.
     * The time complexity is O(N).
     *
     * @param      graph     { parameter_description }
     * @param      v     { parameter_description }
     */
    private void dfs(final GraphClass graph, final int v) {
        marked[v] = true;
        for (int w : graph.adj[v]) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            }
        }
    }

    /**
     * Is there a path between the source vertex {@code s} and vertex {@code v}?
     * The time complexity is O(1).
     * @param v the vertex
     * @return {@code true} if there is a path, {@code false} otherwise
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public boolean hasPathTo(final int v) {
        return marked[v];
    }



}

