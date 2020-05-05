package problems;

import java.util.ArrayList;
import java.util.List;

public class RepeatedAndMissingNumber {

    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        //[3 1 2 5 3]
        ArrayList<Integer> a = new ArrayList<>(A);
        Integer repeat = null;
        Integer missing = null;
        for (int i = 0; i < a.size(); i++) {
            int v = a.get(i);
            int index = Math.abs(v) - 1;
            int val = a.get(index);
            if (val < 0) {
                repeat = index + 1;
            } else {
                a.set(index, -1 * val);
            }
        }
        for (int i = 0; i < a.size(); i++) {
            int v = a.get(i);
            if (v > 0) {
                missing = i + 1;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeat);
        result.add(missing);
        return result;
    }
}