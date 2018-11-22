/******************************************************************************
 *  Compilation:  javac Queues.java
 *  Execution:    java Queues < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt  
 *
 *  A generic queues, implemented using a linked list.
 *
 *  % java Queues < tobe.txt 
 *  to be or not to be (2 left on queues)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  The {@code Queues} class represents a first-in-first-out (FIFO)
 *  queues of generic items.
 *  It supports the usual <em>enqueue</em> and <em>dequeue</em>
 *  operations, along with methods for peeking at the first item,
 *  testing if the queues is empty, and iterating through
 *  the items in FIFO order.
 *  <p>
 *  This implementation uses a singly-linked list with a static nested class for
 *  linked-list nodes. See {@link LinkedQueue} for the version from the
 *  textbook that uses a non-static nested class.
 *  See {@link ResizingArrayQueue} for a version that uses a resizing array.
 *  The <em>enqueue</em>, <em>dequeue</em>, <em>peek</em>, <em>size</em>, and <em>is-empty</em>
 *  operations all take constant time in the worst case.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/13stacks">Section 1.3</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 *  @param <Item> the generic type of an item in this queues
 */
public class Queues<Item> implements Iterable<Item> {
    private Node<Item> first;    // beginning of queues
    private Node<Item> last;     // end of queues
    private int n;               // number of elements on queues

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queues.
     */
    public Queues() {
        first = null;
        last  = null;
        n = 0;
    }

    /**
     * Returns true if this queues is empty.
     *
     * @return {@code true} if this queues is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this queues.
     *
     * @return the number of items in this queues
     */
    public int size() {
        return n;
    }

    /**
     * Returns the item least recently added to this queues.
     *
     * @return the item least recently added to this queues
     * @throws NoSuchElementException if this queues is empty
     */
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Queues underflow");
        return first.item;
    }

    /**
     * Adds the item to this queues.
     *
     * @param  item the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty()) first = last;
        else           oldlast.next = last;
        n++;
    }

    /**
     * Removes and returns the item on this queues that was least recently added.
     *
     * @return the item on this queues that was least recently added
     * @throws NoSuchElementException if this queues is empty
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queues underflow");
        Item item = first.item;
        first = first.next;
        n--;
        if (isEmpty()) last = null;   // to avoid loitering
        return item;
    }

    /**
     * Returns a string representation of this queues.
     *
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    } 

    /**
     * Returns an iterator that iterates over the items in this queues in FIFO order.
     *
     * @return an iterator that iterates over the items in this queues in FIFO order
     */
    public Iterator<Item> iterator()  {
        return new ListIterator<Item>(first);  
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator<Item> implements Iterator<Item> {
        private Node<Item> current;

        public ListIterator(Node<Item> first) {
            current = first;
        }

        public boolean hasNext()  { return current != null;                     }
        public void remove()      { throw new UnsupportedOperationException();  }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
}
