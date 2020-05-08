package problems;

import java.util.ArrayList;

/**
 Given three sorted arrays A, B and Cof not necessarily same sizes.

 Calculate the minimum absolute difference between the maximum and minimum number from the triplet a, b, c such that a, b, c belongs arrays A, B, C respectively.
 i.e. minimize | max(a,b,c) - min(a,b,c) |.

 Example :

 Input:

 A : [ 1, 4, 5, 8, 10 ]
 B : [ 6, 9, 15 ]
 C : [ 2, 3, 6, 6 ]

 Output:

 1

 Explanation: We get the minimum difference for a=5, b=6, c=6 as | max(a,b,c) - min(a,b,c) | = |6-5| = 1.
 */
public class MinDifferenceOf3Arrays {

    public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0, j = 0, k = 0; i <= A.size() - 1 && j <= B.size() - 1 && k <= C.size() - 1; ) {
            int a = A.get(i);
            int b = B.get(j);
            int c = C.get(k);

            int max = max(a, b, c);
            int min = min(a, b, c);

            int diff = max - min;
            minDiff = Math.min(minDiff, diff);

            if (a <= b && a <= c) {
                if (i == A.size() - 1) {
                    if (b <= c) {
                        if (j == B.size() - 1) {
                            k++;
                        } else {
                            j++;
                        }
                    } else {
                        k++;
                    }
                } else {
                    i++;
                }
            } else if (b <= a && b <= c) {
                if (j == B.size() - 1) {
                    if (a <= c) {
                        if (i == A.size() - 1) {
                            k++;
                        } else {
                            i++;
                        }
                    } else {
                        k++;
                    }
                } else {
                    j++;
                }
            }
            if (c <= a && c <= b) {
                if (k == C.size() - 1) {
                    if (a <= b) {
                        if (i == A.size() - 1) {
                            j++;
                        } else {
                            i++;
                        }
                    } else {
                        i++;
                    }
                } else {
                    k++;
                }
            }
        }

        return minDiff;

    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}

