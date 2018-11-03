import java.util.Scanner;
/**
 * Class for page rank.
 */
class PageRank {

}
/**
 * Class for web search.
 */
class WebSearch {

}

/**
 * Class for solution.
 */
final public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * does nothing.
         */
    }
    /**
     * main funciton.
     * Complexity is N^2.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int vertices = scan.nextInt();
        int[][] matrix = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            String[] tokens = scan.nextLine().split(" ");
            for (int j = 0; j < tokens.length; j++) {
matrix[Integer.parseInt(tokens[0])][Integer.parseInt(tokens[i])] = 1;
        }
    }
        PageRank pRank = new PageRank(matrix);
        pRank.print();

        String file = "WebContent.txt";
    }
}
