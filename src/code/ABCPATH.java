package code;

import inout.InputReader;
import java.io.PrintWriter;

public class ABCPATH {

    boolean [][]visited;
    int max = 0;

    int x,y;
	public void solve(int testNumber, InputReader in, PrintWriter out) {
        int row = in.nextInt();
        int col = in.nextInt();

        int cnt =1 ;
        while (! (row==0 && col == 0)){
            x = row;
            y = col;
            char [][]a = new char[row][col];
            visited = new boolean[row][col];
            for(int i=0;i<row;i++)
                a[i] = in.next().toCharArray();

            for(int i=0;i<row;i++)
                for(int j=0;j<col;j++){
                    if(a[i][j] == 'A') {
                        visited[i][j] = true;
                        dfs(a,i,j,1);
                    }
                }
            out.println("Case "+ cnt +": "+ max);
            row = in.nextInt();
            col = in.nextInt();
            cnt++;
            max = 0;
        }
	}

    void dfs(char [][]a, int row,int col, int len){
        for(int i=-1;i<=1;i++)
            for(int j=-1;j<=1;j++){
                if(i==0 && j==0) continue;
                if(isValid(row+i,col+j) && !visited[row+i][col+j] && a[row+i][col+j] == a[row][col]+1){
                            visited[row+i][col+j] = true;
                            dfs(a,row+i,col+j,len+1);
                }
            }
        max = Math.max(len, max);
    }

    boolean isValid(int row,int col){
        if(row<0 || row>=x) return false;
        if(col<0 || col>=y) return false;
        return true;
    }
}
