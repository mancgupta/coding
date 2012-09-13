package usaco;

import java.util.*;
import java.io.*;

class ariprog {
    class sequence implements Comparable<sequence>{
        int a,d;

        public sequence(int a,int d){
            this.a = a;
            this.d = d;
        }

        @Override
        public int compareTo(sequence o) {
            if(d == o.d){
                return a - o.a;
            }
            return d - o.d;
        }
    }

    Set<Integer> set = new TreeSet<Integer>();
    ArrayList<sequence> list = new ArrayList<sequence>();
    public void solve() throws IOException {
        int n = nextInt();
        int m = nextInt();

        for(int i=0;i<=m;i++)
            for(int j=0;j<=m;j++)
                set.add(i*i + j*j);

        Integer []a = set.toArray(new Integer[0]);
        boolean []hash = new boolean[a[a.length-1] + 1];

        for(int i=0;i<a.length;i++)
            hash[a[i]] = true;

        for(int i=0;i<a.length-n;i++){
            for(int j=i+1;j<a.length;j++){
                int d = a[j] - a[i];
                int val = a[j];
                boolean flag = true;
                for(int k=0;k<n-2;k++) {
                    val += d;
                    if(val > a[a.length-1] || !hash[val])  {
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    list.add(new sequence(a[i], d));
                }
            }
        }

        if(list.size() ==0 )
            out.println("NONE");
        else {
            Collections.sort(list);
            for(sequence s: list){
                out.println(s.a + " " + s.d);
            }
        }

    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("ariprog.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
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
        new ariprog().run();
    }
}
