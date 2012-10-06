package code;

import inout.InputReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class frac1 {
    class fractions implements Comparable<fractions>{
        double value;
        String item;

        public fractions(double value, String item){
            this.value = value;
            this.item = item;
        }

        public fractions(){}
        public int compareTo(fractions f){
            double diff = value - f.value;
            if(diff > 1e-8) return 1;
            if(diff < -1e-8) return -1;
            return 0;
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        for(int i=0;i<arr.length;i++)
            arr[i] = new fractions(Double.MAX_VALUE,"");
        dfs(n,1,n,0);
//        Collections.sort(list);
        Arrays.sort(arr);
        out.println("0/1");
        for(int i=0;i<limit;i++)
            out.println(arr[i].item);
        out.println("1/1");
    }

//    ArrayList<fractions> list = new ArrayList<fractions>();

    fractions [] arr = new fractions[20000];
    int limit = 0;
    void dfs(int n , int num, int deno, int i){
        if(deno == 0 || num>deno){
            return;
        }
        if(num == deno){
            dfs(n,1,deno-1,i+1);
            return;
        }

        if(!(num!=1 && deno%num == 0))
        {
            boolean flag = true;
            for(int t=2;t<=num;t++){
                if( num % t == 0 && deno % t == 0 ) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                double value = (num*1.0)/deno;
                String item = num + "/" + deno;
                fractions frac = new fractions(value, item);
                limit++;
                arr[i] = frac;
            }
        }
        dfs(n,num+1,deno,i+1);
    }
}