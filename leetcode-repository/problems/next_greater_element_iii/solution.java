class Solution {
     public static char[] sort(char[] a, int k, int n){
	        if(k>=n)
	            return a;
	        //sort k to n-1
	        //2 3 0 2 4 1
	        for(int i=k;i<n-1;i++){
	            int min = i;
	            for(int j=i+1;j<n;j++){
	                if(Integer.parseInt(String.valueOf(a[min])) > Integer.parseInt(String.valueOf(a[j]))){
	                    min = j;
	                }
	            }
	            char tmp = a[i];
	            a[i] = a[min];
	            a[min] = tmp; 
	        }
	        return a;
	    }
    
   	public static int nextGreaterElement(int n) {
        int d = 0;
        // 124466746895
        // 124466748695
        List<Integer> list = new ArrayList();
        char[] s = (""+n).toCharArray();
    	d=s.length;
        for(int i=d-1;i>=1;i--){
        	s = (""+n).toCharArray();
            for(int j=i-1;j>=0;j--){
                if(s[i]>s[j]){
                    char tmp = s[i];
                    s[i] = s[j];
                    s[j] = tmp;
                    sort(s, j+1, d);
                    try{
                    list.add(Integer.parseInt(new String(s)));
                    } catch(Exception e){}
                    break;
                }
            }
        }
        
        return list.isEmpty()? -1 : Collections.min(list);
    }
}