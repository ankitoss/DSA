package problems;

/**
     Given an integer A which denotes the number of people standing in the queue.

     A selection process follows a rule where people standing on even positions are selected.
     Of the selected people a queue is formed and again out of these only people on even position are selected.

     This continues until we are left with one person. Find and return the position of that person in the original queue.



     Input Format

     The only argument given is integer A.

     Output Format

     Return the position of the last selected person in the original queue.

     Constraints

     1 <= A <= 10^9

     For Example

     Input 1:
     A = 10
     Output 1:
     8

     Input 2:
     A = 20
     Output 2:
     16
 */
public class FindingPosition {
    public int solve(int A) {
        if(A < 2) {
            return A;
        }
        int counter = 0;
        int num = A;
        while(num / 2 > 1) {
            num = num/2;
            counter++;
        }
        return (int)Math.pow(2, counter + 1);
    }
}
