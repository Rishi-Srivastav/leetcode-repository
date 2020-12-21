class Solution {
    public boolean canPlaceFlowers(int[] a, int n) {
        int l = a.length;
        int last=-1;
        int count=0;
        // [1, 0, 1, 0, 0]
        if(l==1 && a[0]==0)
            return true;
        
        for(int i=0;i<l;i++){
            if(a[i]==1){
                last=i;
                continue;
            }
            if(a[i]!=1 && (last<0 || last<i-1)){
                if(i<l-1 && a[i+1]!=1){
                    count++;
                    last=i;
                }
                if(i==l-1){
                    count++;
                    
                }
            }
        } 
        
        if(count>=n)
            return true;
        return false;
    }
}