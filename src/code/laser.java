package code;

import inout.InputReader;
import java.io.PrintWriter;

public class laser {
    int min = Integer.MAX_VALUE;
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int col = in.nextInt();
        int row = in.nextInt();

        char [][]a = new char[row][col];
        for(int i=0;i<row;i++){
            a[i] = in.next().toCharArray();
        }
        boolean [][]visited = new boolean[row][col];
        boolean flag = false;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(a[i][j] == 'C'){
                    visited[i][j] = false;
                    a[i][j] = '.';
                    dfs(a,visited,"", i,j);
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }

        out.println(min);

	}


    void dfs(char [][]a,boolean [][]visited, String val, int row, int col){
        if(a[row][col] == 'C'){
            int x = check(val);
            min = Math.min(x, min);
            return;
        }

        if(isValid(row,col+1,a) && !visited[row ][col + 1] && a[row][col + 1]!='*'){
            visited[row][col+1] = true;
            dfs(a,visited,val + 'U', row, col + 1);
            visited[row][col+1] = false;
        }
        if(isValid(row,col-1,a) && !visited[row ][col - 1] && a[row][col - 1]!='*'){
            visited[row][col-1] = true;
            dfs(a,visited,val + 'D', row, col - 1);
            visited[row][col-1] = false;
        }
        if(isValid(row+1,col,a) && !visited[row + 1][col] && a[row + 1][col]!='*'){
            visited[row + 1][col] = true;
            dfs(a,visited,val + 'R', row + 1, col);
            visited[row + 1][col] = false;
        }
        if(isValid(row-1,col,a) && !visited[row - 1][col] && a[row - 1][col]!='*'){
            visited[row - 1][col] = true;
            dfs(a,visited,val + 'L', row - 1, col);
            visited[row - 1][col]  = false;
        }
    }

    boolean isValid(int row, int col, char [][]a){
        if(row <0 || row >= a.length) return false;
        if(col <0 || col >=a[0].length) return false;
        return true;
    }

    int check(String s){
        char ch = s.charAt(0);
        int cnt = 0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)!=ch){
                cnt++;
                ch = s.charAt(i);
            }
        }
        return cnt;
    }
}
