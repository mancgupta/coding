import java.util.List;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Collections;
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

        dfs(n,1,n,cnt);

        Collections.sort(list);

        out.println("0/1");
        for(fractions f: list){
            out.println(f.item);
        }
        out.println("1/1");
        out.println(cnt);
	}

    int cnt= 0;
    ArrayList<fractions> list = new ArrayList<fractions>();

    void dfs(int n , int num, int deno, int i){
        cnt = i;
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
            list.add(frac);
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

