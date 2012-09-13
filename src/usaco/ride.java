/*
ID: mancgup2
LANG: JAVA
TASK: ride
*/
package usaco;

import java.util.*;
import java.io.*;

class ride {
    void solve() throws IOException {
        String comet = next();
        String group = next();

        int c = 1, g = 1;
        for(int i=0;i< comet.length();i++)  c *= comet.charAt(i) - 'A' + 1;
        for(int i=0;i< group.length();i++)  g *= group.charAt(i) - 'A' + 1;

        if(c%47 == g%47)
            out.println("GO");
        else
            out.println("STAY");

    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //reader = new BufferedReader(new FileReader("ride.in"));
            //writer = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
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
        new ride().run();
    }
}
