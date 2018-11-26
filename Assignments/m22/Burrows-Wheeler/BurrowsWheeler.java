
import java.util.HashMap;
import java.util.Arrays;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;
public class BurrowsWheeler {


    public static void transform() {
    	String str = BinaryStdIn.readString();
    	CircularSuffixArray csa = new CircularSuffixArray(str);
    	for (int i = 0; i < csa.length(); i++) {
    		if (csa.index(i) == 0) {
    			BinaryStdOut.write(i);
    			break;
    		}
    	}
    	for (int i = 0; i < csa.length(); i++) {
    		int indx = csa.index(i);
    		if (indx == 0) {
    			BinaryStdOut.write(str.charAt(str.length() - 1));
    		} else {
    			BinaryStdOut.write(str.charAt(indx - 1));
    		}
    	}

    }

    public static void inverseTransform() {
    	int n = BinaryStdIn.readInt();
    	String str = BinaryStdIn.readString();
    	char[] chr = str.toCharArray();
    	HashMap<Character, Queue<Integer>> hm = new HashMap<Character, Queue<Integer>>();
    	for (int i = 0; i < ch.length; i++) {
    		if (!hm.containsKey(ch[i])) {
    			hm.put(ch[i], )

    }

    public static void main(String[] args) {

    }
}
