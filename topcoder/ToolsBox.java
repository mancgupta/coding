import java.util.Set;
import java.util.StringTokenizer;
import java.util.HashSet;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
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

