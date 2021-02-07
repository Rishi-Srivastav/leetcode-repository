class Solution {
    
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList();
        int n = s.length();
        int ans[] = new int[n];
        cList(s, c, list);
        for(int i=0;i<n;i++){
            if(s.charAt(i)==c){
                ans[i] = 0;
            } else {
                ans[i] = minD(i,list);
            }
        }
        return ans;
    }
    
    public static int minD(int j, List<Integer> list){
        int min = Integer.MAX_VALUE;
        for (int i=0; i<list.size();i++) {
            min = Math.min(min, Math.abs(list.get(i)-j));
        }
        return min;
    }
    
    public static void cList(String s, char c,List<Integer> list){
        int n = s.length();
        for(int i=0;i<n;i++){
              if(s.charAt(i)==c){
                list.add(i);
            } 
    }
    }
}