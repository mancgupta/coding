package usaco;

import java.util.*;
import java.io.*;

class milk2 {
    class cow implements Comparable<cow>{
        int val;
        boolean flag;

        cow(int val,boolean flag){
            this.val = val;
            this.flag = flag;
        }

        @Override
        public int compareTo(cow o) {
            if(val==o.val){
                if(flag)
                    return -1;
                return 1;
            }
            return val - o.val;
        }
    }
    void solve() throws IOException {
        ArrayList<cow> list = new ArrayList<cow>();
        int n = nextInt();
        for(int i=0;i<n;i++){
            int a = nextInt();
            int b = nextInt();
            list.add(new cow(a,true));
            list.add(new cow(b,false));
        }

        cow []cows = list.toArray(new cow[0]);

        Arrays.sort(cows);

        int val = cows[0].val;
        int pmax = 0;
        int nmax = 0;
        int cnt = 1;
        for(int i=1;i<cows.length;i++){
            if(!cows[i].flag) cnt--;
            if(cows[i].flag){
                if(cnt==0){
                    nmax = Math.max(nmax, cows[i].val - val);
                    val = cows[i].val;
                }
                cnt++;
            }

            if(cnt==0){
                pmax = Math.max(pmax, cows[i].val - val);
                val = cows[i].val;
            }
        }

        out.println(pmax + " " + nmax);
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
        new milk2().run();
    }
}
