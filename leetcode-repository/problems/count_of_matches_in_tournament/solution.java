class Solution {
    public int numberOfMatches(int n) {
       int sum = 0;
        if(n<=1)
            return sum;
        
       if(n%2==0)
           sum += n/2 + numberOfMatches(n/2);
        else
            sum += (n-1)/2 + numberOfMatches((n+1)/2);
        
        return sum;
    }
}