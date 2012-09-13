package usaco;

import java.util.*;
import java.io.*;

class pprime {

    ArrayList<Integer> list = new ArrayList<Integer>();
    void solve() throws IOException {
        int min = nextInt();
        int max = nextInt();
        findAllPrimePalindromes("",max);
        for(int i=0;i<=9;i++)
            findAllPrimePalindromes(""+i,max);

        Collections.sort(list);
        for(Integer i : list){
            if(i<min) continue;
            if(i>max) break;
            out.println(i);
        }
    }

    void findAllPrimePalindromes(String pprime, int maxnumber){
        if(pprime.length()>9)
            return;
        if(pprime.length()>0 && Integer.parseInt(pprime) > maxnumber)
            return;
        if(pprime.length()>0 && isPrime(pprime))
            list.add(Integer.parseInt(pprime));

        for(int i=0;i<=9;i++)
            findAllPrimePalindromes(i+pprime+i,maxnumber);
    }

    boolean isPrime(String prime){
        int n = Integer.parseInt(prime);
        if(n<2) return false;
        for(int i=2;i*i<=n;i++)
            if(n%i == 0)
                return false;
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
        new pprime().run();
    }
}
