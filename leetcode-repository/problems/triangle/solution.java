class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i=1;i<triangle.size();i++)
            for(int j=0;j<triangle.get(i).size();j++)
                triangle.get(i)
                .set(j, triangle.get(i).get(j)+ Math.min(triangle.get(i-1).get(Math.min(triangle.get(i-1).size()-1,j)), triangle.get(i-1).get(Math.max(0,j-1))));
                                                                                                          return triangle.get(triangle.size()-1).stream().min(Integer::compareTo).get();
    }
}