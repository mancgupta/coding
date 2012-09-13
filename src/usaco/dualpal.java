package usaco;

import java.util.*;
import java.io.*;

class dualpal {

    void solve() throws IOException {
        int cnt = nextInt();
        int n = nextInt();
        int temp = 0;
        for(int i=n+1;temp<cnt;i++){
            int val = 0;
            for(int j=2;j<=10;j++) {
                String s = convertToBase(i,j);
                if(isPalindromic(s))
                    val++;
                if(val==2)
                    break;
            }
            if(val==2){
                out.println(i);
                temp++;
            }
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
            s = num%base + s;
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
        new dualpal().run();
    }
}
