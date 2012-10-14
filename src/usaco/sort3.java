package usaco;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Created with IntelliJ IDEA.
 * User: Manchit Gupta
 * Date: 10/7/12
 * Time: 8:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class sort3 {
	public void solve() throws IOException {
		int n = nextInt();
		int []a = new int[n];
		for(int i=0;i<a.length;i++){
			a[i] = nextInt();
		}
		int cnt = 0;
		for(int i=a.length-1;i>=0;i--){
			int max = a[i];
			int loc = -1;
			for(int j=0;j<i;j++){
				if(a[j]>max){
					max = a[j];
					loc = j;
				}
			}
			if(loc!=-1){
				int temp = a[i];
				a[i] = a[loc];
				a[loc] = temp;
				cnt ++;
			}
		}
		out.println(cnt);
	}

	BufferedReader in;
	StringTokenizer tokenizer;
	PrintWriter out;

	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(System.in));
			out = new PrintWriter(System.out);
			//in = new BufferedReader(new FileReader("ride.in"));
			//out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
			tokenizer = null;
			solve();
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	String next() throws IOException {
		return nextToken();
	}
	int nextInt() throws IOException {
		return Integer.parseInt(nextToken());
	}

	long nextLong() throws IOException {
		return Long.parseLong(nextToken());
	}

	double nextDouble() throws IOException {
		return Double.parseDouble(nextToken());
	}

	String nextToken() throws IOException {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			tokenizer = new StringTokenizer(in.readLine());
		}
		return tokenizer.nextToken();
	}

	public static void main(String[] args) {
		new sort3().run();
	}

}
