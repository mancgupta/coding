package usaco;

import java.util.*;
import java.io.*;

class beads {
    void solve() throws IOException {
        int n = nextInt();
        String s = nextToken();
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        sb.append(s);

        s = sb.toString();
        int max = 0;
        for(int i=0;i<s.length();i++){

            boolean red = false, blue = false;
            int j = i;
            int cnt = 0;

            if(s.charAt(j) == 'w'){
                while (j<s.length() && s.charAt(j)=='w'){
                    j++;
                    cnt++;
                }
            }

            if(j<s.length() && s.charAt(j)=='r'){
                while (j<s.length() && (s.charAt(j)=='w' || s.charAt(j)=='r')){
                    j++;
                    cnt++;
                }
                while (j<s.length() && (s.charAt(j)=='b' || s.charAt(j)=='w')){
                    j++;
                    cnt++;
                }
            }

            else{
                while (j<s.length() && (s.charAt(j)=='b' || s.charAt(j)=='w')){
                    j++;
                    cnt++;
                }
                while (j<s.length() && (s.charAt(j)=='r' || s.charAt(j)=='w')){
                    j++;
                    cnt++;
                }
            }
            max = Math.max(cnt,max);
        }

        max = Math.min(max, s.length()/3);
        out.println(max);
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
        new beads().run();
    }
}
