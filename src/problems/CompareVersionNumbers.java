package problems;

/**
     Compare two version numbers version1 and version2.

     If version1 > version2 return 1,
     If version1 < version2 return -1,
     otherwise return 0.

     You may assume that the version strings are non-empty and contain only digits and the . character.
     The . character does not represent a decimal point and is used to separate number sequences.
     For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

     Here is an example of version numbers ordering:

     0.1 < 1.1 < 1.2 < 1.13 < 1.13.4

 */

public class CompareVersionNumbers {

    public int compareVersion(String A, String B) {
        String regex = "\\.";
        String[] a = A.split(regex);
        String[] b = B.split(regex);

        for (int i = 0; i < Math.max(a.length, b.length); i++) {
            if (i >= a.length && i <= b.length) {
                return containsOnlyZero(b, i) ? 0 : -1;
            }

            if (i <= a.length && i >= b.length) {
                return containsOnlyZero(a, i) ? 0 : 1;
            }

            //TODO instead compare strings character by character
            int comp = new java.math.BigInteger(a[i]).compareTo(new java.math.BigInteger(b[i]));
            if (comp != 0) {
                return comp;
            }
        }

        return 0;
    }

    private boolean containsOnlyZero(String[] s, int start) {
        for (int i = start; i < s.length; i++) {
            int res = new java.math.BigInteger(s[i]).compareTo(new java.math.BigInteger("0"));
            if (res != 0) {
                return false;
            }
        }
        return true;
    }
}
