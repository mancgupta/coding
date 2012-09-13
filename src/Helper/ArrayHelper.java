package Helper;

public class ArrayHelper {
    public static boolean [][]toBooleanArray(String []a){
        int r = a.length;
        int c = a[0].length();

        boolean [][]ret = new boolean[r][c];
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
                ret[i][j] = a[i].charAt(j)=='Y' || a[i].charAt(j)=='y' ? true : false;

        return ret;
    }

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
