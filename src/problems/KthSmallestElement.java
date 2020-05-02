package problems;

import java.util.List;
import java.util.PriorityQueue;

public class KthSmallestElement {

    public int kthsmallest(final List<Integer> A, int B) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(A);
        for(int i =0; i < B-1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}