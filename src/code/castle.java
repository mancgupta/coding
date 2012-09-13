package code;

import inout.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class castle {

	public void solve(int testNumber, InputReader in, PrintWriter out) {
		int col = in.nextInt();
		int row = in.nextInt();
		
		int [][] c = new int[row][col];
		
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				c[i][j] = in.nextInt();
			}
		}
		
		String [][] csl = new String[row][col];

		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++){
				int x = c[i][j];
				String s = "";
                boolean east = false, west = false, north = false, south = false;

				if(x>=8){ south = true; x-=8; }
				if(x>=4){ east = true; x-=4; }
				if(x>=2){ north = true; x-=2; }
				if(x>=1){ west = true; x-=1; }

                if(!south) s += 'S';
                if(!west) s += 'W';
                if(!east) s += 'E';
                if(!north) s += 'N';
                csl[i][j] = s;
			}

		boolean [][] visited = new boolean [row][col];
		
		int [][] arr = new int[row][col];
		int gate = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<row;i++){
			for(int j=0;j<col;j++) {
				if(!visited[i][j]){
                    int val = dfs(csl,arr, visited, gate, 1, i, j);
					gate++;
				}
			}
		}

//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++)
//                out.print(csl[i][j] + " ");
//            out.println();
//        }
//
//        out.println();
//
//        for(int i=0;i<row;i++){
//            for(int j=0;j<col;j++)
//                out.print(arr[i][j] + " ");
//            out.println();
//        }

        int []res = new int[gate];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                res[arr[i][j]]++;


        visited = new boolean [row][col];

//        for(int i=0;i<res.length;i++)
//            out.print(res[i] + " ");
//        out.println();
        int val = 0;
        char direction = 'E';
        int wx = -1, wy = -1;

//        out.println(row + " " + col);

        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++){
                if(j<col-1){
                    if(arr[i][j] != arr[i][j+1]){
                        int val1 = res[arr[i][j]];
                        int val2 = res[arr[i][j+1]];

                        if(val1+val2 > max){
                            max = val1 + val2;
                            wx = i;
                            wy = j;
                            direction = 'E';
                        }
                        else if(val1 + val2 == max){
                            if(wy > j){
                                max = val1+val2;
                                wx = i;
                                wy = j;
                                direction = 'E';
                            }
                            else if(wy == j && wx < i){
                                max = val1 + val2;
                                wx = i; wy = j;
                                direction = 'N';
                            }
                        }
                    }
                }
                if(i>0){
                    if(arr[i][j] != arr[i-1][j]){
                        int val1 = res[arr[i][j]];
                        int val2 = res[arr[i-1][j]];

                        if(val1+val2 > max){
                            max = val1 + val2;
                            wx = i;
                            wy = j;
                            direction = 'N';
                        }
                        else if(val1 + val2 == max){
                            if(wy > j){
                                max = val1+val2;
                                wx = i;
                                wy = j;
                                direction = 'E';
                            }
                            else if(wy == j && wx < i){
                                max = val1 + val2;
                                wx = i; wy = j;
                                direction = 'N';
                            }
                        }
                    }
                }
            }

        int maxRoom = 0;
        for(int i=0;i<res.length;i++)
            maxRoom = Math.max(maxRoom, res[i]);

        wx++; wy++;
        out.println(gate-1);
        out.println(maxRoom);
        out.println(max);
        out.println(wx + " " + wy + " " + direction);
    }

    int max = 0;

    boolean isSafe(int r, int c, int row, int col){
        if(r<0 || r>=row)  return false;
        if(c<0 || c>=col)  return false;
        return true;
    }
	int dfs(String [][]csl , int [][]arr, boolean [][]visited, int gate , int rooms, int row, int col){
		if(visited[row][col])
			return rooms;
		
		arr[row][col] = gate;
		visited[row][col] = true;
		
		int r = 0, c = 0;
		String s = csl[row][col];

		int ret = rooms;
        boolean []dir = new boolean[4];
		for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'W') { r =  0; c = -1; }
            if(s.charAt(i) == 'E') { r =  0; c =  1; }
            if(s.charAt(i) == 'S') { r = 1; c =  0; }
            if(s.charAt(i) == 'N') { r =  -1; c =  0; }

            if(row+r < 0 || row+r >= arr.length) continue;
            if(col+c < 0 || col+c >= arr[0].length) continue;

            ret = Math.max(ret, dfs(csl, arr, visited, gate, rooms + 1, row+r, col + c));
        }
		return ret;
	}
}
