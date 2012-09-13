package code;

import java.util.*;
public class ToolsBox {
	public int countTools(String[] need) {
        Set<String> set = new HashSet<String>();
        for(int i=0;i<need.length;i++){
            StringTokenizer st = new StringTokenizer(need[i]);
            while (st.hasMoreTokens())
                set.add(st.nextToken());
        }
        return set.size();
    }
}

