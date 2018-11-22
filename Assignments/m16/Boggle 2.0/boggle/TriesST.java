/**
 * Class for trie st.
 *
 * @param      <Value>  The value
 */
class TriesST<Value> {
    /**
     * // extended ASCII.
     */
    private static final int R = 256;

    /**
     * // root of trie.
     */
    private Node root;
    /**
     * // number of keys in trie.
     */
    private int n;
    // R-way trie node

    /**
     * Class for node.
     */
    private static class Node {
        /**
         * val.
         */
        private Object val;
        /**
         * node.
         */
        private Node[] next = new Node[R];
    }

    /**
      * Initializes an empty string symbol table.
      */
    TriesST() {
    }


    /**
     * {Returns the value associated with the given key}.
     * @param key the key
     * @return the value associated with the
     *  given key if the key is in the symbol table
     *     and {@code null} if the key is not in the symbol table.
     * The time complexity is O(L).
     *
     */
    public Value get(final String key) {

        Node x = get(root, key, 0);
        if (x == null) {
            return null;
        }
        Value res = (Value) x.val;
        return res;
    }

    /**
     * {Does this symbol table contain the given key?}.
     * @param key the key
     * @return {@code true} if this symbol
     *  table contains {@code key} and
     *     {@code false} otherwise
     *
     */
    public boolean contains(final String key) {

        return get(key) != null;
    }

    /**
     * gets the value.
     * The time complexity is O(L).
     *
     *
     * @param      x     { node }
     * @param      key   The key
     * @param      d     { val }
     *
     * @return     { node }
     */
    private Node get(final Node x, final String key,
                     final int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    /**
     * Inserts the key-value pair into the symbol table,
     *  overwriting the old value
     * with the new value if the key is already
     *  in the symbol table.
     * If the value is {@code null}, this effectively
     *  deletes the key from the symbol table.
     * @param key the key
     * @param val the value.
     * The time complexity is O(L).
     *
     *
     */
    public void put(final String key, final Value val) {

        if (val == null) {
            delete(key);
        } else {
            root = put(root, key, val, 0);
        }
    }

    /**
     * puts in Trist.
     * The time complexity is O(L).
     *
     *
     * @param      x     { node }
     * @param      key   The key
     * @param      val   The value
     * @param      d     { val }
     *
     * @return     {node }
     */
    private Node put(final Node x, final String key,
                     final Value val, final int d) {
        Node x1 = x;
        if (x1 == null) {
            x1 = new Node();
        }
        if (d == key.length()) {
            if (x1.val == null) {
                n++;
            }
            x1.val = val;
            return x1;
        }
        char c = key.charAt(d);
        x1.next[c] = put(x1.next[c], key, val, d + 1);
        return x1;
    }

    /**
     * {Returns the number
     *  of key-value pairs in this symbol table}.
     * @return the number of key-value pairs
     *  in this symbol table.
     * The time complexity is O(1).
     *
     */
    public int size() {
        return n;
    }

    /**
     * {Is this symbol table empty?}.
     * The time complexity is O(1).
     * @return {@code true} if this symbol
     *  table is empty and {@code false} otherwise
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * {Returns all keys in the symbol
     *  table as an {@code Iterable}}.
     * To iterate over all of the keys in the
     *  symbol table named {@code st},
     * use the foreach notation:
     *  {@code for (Key key : st.keys())}.
     * @return all keys in the
     *  symbol table as an {@code Iterable}
     */
    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    /**
     * {Returns all of the keys in the set
     *  that start with {@code prefix}}.
     * @param prefix the prefix
     * @return all of the keys in the
     *  set that start with {@code prefix},
     *     as an iterable
     */
    public Iterable<String> keysWithPrefix(final String prefix) {
        Queues<String> results = new Queues<String>();
        Node x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }

    /**
     * Determines if it has prefix.
     *
     * @param      prefix  The prefix
     *
     * @return     True if has prefix, False otherwise.
     */
    public boolean hasPrefix(final String prefix) {
        Node x = get(root, prefix, 0);
        return x != null;

    }

    /**
     * collects all the nodes.
     *
     * @param      x        { nodes }
     * @param      prefix   The prefix
     * @param      results  The results
     */
    private void collect(final Node x, final StringBuilder prefix,
                        final Queues<String> results) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            results.enqueue(prefix.toString());
        }
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    /**
     * Returns all of the keys in the symbol
     *  table that match {@code pattern},
     * where . symbol is treated as a wildcard character.
     * @param pattern the pattern
     * @return all of the keys in the symbol
     *  table that match {@code pattern},
     *     as an iterable, where . is treated as a wildcard character.
     */
    public Iterable<String> keysThatMatch(final String pattern) {
        Queues<String> results = new Queues<String>();
        collect(root, new StringBuilder(), pattern, results);
        return results;
    }

    /**
     * collects all nodes.
     *
     * @param      x        {node}
     * @param      prefix   The prefix
     * @param      pattern  The pattern
     * @param      results  The results
     */
    private void collect(final Node x, final StringBuilder prefix,
                        final String pattern, final Queues<String> results) {
        if (x == null) {
            return;
        }
        int d = prefix.length();
        if (d == pattern.length() && x.val != null) {
            results.enqueue(prefix.toString());
        }
        if (d == pattern.length()) {
            return;
        }
        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, results);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        } else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


    /**
     * Removes the key from the set if the key is present.
     * @param key the key
     *
     */
    public void delete(final String key) {

        root = delete(root, key, 0);
    }

    /**
     * deletetion method.
     *
     * @param      x     {node }
     * @param      key   The key
     * @param      d     { value}
     *
     * @return     { node }
     */
    private Node delete(final Node x, final String key,
                        final int d) {
        if (x == null) {
            return null;
        }
        if (d == key.length()) {
            if (x.val != null) {
                n--;
            }
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d + 1);
        }

        // remove subtrie rooted at x if it is completely empty
        if (x.val != null) {
            return x;
        }
        for (int c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

}
