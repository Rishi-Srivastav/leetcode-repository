class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
    	char[] s = magazine.toCharArray();
    	char[] az = new char[26];
    	
    	for(int i=0;i<s.length;i++) {
    		az[s[i]-'a']++;
    	}
    	for(int i=0;i<ransomNote.length();i++) {
    		char ch = ransomNote.charAt(i);
    		if(az[ch-'a']>0) {
    			az[ch-'a']--;
    		} else {
    			return false;
    		}
    	}
    	return true;
    }
}