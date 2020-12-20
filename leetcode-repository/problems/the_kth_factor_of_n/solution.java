class Solution {
   public int kthFactor(int n, int k){
		int count=1, i=1;
		if(k==1 || n==1){
			return 1;
	}
		while(i<=n/2 && count<k){
			i++;
			if(n%i==0){
				count++;
			} 
		}
		
		if(count == k)
			return i;
		else if(k-count ==1)
			return n;
		else
			return -1;
	}
		

}