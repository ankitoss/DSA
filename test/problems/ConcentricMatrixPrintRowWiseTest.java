package problems;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ConcentricMatrixPrintRowWiseTest {

    private ConcentricMatrixPrintRowWise instance = new ConcentricMatrixPrintRowWise();

    private List<List<Integer>> getSize4Result() {
        List<Integer> r1 = Arrays.asList( 4, 4, 4, 4, 4, 4, 4 );
        List<Integer> r2 = Arrays.asList( 4, 3, 3, 3, 3, 3, 4 );
        List<Integer> r3 = Arrays.asList( 4, 3, 2, 2, 2, 3, 4 );
        List<Integer> r4 = Arrays.asList( 4, 3, 2, 1, 2, 3, 4 );
        List<Integer> r5 = Arrays.asList( 4, 3, 2, 2, 2, 3, 4 );
        List<Integer> r6 = Arrays.asList( 4, 3, 3, 3, 3, 3, 4 );
        List<Integer> r7 = Arrays.asList( 4, 4, 4, 4, 4, 4, 4 );

        return Arrays.asList(r1, r2, r3, r4, r5, r6, r7);
    }

    @Test
    void prettyPrint() {

        int size = 4;
        ArrayList<ArrayList<Integer>> result = instance.prettyPrint(size);
        assert result.size() == 2*size - 1;

        List<Object> actual = result.stream().flatMap(List::stream).collect(Collectors.toList());
        List<Object> expected = getSize4Result().stream().flatMap(List::stream).collect(Collectors.toList());
        Assertions.assertIterableEquals(actual, expected);
    }
}