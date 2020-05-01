package problems;

import java.util.ArrayList;

public class ConcentricMatrixPrintRowWise {

    public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        int depth = a;
        for(int i = 0; i < 2*a - 1; i++) {
            ArrayList<Integer> array = new ArrayList<>();

            int width = a;

            for(int j = 0; j < 2*a -1; j++) {

                int max = Math.max(depth, width);
                array.add(max);

                if(j < a - 1) {
                    width--;
                } else {
                    width++;
                }
            }
            result.add(array);

            if(i < a - 1) {
                depth--;
            } else {
                depth++;
            }
        }

        return result;
    }
}
