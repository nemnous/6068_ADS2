import java.util.HashSet;
/**
 * Class for boggle solver.
 */
public class BoggleSolver {
    /**
     * // Initializes the data structure using.
    // the given array of strings as the dictionary.
    // (You can assume each word in the dictionary.
    //  contains only the uppercase letters A through Z.)
    // Bag<String> bag =  new Bag<String>();
     */
    /**
     * bag - hashset.
     */

    private final  HashSet<String> bag;
    /**
     * tries ST.
     */
    private final TriesST<Integer> triesST;
    /**
     * Constructs the object.
     * The time complexity is O(N).
     * N - length of dictionary.
     *
     *
     * @param      dictionary  The dictionary
     */
    public BoggleSolver(final String[] dictionary) {
        bag = new HashSet<String>();
        triesST = new TriesST<Integer>();
        int j = 0;
        for (int i = 0; i < dictionary.length; i++) {
            triesST.put(dictionary[i], j);
            j++;
        }
    }

    /**
     * Gets all valid words.
     * The time complexity is O(N^2).
     *
     * @param      board  The board
     *
     * @return     All valid words.
     */
    public Iterable<String>
    getAllValidWords(final BoggleBoard board) {
        if (board == null) {
            System.out.println("board is null");
            return null;
        }
        for (int i = 0; i < board.rows(); i++) {
            for (int j = 0; j < board.cols(); j++)  {
                boolean[][] marked = new
                boolean[board.rows()][board.cols()];
                validwords(board, i, j, "", marked);

            }
        }
        return bag;
    }
    /**
     * valid words - dfs.
     * The time complexity is O(N^2).
     *
     * @param      board   The board
     * @param      i       { row }
     * @param      j       { column }
     * @param      word    The word
     * @param      marked  The marked
     */

    private void validwords(final BoggleBoard board, final int i,
        final int j, final String word, final boolean[][] marked) {
        if (marked[i][j]) {
            return;
        }
        String w = word;

        if (!triesST.hasPrefix(word)) {
            return;
        }

            char a = board.getLetter(i, j);

            if (a == 'Q') {
                w += "QU";
            } else {
                w += a;
            }

        if (w.length() > 2
            && triesST.contains(w)) {
            bag.add(w);
        }
        marked[i][j] = true;
        for (int di = -1; di <= 1; di++) {
            for (int dj = -1; dj <= 1; dj++) {
                int m = i + di;
                int n = j + dj;
                if (n >= 0 && n < board.cols()
                    && m >= 0 && m < board.rows()) {
                    validwords(board, m, n, w, marked);
                }
            }
        }
        marked[i][j] = false;
    }

    /**
     * returns scores of the words.
     * The time complexity is O(1).
     *
     * @param      word  The word
     *
     * @return     { scores - int }
     */
    public int scoreOf(final String word) {
        final int seven = 7;
        final int eleven = 11;
        final int five = 5;
        final int three = 3;
        final int six = 6;
        final int four = 4;
        if (!triesST.contains(word)) {
            return 0;
        }
        int len = word.length();
        if (len <= 2) {
            return 0;
        } else if (len <= four) {
            return 1;
        } else if (len == five) {
            return 2;
        } else if (len == six) {
            return three;
        } else if (len == seven) {
            return five;
        } else {
            return eleven;
        }
    }
}



