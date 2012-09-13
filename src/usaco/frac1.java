package usaco;

import java.util.*;
import java.io.*;

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

    public void solve() throws IOException {
        int n = nextInt();

        dfs(n,1,n);

        Collections.sort(list);

        out.println("0/1");
        for(fractions f: list){
            out.println(f.item);
        }
        out.println("1/1");
    }

    ArrayList<fractions> list = new ArrayList<fractions>();

    void dfs(int n , int num, int deno){
        if(deno == 0){
            return;
        }
        if(num == deno){
            dfs(n,1,deno-1);
            return;
        }

        if(num!=1 && deno%num == 0){
            dfs(n,num+1,deno);
        }
        else{
            double value = (num*1.0)/deno;

            String item = num + "/" + deno;

            fractions frac = new fractions(value, item);

            list.add(frac);
            dfs(n,num+1,deno);
        }
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
        new frac1().run();
    }
}
