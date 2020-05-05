package problems;

import java.util.List;
import java.util.PriorityQueue;

public class LongestConsecutiveSubsequence {
    public int longestConsecutive(final List<Integer> A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        int cur = 0;
        int max = 0;
        int last = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int x = pq.poll();
            if (x == last) {
                continue;
            } else if (x == last + 1) {
                cur++;
            } else {
                cur = 1;
            }
            max = Math.max(cur, max);
            last = x;
        }

        return max;
    }
}
