package code;

import inout.InputReader;
import inout.OutputWriter;

import java.util.*;

public class FindMinimum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    int n = in.nextInt();
	    int k = in.nextInt();

	    long a = in.nextLong();
	    long b = in.nextLong();
	    long c = in.nextLong();
	    long r = in.nextLong();

        long [] arr = new long[1000000];

	    long prev = a;
		arr[0] = a;

	    HashMap<Long, Integer> map = new HashMap<Long, Integer>();

	    int []hash = new int[k+1];

        map.put( a, 0);
        for( int i=1;i < k;i++)
        {
	        arr[i] = ( b * prev + c) % r ;
	        prev = arr[i];
	        if( prev < hash.length)
		        hash[(int)prev] ++ ;
//	        if( map.containsKey(prev))
//		        map.put( prev , map.get(prev) + 1);
//	        else
//	            map.put( prev ,0);
        }

	    long ans = -1;
	    for( int i=k;i< 2*k + 1;i++)
	    {
		    for( long j=0;j<=k;j++){
			    if( hash[(int)j] <= 0){
				    long item = arr[i-k];
				    if( item < hash.length)
			        hash[(int)item]--;

				    hash[(int)j]++;
				    arr[i] = j;
				    break;
			    }

/*
			    if(!map.containsKey(j)){
					if( map.containsKey(item)){
			            if( map.get(item) == 0)
				            map.remove( item );
			            else
				            map.put(item , map.get(item) - 1);
					}

				    if( map.containsKey(j))
					    map.put(j , map.get(j) + 1);
				    else
					    map.put(j,1);

				    arr[i] = j;
				    if ( i == n-1)
				        ans = j;
				    break;
			    }
*/
		    }
//		    if( ans != -1)
//			    break;
	    }

	    int index = (n - k) % (k+1) + k - 1;

	    ans = arr[index];

	    out.println("Case #" + testNumber + ": " + ans);
//	    for ( int i = 0;i< arr.length;i++)
//	        out.print(  arr[i] + " " );
    }
}
