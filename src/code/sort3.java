package code;

import Helper.ArrayHelper;
import inout.InputReader;
import inout.OutputWriter;

public class sort3 {
	public void solve(int testNumber, InputReader in, OutputWriter out) {
		int n = in.nextInt();

		int []a = new int[n];
		int []cnt = new int[4];
		for(int i=0;i<n;i++){
			a[i] = in.nextInt();
			cnt[a[i]]++;
		}

		for(int i=1;i<cnt.length;i++)
			cnt[i] += cnt[i-1];

		int ans = 0;

		for(int i=n-1;i>=0;i--){

			if(!isAtRightPosition(cnt,a[i],i)){
				int preferredPos = -1;
				int alternatePos = -1;
				int max = a[i];
				for(int j=0;j<i;j++){
					if(a[j] > a[i]){
						if(isAtRightPosition(cnt,a[i],j) && isAtRightPosition(cnt,a[j],i)){
							preferredPos = j;
						}
						else if(a[j] >= max){
							max = a[j];
							alternatePos = j;
						}
					}
				}
				if(preferredPos != -1){
					ArrayHelper.swap(a,preferredPos,i);
					out.println("Swapping "+(preferredPos+1)+ " and "+ (i+1));
					ans++;
				}
				else if(alternatePos != -1){
					ArrayHelper.swap(a,alternatePos,i);
					out.println("Swapping "+(preferredPos+1)+ " and "+ (i+1));
					ans++;
				}
			}
		}

		out.println(ans);
	}

	private boolean isAtRightPosition(int[] cnt, int num, int pos) {
		if(pos < cnt[num] && pos >= cnt[num-1])
			return true;
		return false;
	}
}
