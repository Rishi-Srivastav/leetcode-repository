class Solution {
     public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0, j=0,k=0;
        while(k<m && j<n){
            if(nums1[i]>=nums2[j]){
                insert(nums2[j++], i++, nums1);
            } else {
                i++;
                k++;
            }
        }
        while(i<m+n && j<n){
            nums1[i++]= nums2[j++];
        }
    }

    public static void insert(int val, int index, int[] a){
        for(int i=a.length-1;i>index;i--){
            a[i]=a[i-1];
        }
        a[index]=val;
    }
}