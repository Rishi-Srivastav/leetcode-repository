class Solution {
    public double averageWaitingTime(int[][] customers) {
     //  wait(a[i,j]) = wait[i-1] + a[i,1] - a[i,0] + a[i-1,0] 
       //    wait[0]= 2
         //  wait[1] = 2+5-2+1 = 6
           //wait[2] = 6+3-4+2 = 7
         
        int[] wait = new int[customers.length];
        
        wait[0] = customers[0][1];
        double sum = wait[0];
        if(customers.length==1)
            return sum;
        
        for(int i=1;i<customers.length;i++){
            if(wait[i-1]+customers[i-1][0]>customers[i][0]){
                wait[i] = wait[i-1]+customers[i][1]-customers[i][0]+customers[i-1][0];
            } else {
                wait[i] = customers[i][1];
            }
            
            sum += wait[i];
        }
        
     return sum/customers.length;
}
}