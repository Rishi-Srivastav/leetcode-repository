class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList();
        list.add(1);
        if(rowIndex==0)
            return list;
        return recursiveRow(list, rowIndex, 0);
    }
    
    public List<Integer> recursiveRow(List<Integer> list, int rowIndex, int n){
        if(rowIndex==n)
            return list;
        
        List<Integer> lj = new ArrayList();
        lj.add(1);
         for(int i=1;i<list.size();i++){
             lj.add(list.get(i-1)+ list.get(i));
                }
       lj.add(1);
       return recursiveRow(lj, rowIndex, n+1);
    }
}