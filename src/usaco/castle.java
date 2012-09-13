package usaco;

import java.util.*;
import java.io.*;

class castle {
    public void solve() throws IOException {
        int col = nextInt();
        int row = nextInt();

        int [][] c = new int[row][col];

        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                c[i][j] = nextInt();
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

        int []res = new int[gate];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                res[arr[i][j]]++;


        visited = new boolean [row][col];

        int val = 0;
        char direction = 'E';
        int wx = -1, wy = -1;

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
                                direction = 'E';
                            }
                            else if(wy == j && wx == i){
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
                                direction = 'N';
                            }
                            else if(wy == j && wx < i){
                                max = val1 + val2;
                                wx = i; wy = j;
                                direction = 'N';
                            }
                            else if(wy == j && wx == i){
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
        new castle().run();
    }
}
