package usaco;

import java.util.*;
import java.io.*;

class sprime {

    ArrayList<Integer> list = new ArrayList<Integer>();
    void solve() throws IOException {
        int n = nextInt();
        int []a = {1,2,3,5,7,9};

        findSuperPrime(a,n,0,0);

        for(Integer i: list)
            out.println(i);
    }

    void findSuperPrime(int []a, int n, int i, int val){
        if(i == n){
            list.add(val);
            return;
        }

        for(int j=0;j<a.length;j++){
            int x = 10 * val + a[j];
            if(isPrime(x))
                findSuperPrime(a,n,i+1,x);
        }
    }

    boolean isPrime(int n){
        if(n<2) return false;
        if(n == 2) return true;
        for(int i=2;i*i<=n;i++)
            if(n%i ==0 ) return false;
        return true;
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
        new sprime().run();
    }
}
