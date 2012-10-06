package code;

public class Substitute {
	public int getValue(String key, String code) {
        int ret = 0;
        for(int i=0;i<code.length();i++){
            int val = key.indexOf(code.charAt(i));
            val++;
            if(val > 0){
                val %=10;
                ret = 10*ret + val;
            }
        }
        return ret;
	}
}
