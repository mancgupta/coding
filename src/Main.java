import java.io.InputStreamReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.Writer;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Manchit Gupta
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("findminimum.in");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("findminimum.out");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		InputReader in = new InputReader(inputStream);
		OutputWriter out = new OutputWriter(outputStream);
		FindMinimum solver = new FindMinimum();
		int testCount = Integer.parseInt(in.next());
		for (int i = 1; i <= testCount; i++)
			solver.solve(i, in, out);
		out.close();
	}
}

class FindMinimum {
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

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;
    public InputReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
        tokenizer = null;
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

	public int nextInt(){
        return Integer.parseInt(next());
    }

    public long nextLong(){
        return Long.parseLong(next());
    }

}

class OutputWriter {
	private final PrintWriter writer;

	public OutputWriter(OutputStream outputStream) {
		writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
	}

	public OutputWriter(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void print(Object...objects) {
		for (int i = 0; i < objects.length; i++) {
			if (i != 0)
				writer.print(' ');
			writer.print(objects[i]);
		}
	}

	public void println(Object...objects) {
		print(objects);
		writer.println();
	}

	public void close() {
		writer.close();
	}

}

