// import edu.princeton.cs.algs4.BinaryStdIn;
// import edu.princeton.cs.algs4.BinaryStdOut;

public class MoveToFront {
	private static final int lgR = 8;
    public static void encode() {
    	char[] ch = new char[256];
    	for (int i = 0; i < ch.length; i++) {
    		ch[i] = (char) i;
    	}
    	String str = BinaryStdIn.readString();
    	String[] s = str.split(" ");
    	for (int j = 0; j < str.length(); j++) {
    		char c = str.charAt(j);
    		int indx = 0;
            for (int k = 0; k < ch.length; k++) {
            	if (c == ch[k]) {
            		indx = k;
            		BinaryStdOut.write(k, lgR);
            		break;
            	}
            }
            char[] temp = new char[256];
            temp[0] = c;
            int m = 1;
            for (int l = 0; l < ch.length; l++) {
            	if (l != indx) {
            		temp[m++] = ch[l];
            	} else {
            		continue;
            	}
            }
            ch = temp;
    	}
    	BinaryStdOut.close();
    }
    public static void decode() {
    	char[] ch = new char[256];
    	for (int i = 0; i < ch.length; i++) {
    		ch[i] = (char) i;
    	}
    	String str = BinaryStdIn.readString();
    	String[] s = str.split(" ");
    	for (int j = 0; j < str.length(); j++) {
    		int c = str.charAt(j);
    		char indx = 0;
            for (int k = 0; k < ch.length; k++) {
            	if (c == k) {
            		indx = ch[k];
            		BinaryStdOut.write(indx, lgR);
            		break;
            	}
            }
            char[] temp = new char[256];
            temp[0] = indx;
            int m = 1;
            for (int l = 0; l < ch.length; l++) {
            	if (l != c) {
            		temp[m++] = ch[l];
            	} else {
            		continue;
            	}
            }
            ch = temp;
    	}
    	BinaryStdOut.close();
    }
    public static void main(String[] args) {
        if (args[0].equals("-")) {
        	encode();
        } else if (args[0].equals("+")) {
            decode();
        }
    }
}