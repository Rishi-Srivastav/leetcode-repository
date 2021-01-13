class Solution {
    
    public int numRescueBoats(int[] people, int limit) {
        List<Integer> list = new ArrayList<>();
        int ans = 0;
        for (int p : people)
            list.add(p);

        Collections.sort(list, Collections.reverseOrder());

        int end = list.size() - 1;
        int start = 0;
        for (int i = start; i <= end; i++) {
            if (start == end) {
                ans++;
                break;
            }
            if (list.get(i) > limit) {
                start++;
                ans++;
            } else {
                if (list.get(i) + list.get(end) > limit) {
                    start++;
                    ans++;
                } else {
                    start++;
                    end--;
                    ans++;
                }
            }
        }
        return ans;
    }
}