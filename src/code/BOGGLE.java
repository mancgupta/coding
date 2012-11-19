package code;

import inout.InputReader;
import inout.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOGGLE {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n = in.nextInt();
		HashMap<String,Integer> map = new HashMap<String, Integer>();

		for(int i=0;i<n;i++){
			String s = in.nextLine();

			StringTokenizer tokenizer = new StringTokenizer(s);
			while (tokenizer.hasMoreTokens()) {
				String token = tokenizer.nextToken();
				if(map.containsKey(token)) map.put(token,0);
				else{
					map.put(token,i+1);
				}
			}
		}

		long []points = new long[n];

		for( Map.Entry entry : map.entrySet()){
			if((Integer)entry.getValue()>0){
				points[(Integer)entry.getValue()-1] += findPoints((String)entry.getKey());
			}
		}

		long max= 0 ;
		for(int i=0;i<n;i++)
			max = Math.max(points[i],max);

		out.println(max);
	}

	int findPoints(String s){
		int len = s.length();
		if(len <=4) return 1;
		if(len == 5) return 2;
		if(len == 6) return 3;
		if(len == 7) return 5;
		return 11;
	}
}
