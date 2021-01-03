class Solution {
   public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        gen(nums, nums.length, lists);
        return lists;
    }

    public  static void gen(int[] input, int k, List<List<Integer>> lists){
        if(k==1){
            List<Integer> out = new ArrayList();
            for(int i=0;i<input.length;i++){
                out.add(input[i]);
            }
            lists.add(out);
            return;
        }

        // Generate permutations with kth unaltered
        // Initially k == length(A)
        gen(input, k-1, lists);

        // Generate permutations for kth swapped with each k-1 initial
        for(int i=0;i<k-1;i++){
            if(k%2==0)
                swap(input, i, k-1);
            else
                swap(input, 0, k-1);

            gen(input, k-1, lists);
        }
    }

    public static void swap(int[] input, int i, int j){
        int tmp = input[i];
        input[i]= input[j];
        input[j]=tmp;
    }
}