package code;

import inout.InputReader;
import inout.OutputWriter;

import java.util.Arrays;

class BeautifulStrigs {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    String s = in.nextLine();
		s = s.toLowerCase();
	    int []arr =  new int[256];
		for(int i=0;i<s.length();i++){
			int index = s.charAt(i);
			if(! Character.isAlphabetic( s.charAt(i))) continue;
			arr[index]++;
		}

	    Arrays.sort( arr );

	    int val = 26;
	    int res = 0;
	    for(int i=arr.length-1;i>=0;i--){
	        res += val * arr[i];
		    val--;
	    }

	    out.println("Case #" + testNumber + ": " + res);
    }
}
