package usaco;

import java.util.*;
import java.io.*;

class milk3 {
    class state implements Comparable<state>{
        int []a = new int[3];

        public state(int a,int b,int c){
            this.a[0] = a; this.a[1] = b; this.a[2] = c;
        }

        public int compareTo(state s){
            for(int i=0;i<a.length;i++){
                if(a[i]!= s.a[i])
                    return a[i] - s.a[i];
            }
            return 0;
        }
    }

    HashMap<String,Boolean> map = new HashMap<String, Boolean>();
    Set<Integer> set = new TreeSet<Integer>();

    public void solve() throws IOException {
        int a = nextInt();
        int b = nextInt();
        int c = nextInt();

        find(0,0,c,2,0,new int[]{a,b,c});
        find(0,0,c,2,1,new int[]{a,b,c});

        int cnt = 0;
        for(Integer i : set) {
            out.print(i);
            cnt++;
            if(cnt<set.size())
                out.print(" ");
        }
        out.println();
    }

    void find(int x,int y, int z, int from, int to, int []capacity){
        int []a = {x,y,z};

        if(a[0] == 0)
            set.add(a[2]);
        if(a[from] == 0) return;
        int empty = capacity[to] - a[to];
        int avail = a[from];

        if(empty > avail){
            a[from] = 0;
            a[to] += avail;
        }
        else{
            a[from] = avail - empty;
            a[to] = capacity[to];
        }

        if( map.containsKey(a[0] + " " + a[1] + " " + a[2]))
            return;
        map.put(a[0] + " " + a[1] + " " + a[2],true);
        find(a[0],a[1],a[2],0,1,capacity);
        find(a[0],a[1],a[2],0,2,capacity);
        find(a[0],a[1],a[2],1,0,capacity);
        find(a[0],a[1],a[2],1,2,capacity);
        find(a[0],a[1],a[2],2,0,capacity);
        find(a[0],a[1],a[2],2,1,capacity);

    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("milk3.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
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
        new milk3().run();
    }
}
