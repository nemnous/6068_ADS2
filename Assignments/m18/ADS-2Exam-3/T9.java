import java.util.HashMap;
import java.util.List;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Comparator;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;


class T9 {
    /**
     * tst object.
     */
    private TST<Integer> tstObj;
    /**
     * Constructs the object.
     *
     * @param      st    symbol table.
     */
    T9(final BinarySearchST<String, Integer> st) {
        // your code goes here

        tstObj = new TST<Integer>();
        for (String word : st.keys()) {
            if (word.length() > 0) {
                // System.out.println(word);
                tstObj.put(word, st.get(word));
            }
        }
    }

    // get all the prefixes that match with given prefix.

    /**
     * Gets all words.
     *
     * @param      prefix  The prefix
     *
     * @return     All words.
     */
    public Iterable<String> getAllWords(final String prefix) {


        // your code goes here


        return tstObj.keysWithPrefix(prefix);
    }

    /**
     * potential Words function.
     *
     * @param      t9Signature  The t 9 signature
     *
     * @return     { description_of_the_return_value }
     */
    public Iterable<String> potentialWords(final String t9Signature) {
        // your code goes here
        return null;
    }

    // return all possibilities(words), find top k with highest frequency.
    // public Iterable<String> getSuggestions(Iterable<String> words, int k) {
    //  // your code goes here
    //  Map<String, Integer> lMap=new HashMap<String, Integer>();
    //  for(String word : words) {
    //      int freqsum = 0;
    //      for(String pre : tstObj.keysWithPrefix(word)) {
    //          freqsum += tstObj.get(pre);
    //      }
    //      lMap.put(word, freqsum);
    //  }

    //  Map<String, Integer> sorted = lMap
//        .entrySet()
//        .stream()
//        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//        .collect(
//            toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
//                LinkedHashMap::new));

//    System.out.println("map after sorting by values in descending order: "
//        + sorted);

    //  // lMap.put("nani", 22);
    //  // Set<Entry<String, Integer>> set = lMap.entrySet();
//  //       List<Entry<String, Integer>> list = new ArrayList<Entry<String, Integer>>(set);
//  //       Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
//  //       {
//  //           public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
//  //           {
//  //               return (o2.getValue()).compareTo( o1.getValue() );
//  //           }
//  //       } );

    //  // for(String word : words)
    //  //  lMap.put(word, tstObj.get(word));
    //  // MyComparator comp=new MyComparator(lMap);

    //  //    Map<String,Integer> newMap = new TreeMap(comp);
    //  //    newMap.putAll(lMap);

    //  //    for(int i : newMap.values()) {
    //  //      System.out.println(i);
    //  //    }
    //     // System.out.println(" values in dict:" + tstObj.get("hello"));
    //  return lMap.keySet();
    // }

    /**
     * Sorts the dictionary.
     *
     * @param      hm    hashmap.
     *
     * @return     sorted hashmap
     */
    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
            new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }

    /**
     * Gets the suggestions.
     *
     * @param      words  The words
     * @param      k      top k words.
     *
     * @return     The suggestions.
     */
    public Iterable<String> getSuggestions(Iterable<String> words, int k) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (String word : words) {
            for (String pre : tstObj.keysWithPrefix(word)) {
                hm.put(pre, tstObj.get(pre));
                // System.out.println(pre + " : " + tstObj.get(pre));

            }
        }

        Map<String, Integer> hm1 = sortByValue(hm);
        // Queue<String> que = new Queue<String>();
        ArrayList al = new ArrayList();
        int i = 0;
        for (String key : hm1.keySet()) {
            al.add(key);
            i++;
            if (i == k) {
                break;
            }
        }
        Collections.sort(al);
        return al;
    }
    // final output
    // Don't modify this method.
    public Iterable<String> t9(String t9Signature, int k) {
        return getSuggestions(potentialWords(t9Signature), k);
    }
}

// class MyComparator implements Comparator {

//  Map map;

//  public MyComparator(Map map) {
//      this.map = map;
//  }

//  public int compare(Object o1, Object o2) {
//      int result = ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));
//      if(result == 0) {
//          return result;
//      }
//      return result;

//  }
// }
