
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class TheBasketballDivTwo {

    int min = Integer.MAX_VALUE;

    public int find(String[] table) {
        char [][]a = ArrayHelper.toCharArray(table);
        dfs(a,0,0);
        return min;
	}

    void dfs(char [][]a, int x, int y){
        if(x == a.length){
            int max = 0;
            for(int i=0;i<a.length;i++){
                int cnt = 0;
                for(int j=0;j<a.length;j++){
                    if(a[i][j]=='W') cnt++;
                    if(a[j][i]=='L') cnt++;
                }

                max = Math.max(cnt, max);
            }
            min = Math.min(min, max);
            return;
        }
        if(y == a.length){
            dfs(a,x+1,0);
            return;
        }
        if(x==y) dfs(a,x,y+1);
        else if(x == a.length){
            int max = 0;
            for(int i=0;i<a.length;i++){
                int cnt = 0;
                for(int j=0;j<a.length;j++){
                    if(a[i][j]=='W') cnt++;
                    if(a[j][i]=='L') cnt++;
                }

                max = Math.max(cnt, max);
            }
            min = Math.min(min, max);
        }
        else {
            if(a[x][y]=='?'){
                a[x][y] = 'W';
                dfs(a,x,y+1);
                a[x][y] = 'L';
                dfs(a,x,y+1);
                a[x][y] = '?';
            }
            else
                dfs(a,x,y+1);
        }
    }
}

class ArrayHelper {

    public static char [][] toCharArray(String []a){
        int r = a.length;
        int c = a[0].length();

        char  [][]ret = new char[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                ret[i][j] = a[i].charAt(j);
        return ret;
    }
}

