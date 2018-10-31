import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * size of row and column.
     */
    private int size;
    /**
     * twoD array.
     */
    private int[][] a;
    /**
     * Constructs the object.
     *
     * @param      lines  The lines
     */

    Percolation(final int lines) {
        this.size = lines;
        a = new int[lines][lines];
    }
    /**
     * { if there is a connection, 1 is kept }.
     * The time complexity is O(1).
     *
     * @param      x     { integer - row }
     * @param      y     { column }
     */

    public void add(final int x, final int y) {
        a[x - 1][y - 1] = 1;
    }
    /**
     * prints.
     * The time complexity is O(N).
     *
     */

    public void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * calculates the index of element in matrix.
     * The time complexity is O(1).
     *
     *
     * @param      row   The row
     * @param      col   The col
     *
     * @return     { index - int }
     */

    public int  trans(final int row, final int col) {
        return ((row * size) + col);
    }
    /**
     * if there is connection, we add an edge.
     * The time complexity is O(N^2).
     *
     *
     * @return     { if there is path, true, else false }
     */

    public boolean percolation() {
        GraphClass graph = new GraphClass(size * size + 2);
        for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            if (a[i][j] == 1) {
                int tmp = trans(i, j);
                if (i == 0) {
                    graph.addEdge(tmp,
                        size * size);
                }
                if (i == size - 1) {
                    graph.addEdge(tmp,
                        size * size + 1);
                }
                if (i - 1 >= 0 && a[i - 1][j] == 1) {
                    graph.addEdge(tmp,
                        trans(i - 1, j));
                }
                if (i + 1 < size  && a[i + 1][j] == 1) {
                    graph.addEdge(tmp,
                        trans(i + 1, j));
                }
                if (j - 1 >= 0 && a[i][j - 1] == 1) {
                    graph.addEdge(tmp, trans(i, j - 1));
                }
                if (j + 1 < size && a[i][j + 1] == 1) {
                    graph.addEdge(tmp, trans(i, j + 1));
                }
            }
        }
    }
    DepthFirstPaths object = new DepthFirstPaths(
        graph, size * size);
    return object.hasPathTo(size * size + 1);
    }
}
/**
 * Class for solution.
     * The time complexity is O(N^2).
 *
 */

final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * reads input.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner input = new Scanner(System.in);
        int lines = Integer.parseInt(input.nextLine());
        Percolation pc = new Percolation(lines);
        while (input.hasNext()) {
            String[] tokens = input.nextLine().split(" ");
            pc.add(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
        }
        System.out.println(pc.percolation());
    }
}
