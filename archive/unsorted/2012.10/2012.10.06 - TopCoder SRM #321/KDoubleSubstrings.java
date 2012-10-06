package code;

public class KDoubleSubstrings {
	public int howMuch(String[] str, int k) {
        String s = "";
        int ret=0;
        for(int i=0;i<str.length;i++)
            s += str[i];
        for(int i=0;i<s.length();i++)
            for(int j=i+1;j<s.length();j++){
                int len = j-i+1;
                if(len %2 == 0){
                    int cnt = 0;
                    for(int t=i;t<i+len/2;t++){
                        if(s.charAt(t) != s.charAt(t+len/2))
                            cnt++;
                    }
                    if(cnt <= k)
                        ret++;
                }
            }
        return ret;
	}

}
