class Solution {
    public boolean makesquare(int[] matchsticks) {
        int n=matchsticks.length;
        int sum=Arrays.stream(matchsticks).sum();
        if(sum%4!=0) return false;
        int target=sum/4;
        int[] visited=new int[n];
        return findSumSubset(matchsticks, visited, 4, 0, target, 0);
    
    }
    
    public boolean findSumSubset(int[] a, int[] visited, int k, int sum, int target, int start){
        if(k ==1) return true;
        
        if(target==sum) 
            return findSumSubset(a, visited, k-1, 0, target,0);
        
       for(int i=start;i<a.length;i++){
           if(visited[i]==0){
               visited[i]=1;
               if(findSumSubset(a,visited,k,sum+a[i], target, i+1)) return true;
               visited[i]=0;
           }
       }
        return false;
    }
}