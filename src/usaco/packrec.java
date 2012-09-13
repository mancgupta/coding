package usaco;

import java.util.*;
import java.io.*;

class packrec {
    class rectangle implements Comparable<rectangle>{
        int len, bre;
        int area;

        public rectangle(int area, int len,int bre){
            this.area = area;
            this.len = len;
            this.bre = bre;
        }

        public int compareTo(rectangle r){
            if(area == r.area)
                return len - r.len;
            return area - r.area;
        }

    }

    int length = 0;
    int breadth = 0;

    int area = Integer.MAX_VALUE;
    ArrayList<rectangle> list = new ArrayList<rectangle>();

    public void solve() throws IOException {
        int [][]rect = new int[4][2];

        for(int i=0;i<4;i++){
            int l = nextInt();
            int b = nextInt();

            if(l>b){
                int temp = l;
                l = b;
                b = temp;
            }

            rect[i][0] = l;
            rect[i][1] = b;
        }

        for(int i=0;i< (1<<4) ;i++){

            for(int j=0;j<4;j++){
                if((i & 1<<j) > 0)
                    swap(rect,j);
            }
            for(int m=0;m<4;m++){
                for(int n=0;n<4;n++){
                    if(n==m) continue;
                    for(int l=0;l<4;l++){
                        if(l==m || l==n) continue;

                        int t = 6 - m - n - l;

                        int [][]rec = new int[4][2];

                        rec[0][0] = rect[m][0];
                        rec[0][1] = rect[m][1];
                        rec[1][0] = rect[n][0];
                        rec[1][1] = rect[n][1];
                        rec[2][0] = rect[l][0];
                        rec[2][1] = rect[l][1];
                        rec[3][0] = rect[t][0];
                        rec[3][1] = rect[t][1];

                        for(int q=1;q<=6;q++){
                            layout(rec,q);
                            if(length*breadth < area){
                                if(length>breadth){
                                    int temp = length;
                                    length = breadth;
                                    breadth = temp;
                                }
                                list.add(new rectangle(length*breadth, length, breadth));
                            }
                        }
                    }
                }
            }
            for(int j=0;j<4;j++)
                if((i & 1<<j) > 0)
                    swap(rect,j);
        }


        Collections.sort(list);

        rectangle r = list.get(0);
        area = r.area;
        length = -1;
        breadth = -1;
        out.println(area);
        for(rectangle rr: list){
            if(rr.area > area) break;
            if(rr.len == length) continue;
            out.println(rr.len + " " + rr.bre);
            length = rr.len;
        }
    }

    void swap(int [][]rect, int j){
        int temp = rect[j][0];
        rect[j][0] = rect[j][1];
        rect[j][1] = temp;
    }

    void layout(int [][]rect,int type){

        length = 0;
        breadth = 0;
        switch (type){
            case 1:
                for(int i=0;i<4;i++){
                    length += rect[i][0];
                    breadth = Math.max(breadth, rect[i][1]);
                }

                break;
            case 2:
                for(int i=0;i<3;i++){
                    length += rect[i][0];
                    breadth = Math.max(breadth, rect[i][1]);
                }
                breadth += rect[3][0];
                length = Math.max(length, rect[3][1]);

                break;

            case 3:
                for(int i=0;i<2;i++){
                    length += rect[i][0];
                    breadth = Math.max(breadth, rect[i][1]);
                }
                breadth += rect[2][0];
                length = Math.max(length, rect[2][1]);

                breadth = Math.max(breadth, rect[3][1]);
                length += rect[3][0];

                break;

            case 4:
                length = rect[0][0] + Math.max(rect[1][0], rect[2][0]) + rect[3][0];
                breadth = Math.max(rect[0][1], rect[1][1] + rect[2][1]);

                breadth = Math.max(breadth , rect[3][1]);
                break;

            case 5:
                length = Math.max(rect[0][0], rect[1][0]) + rect[2][0] + rect[3][0];
                breadth = Math.max(rect[2][1], rect[0][1] + rect[1][1]);

                breadth = Math.max(breadth , rect[3][1]);
                break;

            case 6:

                int sw=rect[0][1]+rect[3][1];

                if (rect[0][0]<rect[3][0])
                    sw=Math.max(rect[0][1]+rect[3][1],rect[1][1]+rect[3][1]);
                if (rect[0][0]+rect[1][0]>rect[3][0])
                    sw=Math.max(sw,rect[1][1]+rect[2][1]);
                if (rect[0][0]>rect[3][0])
                    sw=Math.max(sw,rect[0][1]+rect[2][1]);
                sw=Math.max(Math.max(sw,rect[1][1]),rect[2][1]);

                int sl = Math.max(rect[0][0]+rect[1][0],rect[2][0]+rect[3][0]);

                length = sl;
                breadth = sw;
                break;
        }
    }

    BufferedReader in;
    StringTokenizer tokenizer;
    PrintWriter out;

    public void run() {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(System.out);
            //in = new BufferedReader(new FileReader("packrec.in"));
            //out = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));
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
        new packrec().run();
    }
}
