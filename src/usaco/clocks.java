package usaco;

import java.util.*;
import java.io.*;

class clocks {
    int minStep = Integer.MAX_VALUE;
    String res = "";

    public void solve() throws IOException {
        int []clock = new int[9];

        for(int i=0;i<9;i++)
            clock[i] = nextInt();


        getCases(0,"",clock);
//        String res = calculate("000110011",clock);

        //for(String s : list)
        //    out.println(s);
        for(int i=0;i<res.length();i++){
            out.print(res.charAt(i));
            if(i<res.length()-1)
                out.print(" ");
        }
        out.println();
    }

    ArrayList<String> list = new ArrayList<String>();
    void getCases(int len,String s, int []a){
        if(len == 9){

            int []x = new int[9];
            for(int i=0;i<9;i++)
                x[i] = a[i];
            s = calculate(s,x);
            if(s.equals("-1"))
                return;
            list.add(s);
            if(s.length() < minStep){
                res = s;
                minStep = s.length();
                //list.add(s);
            }
            else if(s.length() == minStep){
                if(s.compareTo(res) < 0)  {
                    res = s;
                    //list.add(s);
                }
            }
            return;
        }

        for(int i=0;i<4;i++)
            getCases(len + 1, s + i,a);
    }

    String calculate(String s,int []a){
        for(int i=0;i<s.length();i++){
            int val = s.charAt(i) - '0';
            for(int j=0;j<val;j++)
                Rotate(a,i+1);
        }

        for(int i=0;i<a.length;i++)
            if(a[i]!=12)
                return "-1";

        String ret = "";

        for(int i=0;i<s.length();i++){
            int val = s.charAt(i) - '0';
            for(int j=0;j<val;j++)
                ret += i+1;
        }
        return ret;
    }

    void Rotate(int []a,int type){
        switch (type){
            case 1:
                a[0] += 3; a[1] += 3; a[3] += 3; a[4] += 3;

                break;
            case 2:
                a[0] += 3; a[1] += 3; a[2] += 3;
                break;

            case 3:
                a[1] += 3; a[2] += 3; a[4] += 3; a[5] += 3;
                break;

            case 4:
                a[0] += 3; a[3] += 3; a[6] += 3;
                break;

            case 5:
                a[1] += 3; a[3] += 3; a[4] += 3; a[5] += 3; a[7] += 3;
                break;

            case 6:
                a[2] += 3; a[5] += 3; a[8] += 3;
                break;

            case 7:
                a[3] += 3; a[4] += 3; a[6] += 3; a[7] += 3;
                break;

            case 8:
                a[6] += 3; a[7] += 3; a[8] += 3;
                break;

            case 9:
                a[4] += 3; a[5] += 3; a[7] += 3; a[8] += 3;
                break;
        }

        for(int i=0;i<9;i++)
            if(a[i] > 12)
                a[i] %= 12;

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
        new clocks().run();
    }
}
