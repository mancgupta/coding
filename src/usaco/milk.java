package usaco;

import java.util.*;
import java.io.*;

class milk {
    class cost implements Comparable<cost>{
        int cent;
        int value;

        public cost(int cent, int value){
            this.cent = cent;
            this.value = value;
        }
        public int compareTo(cost c){
            return cent - c.cent;
        }
    }
    void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();

        cost []c = new cost[m];
        for(int i=0;i<m;i++)
            c[i] = new cost(nextInt(),nextInt());

        Arrays.sort(c);

        int totalCost = 0;
        for(int i=0;i<m;i++){
            if(n>c[i].value) {
                totalCost += c[i].value * c[i].cent;
                n -= c[i].value;
            }
            else{
                totalCost += n * c[i].cent;
                break;
            }
        }
        out.println(totalCost);
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("input.txt"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
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
        new milk().run();
    }
}
