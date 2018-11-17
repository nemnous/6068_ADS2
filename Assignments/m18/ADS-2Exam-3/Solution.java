import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

// import static java.util.stream.Collectors.*;
// import static java.util.Map.Entry.*;


/**
 * Class for solution.
 */
final class Solution {

    // Don't modify this method.

    /**
     * Constructs the object.
     */
    private Solution() {
        /**
         * unused.
         */
    }

    /**
     * this is main funtion.
     * the input and output to the console is driven from here.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String cases = scan.nextLine();

        switch (cases) {
        case "loadDictionary":
            // input000.txt and output000.txt
            BinarySearchST<String, Integer> hash = loadDictionary(
"F:/PROGRAMMING/6068_ADS2/Assignments/m18/ADS-2Exam-3/Files/t9.csv");
            while (scan.hasNextLine()) {
                String key = scan.nextLine();
                System.out.println(hash.get(key));
            }
            break;

        case "getAllPrefixes":
            // input001.txt and output001.txt
            T9 t9 = new T9(loadDictionary(
"F:/PROGRAMMING/6068_ADS2/Assignments/m18/ADS-2Exam-3/Files/t9.csv"));
            while (scan.hasNextLine()) {
                String prefix = scan.nextLine();
                for (String each : t9.getAllWords(prefix)) {
                    System.out.println(each);
                }
            }
            break;

        case "potentialWords":
            // input002.txt and output002.txt
            t9 = new T9(loadDictionary(
"F:/PROGRAMMING/6068_ADS2/Assignments/m18/ADS-2Exam-3/Files/t9.csv"));
            int count = 0;
            while (scan.hasNextLine()) {
                String t9Signature = scan.nextLine();
                for (String each : t9.potentialWords(t9Signature)) {
                    count++;
                    System.out.println(each);
                }
            }
            if (count == 0) {
                System.out.println("No valid words found.");
            }
            break;

        case "topK":
            // input003.txt and output003.txt
            t9 = new T9(loadDictionary(
"F:/PROGRAMMING/6068_ADS2/Assignments/m18/ADS-2Exam-3/Files/t9.csv"));
            Bag<String> bag = new Bag<String>();
            int k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                bag.add(line);
            }
            for (String each : t9.getSuggestions(bag, k)) {
                System.out.println(each);
            }

            break;

        case "t9Signature":
            // input004.txt and output004.txt
            t9 = new T9(loadDictionary(
"F:/PROGRAMMING/6068_ADS2/Assignments/m18/ADS-2Exam-3/Files/t9.csv"));
            bag = new Bag<String>();
            k = Integer.parseInt(scan.nextLine());
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                for (String each : t9.t9(line, k)) {
                    System.out.println(each);
                }
            }
            break;

        default:
            break;

        }
    }

    // Don't modify this method.

    /**
     * to read file.
     *
     * @param      file  The file
     *
     * @return     string array
     */
    public static String[] toReadFile(final String file) {
        In in = new In(file);
        return in.readAllStrings();
    }
    /**
     * Loads a dictionary.
     *
     * @param      file  The file
     *
     * @return     returns dictionary
     */
    public static BinarySearchST<String, Integer> loadDictionary(
        final String file) {
        BinarySearchST<String, Integer>  st
            = new BinarySearchST<String, Integer>();
        // your code goes here

        Path path = Paths.get(file);
        try {
            Scanner scanner = new Scanner(path);
            //read line by line
            while (scanner.hasNextLine()) {
                //process each line
                String[] line = scanner.nextLine().toLowerCase().split(" ");
                for (String word : line) {
                    if (st.contains(word)) {
                        int val = st.get(word);
                        st.put(word, ++val);
                    } else {
                        st.put(word, 1);
                    }
                }
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return st;

    }

}

/**
 * Class for t 9.
 */

