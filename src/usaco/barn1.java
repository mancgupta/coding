/*
ID: mancgup2
LANG: JAVA
TASK: barn1
*/

package usaco;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class barn1 {
    void solve() throws IOException {
        int m = nextInt();
        int s = nextInt();
        int c = nextInt();

        int []cow = new int[c];
        for(int i=0;i<c;i++)
            cow[i] = nextInt();

        Arrays.sort(cow);
        int prev = cow[0];

        int []gap = new int[c];
        for(int i=1;i<c;i++){
            gap[i] = cow[i] - prev - 1;
            prev = cow[i];
        }

        Arrays.sort(gap);
        int x = 1;
        int max = cow[cow.length-1] - cow[0] + 1;

        int index = gap.length-1;
        while (x < m && index>=0) {

            int val = gap[index];
            if(val == 0 ) break;
            max -= val;
            x++;
            index--;
        }

        out.println(max);
    }
    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            //in = new BufferedReader(new InputStreamReader(System.in));
            //out = new PrintWriter(System.out);
            in = new BufferedReader(new FileReader("barn1.in"));
            out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
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
        new barn1().run();
    }
}
