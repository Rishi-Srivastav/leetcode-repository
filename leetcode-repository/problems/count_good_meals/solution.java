class Solution {
       int mod = 1000000007;
        public int countPairs(int[] deliciousness) {
        long  sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
       
          for(int num:deliciousness){
             int pow =1; 
          for(int n=0;n<22;n++){
             
              int k = pow-num;
              
             if(map.containsKey(k)){
                sum+=map.get(k);
                sum%=1000000007 ;
            
             }
              pow*=2;
			  }
              map.put(num, map.getOrDefault(num, 0)+1);
          }

        return (int)sum;
}
}