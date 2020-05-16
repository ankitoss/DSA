package problems;

/**
     Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

     Example:

     "A man, a plan, a canal: Panama" is a palindrome.

     "race a car" is not a palindrome.
 */
public class PalindromeString {

    public boolean isPalindrome(String A) {
        int start = 0;
        int end = A.length() - 1;
        while (start < end) {
            char st = A.charAt(start);
            char en = A.charAt(end);
            if (!isAlphaNum(st)) {
                start++;
            }
            if (!isAlphaNum(en)) {
                end--;
            }

            if (isAlphaNum(st) && isAlphaNum(en)) {
                boolean eq = String.valueOf(st).equalsIgnoreCase(String.valueOf(en));

                if (!eq) {
                    return false;
                }

                start++;
                end--;
            }
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return Character.isLetterOrDigit(c);
    }
}
