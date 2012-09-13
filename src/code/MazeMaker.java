package code;

import Helper.ArrayHelper;

import java.util.*;

public class MazeMaker {
    char [][]a;
    int [][]x;

    class point {
        int x,y;

        point(int x,int y){
            this.x = x;
            this.y = y;
        }
    }
	public int longestPath(String[] maze, int startRow, int startCol, int[] moveRow, int[] moveCol) {
	    a = ArrayHelper.toCharArray(maze);
        x = new int[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                x[i][j] = Integer.MAX_VALUE;
        bfs(startRow,startCol,moveRow,moveCol);

        int ret = -1;
        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++)
                if(a[i][j]!='X' && !(i==startRow && j==startCol))
                    ret = Math.max(ret, x[i][j]);

        if(ret == Integer.MAX_VALUE)
            ret = -1;
        return ret;
	}

    private void bfs(int startRow, int startCol, int[] moveRow, int[] moveCol) {
        ArrayList<point> queue = new ArrayList<point>();
        queue.add(new point(startRow,startCol));
        boolean [][]visited = new boolean[a.length][a[0].length];

        x[startRow][startCol] = 0;
        while (!queue.isEmpty()){
            point p = queue.remove(0);
            visited[p.x][p.y] = true;

            for(int i=0;i<moveRow.length;i++){
                point pt = new point(p.x + moveRow[i], p.y + moveCol[i]);
                if(isValid(pt) && !visited[pt.x][pt.y] && a[pt.x][pt.y]=='.'){
                    queue.add(pt);
                    x[pt.x][pt.y] = Math.min(x[pt.x][pt.y], x[p.x][p.y]+1) ;
                    visited[pt.x][pt.y] = true;
                }
            }
        }
    }

    boolean isValid(point p){
        if(p.x >=0 && p.x < a.length && p.y>=0 && p.y<a[0].length)
            return true;
        return false;
    }

}

