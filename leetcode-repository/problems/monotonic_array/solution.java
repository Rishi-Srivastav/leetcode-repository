class Solution {
    public boolean isMonotonic(int[] nums) {
        String s=null;
        for(int i=0;i<nums.length-1;i++){
            int d=nums[i]-nums[i+1];
            if(d==0){
                continue;
            } else {
                if(s==null){
                    s=d>0?"I":"D";
                } else{
                    if((s.equals("I") && d<0) || (s.equals("D") && d>0))
                        return false;
                }
            }
        }
        return true;
    }
}