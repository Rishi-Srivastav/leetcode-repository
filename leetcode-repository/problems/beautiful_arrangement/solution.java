class Solution {
    
    static int count = 0;
   
    public int countArrangement(int n) {
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            a[i] = i+1;
        }
        
        permutationGen2(a, 0);
        int res = count;
        count=0;
        return res;
    }
    
     public static void permutationGen2(int[] input, int start) {
        if (start == input.length) {
           count++;
        }

        for (int i = start; i < input.length; i++) {
            swap(input, i, start);
            if(input[start]%(start+1) ==0 || (start+1)%input[start] == 0){
                permutationGen2(input, start+1);
            }
            swap(input, i, start);
        }
    }

    public static void swap(int[] input, int i, int j) {
        int tmp = input[i];
        input[i] = input[j];
        input[j] = tmp;
    } 
}