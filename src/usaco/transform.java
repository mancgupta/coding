package usaco;

import java.util.*;
import java.io.*;

class transform {
    char [][]a;
    int n;
    char [][] target;

    int min = Integer.MAX_VALUE;

    void solve() throws IOException {
        n = nextInt();

        a = new char[n][n];
        for(int i=0;i<n;i++){
            String s = nextToken();
            a[i] = s.toCharArray();
        }

        target = new char[n][n];
        for(int i=0;i<n;i++){
            String s = nextToken();
            target[i] = s.toCharArray();
        }

        //dfs(a, 0, "", 10);
        long now = System.currentTimeMillis();
        a = Rotate90(a);
        if(isFinal(a)){
            out.println(1);
            return;
        }

        a = Rotate90(a);
        if(isFinal(a)){
            out.println(2);
            return;
        }

        a = Rotate90(a);
        if(isFinal(a)){
            out.println(3);
            return;
        }

        a = Rotate90(a);
        a = Reflection(a);

        if(isFinal(a)){
            out.println(4);
            return;
        }

        a = Rotate90(a);
        if(isFinal(a)){
            out.println(5);
            return;
        }

        a = Rotate90(a);
        if(isFinal(a)){
            out.println(5);
            return;
        }

        a = Rotate90(a);
        a = Rotate90(a);
        a = Reflection(a);
        if(isFinal(a)) {
            out.println(6);
            return;
        }


        out.println(7);
        return;
    }

    void dfs(char [][]temp, int cnt , String ans, int end){
        if(isFinal(temp)){
            int res = findMin(ans);
            min = Math.min(res, min);
            return;
        }
        if(cnt >= end) return;

        char [][] x = new char[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                x[i][j] = temp[i][j];

        x = Rotate90(x);
        dfs(x,cnt+1,ans+"R",end);

        temp = Reflection(temp);
        dfs(temp,cnt+1, ans+"r" , end);
    }

    private int findMin(String ans) {
        int cntR = 0;
        int cntr = 0;

        int res = 0;
        for(int i=0;i<ans.length();i++){
            if(ans.charAt(i)=='R')
                cntR++;
            else
                cntr++;
        }

        while (cntR>=2 && cntr>0){
            res++;
            cntr--;
            cntR -= 2;
        }

        res += cntr;

        res += cntR/3;
        cntR %= 3;

        res += cntR/2;
        cntR %= 2;

        res += cntR;

        return res;
    }

    boolean isFinal(char [][]a){
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(a[i][j] != target[i][j])
                    return false;
        return true;
    }

    char [][] Reflection(char [][]a) {
        for(int i=0;i<n;i++)
            for(int j=0;j<n/2;j++){
                char temp = a[i][j];
                a[i][j] = a[i][n - j - 1];
                a[i][n - j - 1] = temp;
            }
        return a;
    }

    char [][] Rotate90(char [][]a){
        char [][] temp = new char[n][n];

        for(int i=0;i<n;i++)
            for(int j=n-1;j>=0;j--)
                temp[i][n - j - 1] = a[j][i];

        return temp;
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("transform.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
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
        new transform().run();
    }
}
