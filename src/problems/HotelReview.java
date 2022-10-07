package problems;

import pojo.Trie;

import java.util.*;

/**
     Given a set of reviews provided by the customers for different hotels and a string containing "Good Words", you need to sort the reviews in descending order according to their "Goodness Value" (Higher goodness value first). We define the "Goodness Value" of a string as the number of "Good Words" in that string.

     Note: Sorting should be stable. If review i and review j have the same "Goodness Value" then their original order would be preserved.

     You are expected to use Trie in an Interview for such problems

     Constraints:

     1.   1 <= No.of reviews <= 200
     2.   1 <= No. of words in a review <= 1000
     3.   1 <= Length of an individual review <= 10,000
     4.   1 <= Number of Good Words <= 10,000
     5.   1 <= Length of an individual Good Word <= 4
     6.   All the alphabets are lower case (a - z)

     Input:

     S : A string S containing "Good Words" separated by  "_" character. (See example below)
     R : A vector of strings containing Hotel Reviews. Review strings are also separated by "_" character.

     Output:

     A vector V of integer which contain the original indexes of the reviews in the sorted order of reviews.

     V[i] = k  means the review R[k] comes at i-th position in the sorted order. (See example below)
     In simple words, V[i]=Original index of the review which comes at i-th position in the sorted order. (Indexing is 0 based)

     Example:

     Input:
     S = "cool_ice_wifi"
     R = ["water_is_cool", "cold_ice_drink", "cool_wifi_speed"]

     Output:
     ans = [2, 0, 1]
     Here, sorted reviews are ["cool_wifi_speed", "water_is_cool", "cold_ice_drink"]
 */
public class HotelReview {

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Trie trie = new Trie();

        String[] tokens = A.split("_");
        for (String s : tokens) {
            trie.insert(s);
        }

        HashMap<String, Integer> origInd = new HashMap<>();
        for (int i = 0; i < B.size(); i++) {
            origInd.put(B.get(i), i);
        }

        /* LinkedHashMap to maintain insertion order,
                 in case 2 strings have same occurrences or words
         */
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();


        for (String review : B) {
            String[] tok = review.split("_");
            for (String word : tok) {
                boolean has = trie.find(word);
                if (!map.containsKey(review)) {
                    map.put(review, has ? 1 : 0);
                } else {
                    if (has) {
                        map.put(review, map.get(review) + 1);
                    }
                }
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(new Comp());
        System.out.println(list);

        ArrayList<Integer> indexes = new ArrayList<>();
        for (Map.Entry<String, Integer> item : list) {
            String key = item.getKey();
            indexes.add(origInd.get(key));
        }
        return indexes;
    }


}

class Comp implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return -1 * o1.getValue().compareTo(o2.getValue());
        //-1 to reverse sort
    }
}

