package Helper;

import java.util.Arrays;

public class ArrayHelper {
    public static boolean [][]toBooleanArray(String []a){
        int r = a.length;
        int c = a[0].length();

        boolean [][]ret = new boolean[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                ret[i][j] = a[i].charAt(j)=='Y' || a[i].charAt(j)=='y' ? true : false;

        return ret;
    }

    public static char [][] toCharArray(String []a){
        int r = a.length;
        int c = a[0].length();

        char  [][]ret = new char[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                ret[i][j] = a[i].charAt(j);
        return ret;
    }

	public static boolean isPrime(long n) {
		if(n < 2) return false;
		if(n == 2 || n == 3) return true;
		if(n%2 == 0 || n%3 == 0) return false;
		for(long i = 6L; i*i <= n; i += 6) {
			if(n%(i-1) == 0 || n%(i+1) == 0) return false;
		}
		return true;
	}

	public static boolean [] sieve(int n){
		boolean []sieve = new boolean[n+1];
		Arrays.fill(sieve,true);
		sieve[0] = false;
		sieve[1] = false;
		for(int i=2;i*i<=n;i++)
			for(int j = i*i;j<=n;j += i)
				sieve[j] = false;
		return sieve;
	}

	public static boolean [] sieveOfAtkin(int limit) {
		boolean[] sieve = new boolean[limit + 1];

		sieve[0] = false;
		sieve[1] = false;
		sieve[2] = true;
		sieve[3] = true;

		for (int x = 1; x*x <= limit; x++) {
			for (int y = 1; y*y <= limit; y++) {

				int n = (4 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
					sieve[n] = !sieve[n];
				}
				n = (3 * x * x) + (y * y);
				if (n <= limit && (n % 12 == 7)) {
					sieve[n] = !sieve[n];
				}
				n = (3 * x * x) - (y * y);
				if (x > y && n <= limit && (n % 12 == 11)) {
					sieve[n] = !sieve[n];
				}
			}
		}
		for (int n = 5; n*n <= limit; n++) {
			if (sieve[n]) {
				int x = n * n;
				for (int i = x; i <= limit; i += x) {
					sieve[i] = false;
				}
			}
		}
		return sieve;
	}
}
