package usaco;

import java.util.*;
import java.io.*;

class numtri {
    public void solve() throws IOException {
        int rows = nextInt();

        long [][]a = new long[rows][rows];
        for(int i=0;i<rows;i++)
            for(int j=0;j<=i;j++)
                a[i][j] = nextLong();

        for(int i=rows-2;i>=0;i--)
            for(int j=0;j<=i;j++)
                a[i][j]+=Math.max(a[i+1][j],a[i+1][j+1]);

       out.println(a[0][0]);
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("numtri.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
            tokenizer = null;
            solve();
            in.close();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        new numtri().run();
    }
}
