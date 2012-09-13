package usaco;

import java.util.*;
import java.io.*;

class namenum {

    void solve() throws IOException {
        String ss = nextToken();
        String s;
        boolean flag = false;
        while ((s = dict.readLine()) != null){
            String num = getNum(s);
            if(ss.equals(num)){
                flag = true;
                out.println(s);
            }
        }

        if(!flag) out.println("NONE");
    }

    int []val = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,0,7,7,8,8,8,9,9,9,0};
    String getNum(String s){
        String num = "";
        for(int i=0;i<s.length();i++)
            num = num + val[s.charAt(i) - 'A'];

        return num;
    }

    BufferedReader in, dict;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            dict = new BufferedReader(new FileReader("dict.txt"));
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
        new namenum().run();
    }
}
