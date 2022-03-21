class Solution {
    public void reverseString(char[] s) {
        replace(0, s.length-1, s);
        System.out.println(s);
    }
	
    private void replace(int i, int j, char[] s) {
		if(i>=j)
			return;
		char t =s[i];
		s[i]=s[j];
		s[j]=t;
		replace(i+1, j-1, s);
	}
}