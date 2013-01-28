package code;

import inout.InputReader;
import inout.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class BalancedSmileys {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    String s = in.nextLine();

	    String res = "YES";
	    Set<Integer> set = new HashSet<Integer>();
		set.add(0);
	    for(int i=0;i<s.length();i++){
		    Set<Integer> temp = new HashSet<Integer>();
		    if( s.charAt(i) == '(' ){
			    for( Integer item : set ){
					temp.add(item+1);
			    }
			    set.clear();
			    set.addAll(temp);
		    }
		    else if( s.charAt(i) == ')'){
			    for( Integer item : set ){
				    temp.add(item-1);
			    }
			    set.clear();
			    set.addAll(temp);
		    }
		    else if( s.charAt(i) == ':'){
			    if( i == s.length()-1) continue;

			    if( s.charAt(i+1) == '('){
				    for( Integer item : set ){
					    temp.add(item+1);
				    }
				    set.addAll(temp);
				    i++;
			    }
			    else if (s.charAt(i+1) ==')'){
				    for( Integer item : set ){
					    temp.add(item-1);
				    }
				    set.addAll(temp);
				    i++;
			    }
		    }

		    boolean flag = false;
		    for( Integer item : set ){
			    if( item >= 0 ) {
				    flag = true;
				    break;
			    }
		    }

		    if( !flag )
			    res = "NO";
	    }

	    boolean flag = false;
	    for( Integer item : set ){
		    if( item == 0)  {
			    flag = true;
		    }
	    }

	    if( !flag ){
		    res = "NO";
	    }
	    out.println("Case #"+ testNumber + ": " + res);
    }
}
