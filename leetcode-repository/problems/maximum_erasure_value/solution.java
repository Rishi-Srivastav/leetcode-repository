class Solution {

	public static int maximumUniqueSubarray(int[] nums) {
		int score = nums[0], max=nums[0], start=0;
		Set<Integer> set = new HashSet();
		set.add(nums[0]);
		int i=0,j=1;
		int l = nums.length;
		while(i<l-1 && j<l){
			if(!set.contains(nums[j])){
				score += nums[j];
				set.add(nums[j++]);
				if(max<score)
					max=score;
			} else {
					score -=nums[i];
					set.remove(nums[i++]);
				}
			}
	return max;
} 
}