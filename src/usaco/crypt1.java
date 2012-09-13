package usaco;

import java.util.*;
import java.io.*;

class crypt1 {
    int ans = 0;
    public void solve() throws IOException {
        int n = nextInt();
        int []a = new int[n];

        for(int i=0;i<n;i++)
            a[i] = nextInt();

        Arrays.sort(a);
        findNumber(0, a, 0);

        out.println(ans);
    }

    void findNumber(int number, int []a, int x){
        if(x==5){
            if(calculate(a, number))
                ans++;
            return;
        }

        for(int i=0;i<a.length;i++)
            findNumber(number*10 + a[i],a,x+1);
    }

    boolean calculate(int []arr, int number){
        int a = number/100;
        int b = number%100;

        int b1 = b%10;
        int b2 = b/10;

        int z1 = b1 * a;
        int z2 = b2 * a;

        int sum = z1 + z2*10;
        if(!(z1/100!=0 && z1/1000 ==0)) return false;
        if(!(z2/100!=0 && z2/1000 ==0)) return false;
        if(!(sum/1000!=0 && sum/10000 == 0)) return false;
        return check(arr,number) && check(arr,z1) && check(arr,z2) && check(arr,sum);
    }


    boolean check(int []arr , int number){

        while (number>0){
            int x = number % 10;

            if(Arrays.binarySearch(arr,x) < 0)
                return false;
            number /=10;
        }
        return true;
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            //in = new BufferedReader(new InputStreamReader(System.in));
            //out = new PrintWriter(System.out);
            in = new BufferedReader(new FileReader("crypt1.in"));
            out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
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
        new crypt1().run();
    }
}
