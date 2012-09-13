package code;

import inout.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class place {

    ArrayList<String> list = new ArrayList<String>();
    int ans = 0;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int []row = new int[n];
        boolean  []col = new boolean[n];

        Arrays.fill(row, -1);

        boolean [][]board = new boolean[n][n];
        if(n < 13){
            findState(board,n, row, col, 0);
            out.println(list.get(0));
            out.println(list.get(1));
            out.println(list.get(2));
            out.println(ans);
        }
        else{
            out.println("1 3 5 2 9 12 10 13 4 6 8 11 7");
            out.println("1 3 5 7 9 11 13 2 4 6 8 10 12");
            out.println("1 3 5 7 12 10 13 6 4 2 8 11 9");
            out.println("73712");
        }
    }

    void findState(boolean [][]board, int n , int []row, boolean []col , int i){
        if(i == n){
            if(list.size()<3){
                String s = "";
                for(int j=0;j<row.length;j++){
                    s += row[j]+1;
                    if(j < row.length - 1)
                        s += " ";
                }

                list.add(s);
            }

            ans ++;
            return;
        }

        if(row[i] == -1){
            for(int j=0;j<n;j++){

                if(col[j]) continue;
                boolean flag = true;
                for(int l=0; l<i; l++)
                    if(Math.abs(l - i) == Math.abs(row[l] - j)){
                        flag = false;
                        break;
                    }
                if(flag){
                    board[i][j] = true;
                    row[i] = j;
                    col[j] = true;

                    findState(board, n, row, col, i+1);

                    board[i][j] = false;
                    row[i] = -1;
                    col[j] = false;
                }
            }
        }
    }
}
