class Solution {
    public int maxArea(int[] height) {
        int l=0, r=height.length-1;
        int area= Math.min(height[l],height[r])*(r-l);
        
        while(l<r){
            area=Math.max(area, Math.min(height[l], height[r])*(r-l));
            if(height[l]>height[r])
                r--;
            else
                l++;
        }
        return area;
}
}