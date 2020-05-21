package problems;

import java.util.ArrayList;
import java.util.Collections;

/**
     Given an array of integers, sort the array into a wave like array and return it,
     In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

     Example

     Given [1, 2, 3, 4]

     One possible answer : [2, 1, 4, 3]
     Another possible answer : [4, 1, 3, 2]

     NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
     So, in example case, you will return [2, 1, 4, 3]
 */
public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        for (int i = 0; i < A.size() - 1; i = i + 2) {
            int cur = A.get(i);
            int nex = A.get(i + 1);
            A.set(i, nex);
            A.set(i + 1, cur);
        }

        return A;
    }
}
