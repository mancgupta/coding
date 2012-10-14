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

	public static void swap(int []a, int to, int from){
		int temp = a[to];
		a[to] = a[from];
		a[from] = temp;
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
		sieve[0] = sieve[1] = false;
		for(int i=2;i*i<=n;i++)
			if(sieve[i])
				for(int j = i*i;j<=n;j += i)
					sieve[j] = false;
		return sieve;
	}
}
