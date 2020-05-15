package problems;

/**
     The count-and-say sequence is the sequence of integers beginning as follows:

     1, 11, 21, 1211, 111221, ...

     1 is read off as one 1 or 11.
     11 is read off as two 1s or 21.

     21 is read off as one 2, then one 1 or 1211.

     Given an integer n, generate the nth sequence.

     Note: The sequence of integers will be represented as a string.

     Example:

     if n = 2,
     the sequence is 11
 */
public class CountAndSay {

    public String countAndSay(int A) {
        String num = "1";
        for (int i = 1; i < A; i++) {
            num = getNext(num);
        }
        return num;
    }

    String getNext(String number) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char num = number.charAt(0);
        for (int i = 1; i < number.length(); i++) {
            char n = number.charAt(i);
            if (n == num) {
                count++;
            } else {
                sb.append(count);
                sb.append(num);
                num = n;
                count = 1;
            }
        }

        sb.append(count);
        sb.append(num);

        return sb.toString();
    }
}