class Solution {
    public String longestPalindrome(String s) {
        int max_length =1, start=0;
        char[] arr = s.toCharArray();
        if(arr.length<=1)
            return s;
        for(int i=1;i<arr.length;i++){
            //even-palindrome
            int low = i-1;
            int high = i;
            
            while(low>=0 && high<arr.length && arr[low]==arr[high]){
                if(max_length<high-low+1){
                    max_length=high-low+1;
                    start=low;
                }
                low--;
                high++;   
            }
            
            low=i-1;
            high=i+1;
            while(low>=0 && high<arr.length && arr[low]==arr[high]){
               if(max_length<high-low+1){
                    max_length=high-low+1;
                    start=low;
                }
                low--;
                high++;   
            }
            }
           return s.substring(start, start+max_length);
        }
    }