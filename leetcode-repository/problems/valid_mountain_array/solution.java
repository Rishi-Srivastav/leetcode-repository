class Solution {
    public boolean validMountainArray(int[] arr) {
     int l = arr.length;
        if(l<3)
            return false;
       
        int pivot = -1;
        
    for(int i=0;i<l-1;i++){
        if(arr[i]<arr[i+1]){
            continue;
        } else {
            if(arr[i]==arr[i+1])
                return false;
            pivot = i;
            break;
        }
    }
        if(pivot == -1 || pivot==0 || pivot == l-1)
            return false;
        for(int j=pivot; j<l-1;j++){
            if(arr[j]>arr[j+1]){
                continue;
            }
            return false;
        }
        return true;
    }
}