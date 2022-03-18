class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] az = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        int count=0;
        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<words.length;i++) {
        	StringBuilder result=new StringBuilder();
        	for(int j=0;j<words[i].length();j++) {
        		result.append(az[words[i].charAt(j) - 'a']);
        	}
        	set.add(result.toString());
        }
        return set.size();
    }
}