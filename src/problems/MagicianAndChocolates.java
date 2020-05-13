package problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
     Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

     Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

     For example,

     K = 3
     N = 2
     A = 6 5

     Return: 14

     At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
     At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
     At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
     so, total number of chocolates eaten: 6 + 5 + 3 = 14

     Note: Return your answer modulo 10^9+7
 */
public class MagicianAndChocolates {

    public long maxChocolates(int A, ArrayList<Integer> B) {

        PriorityQueue<Integer> heap = new PriorityQueue<>(B.size(), Collections.reverseOrder());
        heap.addAll(B);
        long max = 0;
        while (A > 0) {
            int top = heap.poll();
            max = (max + top) % (1000000007);
            int half = Math.floorDiv(top, 2);
            heap.add(half);
            A--;
        }
        return max;
    }
}