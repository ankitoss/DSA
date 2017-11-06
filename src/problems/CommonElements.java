package problems;

/**
 * Find common elements in 3 sorted arrays
 * @author Ankit
 *
 */
public class CommonElements {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 10, 20, 40, 80};
		int ar2[] = {6, 7, 20, 80, 100};
		int ar3[] = {3, 4, 15, 20, 30, 70, 80, 120};
		
		int a = 0,b = 0,c = 0;
		while(a < ar1.length && b < ar2.length && c < ar3.length) {
			
			if((ar1[a] == ar2[b]) && ar2[b] == ar3[c]) {
				System.out.println(ar1[a] + " " + ar2[b] + " " + ar3[c]);
				a++;b++;c++;
				continue;
			}
			int na = a,nb = b, nc = c;
			if(ar1[a] < ar2[b] || ar1[a] < ar3[c]) {
				na++;
			}
			if(ar2[b] < ar1[a] || ar2[b] < ar3[c]) {
				nb++;
			}
			if(ar3[c] < ar1[a] || ar3[c] < ar2[b]) {
				nc++;
			}
			a = na;b = nb; c = nc;
		}
	}

}
