import java.util.Map.Entry;
class Solution {

    	class Helper {
		int index;
		int count;

		public Helper(int i, int c) {
			this.index = i;
			this.count = c;
		}
	}
    
	public int firstUniqChar(String s) {
		Map<Character, Helper> set = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (set.containsKey(ch)) {
				Helper helper = set.get(ch);
				helper.count++;
			} else {
				set.put(ch, new Helper(i, 1));
			}
		}
		for (Entry<Character, Helper> entry : set.entrySet()) {
			if (entry.getValue().count == 1) {
				return entry.getValue().index;
			}
		}
		return -1;
	}
    
}