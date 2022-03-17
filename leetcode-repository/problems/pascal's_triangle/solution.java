class Solution {
 	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> list = new ArrayList<Integer>(i + 1);
			lists.add(list);
		}
		lists.get(0).add(1);

		for (int i = 1; i < numRows; i++) { // to reach to every list to populate value
			int j=0;
			for (j = 0; j < i; j++) { // to iterate through last list values

				if(j==0) {
					lists.get(i).add(j, 1);
				} else {
				lists.get(i).add(j, lists.get(i - 1).get(j) + lists.get(i - 1).get(j - 1));
				}
			}
			lists.get(i).add(i, 1);
		}
		return lists;
	}
}