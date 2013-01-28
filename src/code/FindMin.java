package code;

import inout.InputReader;
import inout.OutputWriter;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class FindMin {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
	    int n = in.nextInt();
	    int k = in.nextInt();

	    long a = in.nextLong();
	    long b = in.nextLong();
	    long c = in.nextLong();
	    long r = in.nextLong();

	    ArrayList<Long> list= new ArrayList<Long>();
	    list.add(a);

	    PriorityQueue<Long> queue = new PriorityQueue<Long>();
	    queue.add(a);

	    Long prev = a;
	    for( int i=1;i < k; i++ )
	    {
		    prev = (b* prev + c) % r;
		    list.add(prev);
		    queue.add(prev);
	    }

    }
}
