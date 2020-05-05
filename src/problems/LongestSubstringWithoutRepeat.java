package problems;

import java.util.HashSet;

public class LongestSubstringWithoutRepeat {

    public int lengthOfLongestSubstring(String A) {

        int maxLen = 0;
        int lastRepeat = 0;
        HashSet<Character> hash = new HashSet<>();
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            if (hash.contains(c)) {
                hash.clear();
                i = A.indexOf(c, lastRepeat);
                lastRepeat = i + 1;
            } else {
                hash.add(c);
                maxLen = Math.max(maxLen, hash.size());
            }
        }
        return maxLen;
    }
}
