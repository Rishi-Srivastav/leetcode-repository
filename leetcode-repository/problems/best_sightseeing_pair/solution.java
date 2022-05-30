class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int last_max=values[0], n=values.length;
        int[] mat = new int[n];
        mat[0]=0;
        for(int i=1;i<n;i++){
           last_max--;
           last_max=Math.max(last_max, values[i-1]-1); 
           mat[i]= last_max+values[i];
          // System.out.println("mat--"+mat[i]); 
        }
        int max=mat[0];
        for(int i=1;i<n;i++){
            max=Math.max(max, mat[i]);
        }
        return max;
    }
}