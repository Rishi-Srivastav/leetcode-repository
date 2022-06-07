class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList();
        
        List<Integer> l1 = new ArrayList();
        l1.add(1);
        lists.add(l1);
        for(int i=1;i<numRows;i++){
            List<Integer> lj = new ArrayList();
            for(int j=0;j<=i;j++){
                if(j==0 || j==i)
                    lj.add(1);
                else {
                    lj.add(lists.get(i-1).get(j-1)+ lists.get(i-1).get(j));
                }
            }
            lists.add(lj);
        }
        return lists;
    }
}