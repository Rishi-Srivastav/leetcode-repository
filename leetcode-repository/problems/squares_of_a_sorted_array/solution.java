class Solution {
    public int[] sortedSquares(int[] nums) {
      	int p = getPivot(nums);
		getReverse(nums, 0, p-1);
		return mergeSortedArrays(nums, 0, p, nums.length);
    }


	private static int getPivot(int[] num){
		int pivot=0;
		for(int i=0;i<num.length;i++){
			if(num[i]<0){
				pivot++;
			} else {
				break;
			}
		}
		return pivot;
	}

	private static int[] getReverse(int[] num, int start, int end){
		while(start<end){
			int tmp = num[start];
			num[start]= num[end];
			num[end] = tmp;
			start ++;
			end--;
		}
		return num;
	}

	private static int[] mergeSortedArrays(int[] num, int s1, int p, int e2){
		int r[]=new int[num.length];
		int k=0, l1=s1, r1=p-1, l2=p, r2=e2;
		for(int i=0;i<num.length;i++){
			num[i] = num[i]*num[i];
		}
		
		if(p==e2)
			return num;
		while(l1<=r1 && l2<r2){
			if(num[l1]<=num[l2]){
				r[k]=num[l1];
				l1++;
				k++;
			}
			if(num[l1]>num[l2]){
				r[k]=num[l2];
				l2++;
				k++;
			}
		}

		while(l1<=r1){
			r[k]= num[l1];
			l1++;
			k++;
		}

		while(l2<r2){
			r[k]= num[l2];
			l2++;
			k++;
		}
		return r;
	}

}