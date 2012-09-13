package usaco;

import java.util.*;
import java.io.*;

class gift1 {
    void solve() throws IOException {
        HashMap<String , Integer> map = new HashMap<String, Integer>();

        int n = nextInt();
        String [] ss = new String [n];
        for(int i=0;i<n;i++){
            ss[i] = nextToken();
            map.put(ss[i],0);
        }

        for(int i=0;i<n;i++){
            String s = nextToken();
            int a = nextInt();
            int b = nextInt();

            if(b!=0) {
                int amt = a/b;
                map.put(s,map.get(s) - amt*b);

                for(int j=0;j<b;j++){
                    String t = nextToken();
                    map.put(t,map.get(t) + amt);
                }
            }
        }


        for(int i=0;i<n;i++)
            out.println(ss[i]+" "+map.get(ss[i]));
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("gift1.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
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
        new gift1().run();
    }
}
