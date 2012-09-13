package usaco;

import java.util.*;
import java.io.*;

class palsquare {

    char [] val = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K'};
    void solve() throws IOException {
        int base = nextInt();

        for(int i=1;i<=300;i++){
            String num = convertToBase(i, base);
            String sqr = convertToBase(i * i, base);
            if(isPalindromic(sqr))
                out.println(num + " " + sqr);
        }
    }

    boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder(s);
        String rev = sb.reverse().toString();
        if(s.equals(rev))  return true;
        return false;
    }

    int convertToDecimal(String val, int base){
        int num = 0;
        int x =0;
        for(int i=val.length()-1;i>=0;i--){
            num += Math.pow(base,x++) + (val.charAt(i)-'0');
        }
        return num;
    }

    String convertToBase(int num, int base){
        String s = "";
        while (num>0){
            s = val[num%base] + s;
            num /= base;
        }
        return s;
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
        new palsquare().run();
    }
}
