package usaco;

import java.util.*;
import java.io.*;

class calfflac {

    String str = "";
    int max = 0;
    void solve() throws IOException {

        /*String s = "";
        StringBuilder sb = new StringBuilder();

        while ((s = in.readLine()) != null) {
            sb.append(s);
            sb.append("\n");
        }
        s = sb.toString(); */
        String s = in.readLine();

        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i))){
                palindrome(s,i,i);
                palindrome(s,i,i+1);

            }
        }

        out.println(max);
        out.println(str);
    }

    void palindrome(String s, int x,int y){
        int diff = 0;
        if(x == y) diff = -1;
        int len = 0;
        while (x>=0 && y<s.length()){
            int q = x;
            int w = y;
            while (x>=0 && !Character.isLetter(s.charAt(x))) x--;
            while (y<s.length() && !Character.isLetter(s.charAt(y))) y++;

            if(x<0 || y>=s.length() || Character.toLowerCase(s.charAt(x))!=Character.toLowerCase(s.charAt(y))){
                if(len + diff > max){
                    max = len + diff;
                    str = s.substring(q+1,w);
                }
                return;
            }
            len+=2;
            x--;
            y++;
        }

        if(len+diff > max){
            max = len + diff;
            str = s.substring(x+1,y);
        }
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("calfflac.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
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
        new calfflac().run();
    }
}
