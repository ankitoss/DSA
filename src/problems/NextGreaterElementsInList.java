package problems;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElementsInList {

    public ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> copy = new ArrayList<>(A);

        Stack<Integer> temp = new Stack<>();

        temp.push(0);

        for (int i = 1; i < A.size(); i++) {
            int num = A.get(i);
            int x = A.get(temp.peek());
            while (!temp.isEmpty() && x < num) {
                copy.set(temp.peek(), num);
                temp.pop();
                if (!temp.isEmpty()) {
                    x = A.get(temp.peek());
                }
            }
            temp.push(i);
        }
        while (!temp.isEmpty()) {
            int x = temp.pop();
            copy.set(x, -1);
        }

        return copy;
    }
}