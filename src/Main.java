import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		frac1 solver = new frac1();
		solver.solve(1, in, out);
		out.close();
	}
}

class frac1 {
    class fractions implements Comparable<fractions>{
        double value;
        String item;

        public fractions(double value, String item){
            this.value = value;
            this.item = item;
        }

        public int compareTo(fractions f){
            double diff = value - f.value;
            if(diff > 1e-8) return 1;
            if(diff < -1e-8) return -1;
            return 0;
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();

        dfs(n,1,n,0);

//        Collections.sort(list);

        Arrays.sort(arr);
        out.println("0/1");
        int limit = (n*n - n)/2;
        for(int i=0;i<limit;i++)
            out.println(arr[i]);
        out.println("1/1");
    }

//    ArrayList<fractions> list = new ArrayList<fractions>();

    fractions [] arr = new fractions[20000];
    void dfs(int n , int num, int deno, int i){
        if(deno == 0 || num>deno){
            return;
        }
        if(num == deno){
            dfs(n,1,deno-1,i+1);
            return;
        }

        if(!(num!=1 && deno%num == 0))
        {
            double value = (num*1.0)/deno;
            String item = num + "/" + deno;
            fractions frac = new fractions(value, item);
            arr[i] = frac;
        }
        dfs(n,num+1,deno,i+1);
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

    }

