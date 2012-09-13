package usaco;

import java.util.*;
import java.io.*;

class friday {
    int []days = {31,28,31,30,31,30,31,31,30,31,30,31};
    void solve() throws IOException {
        int N = nextInt();
        int day = 1;

        int []week = new int[7];
        for(int i=1900;i<=1900+N-1;i++){
            if(isLeap(i))
                days[1] = 29;
            else
                days[1] = 28;
            for(int j=0;j<days.length;j++){
                day += 13;
                day %= 7;
                week[day]++;
                day += days[j] - 13;
            }
        }

        for(int i=0;i<week.length;i++) {
            out.print(week[i]);
            if(i<week.length-1)
                out.print(" ");
        }
        out.println();
    }

    boolean isLeap(int year){
        return (year%400 == 0) || ((year%4 == 0) && (year%100 != 0));
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("friday.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
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
        new friday().run();
    }
}
