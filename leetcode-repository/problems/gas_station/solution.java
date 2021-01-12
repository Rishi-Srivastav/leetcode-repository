class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start=-1;
        if(n==1)
            return gas[0]>=cost[0]?0:-1;
        for(int i=0;i<n;i++){
            if(gas[i]>cost[i]){
                boolean b = check(i, gas, cost, n) ;
                if(b) return i;
            }
        }
        return start;
    }
    
    public static boolean check(int start, int[] gas, int[] cost, int n){
        int sum=0;
        int i=start;
        while(i<n){
          sum+=gas[i]-cost[i];
            if(sum<0)
                return false;
            i++;
        }
        i=0;
        while(i<start){
             sum+=gas[i]-cost[i];
            if(sum<0)
                return false;
             i++;
        }
        return true;
    }
}