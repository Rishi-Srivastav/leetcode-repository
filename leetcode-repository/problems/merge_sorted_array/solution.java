class Solution {
       public void merge(int[] sol, int m, int[] nums2, int n) {
        int[] nums1= Arrays.copyOfRange(sol, 0, m+n);
        int i=0,j=0, k=0;

        while(i<m && j<n){
            if(nums1[i]>nums2[j]){
                sol[k]=nums2[j];
                j++;
            } else {
                sol[k]=nums1[i];
                i++;
            }
            k++;
        }

        while (i<m){
            sol[k]=nums1[i];
            i++;
            k++;
        }

        while (j<n) {
            sol[k] = nums2[j];
            j++;
            k++;
        }
    }
}