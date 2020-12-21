class Solution {
    public int numPairsDivisibleBy60(int[] a) {
        int l = a.length;
        int sum=0;
        int count[] = new int[60];
        for(int i=0;i<60;i++){
           count[i]=0;
        }
        
        for(int i=0;i<l;i++){
           count[a[i]%60]++;
        }
        for(int i=1;i<=29;i++){
            sum = sum + count[i] * count[60-i];
        }
        sum = sum + count[30]*(count[30]-1)/2 + count[0]*(count[0]-1)/2;
        return sum;
    }
}

//30,40,30,20,20
//c[30]=3, c[20]=3, c[40]=1 nC2 = n!/ n-2 * 2 = n