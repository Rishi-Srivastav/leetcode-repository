class Solution {
    
    
    public static List<Integer> getRow(int rowIndex) {
       List<List<Integer>> f = new ArrayList(10);
        List<Integer> f0 = new ArrayList(1);
        f0.add(1);
        f.add(f0);
        
        List<Integer> f1 = new ArrayList(2);
        f1.add(1);
        f1.add(1);
        f.add(f1);
        
        //(i,j)=f(i−1,j−1)+f(i−1,j)
        
        if(rowIndex == 0 || rowIndex == 1){
            return f.get(rowIndex);
        }
        
        return getRowList(rowIndex, f, 1);    
        
    }
      
    public static List<Integer> getRowList(int rowIndex, List<List<Integer>> f, int start){
            if(start == rowIndex){
                return f.get(rowIndex);
            }
        start++;
        List<Integer> f1 = new ArrayList(start+1);
    
        for(int i=0;i<=start; i++){
            if(i== 0 || i== start){
                f1.add(1);
            } else{
                f1.add( f.get(start-1).get(i-1) + f.get(start-1).get(i));
            }
        }
        f.add(f1);
        return getRowList(rowIndex, f, start);
        }    
    }