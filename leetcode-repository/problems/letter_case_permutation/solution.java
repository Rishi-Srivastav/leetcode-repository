class Solution {
     public static List<String> letterCasePermutation(String s) {
        Set<String> list = new HashSet<>();
        list.add(s);
        permutation(s.toCharArray(), 0, s.length(), list);
        return new ArrayList<>(list);
    }
    
    public static void permutation(char[] s, int start, int end, Set set) {
        if(start==end){
            set.add(new String(s));
            return;
        }

        for(int i=start;i<end;i++){
            swap(s, i);
            set.add(new String(s));
            permutation(s, i+1, end, set);
            swap(s, i);
            set.add(new String(s));
        }
    }

    public static void swap(char[] s, int i) {
        if(Character.isLowerCase(s[i])){
            s[i] = Character.toUpperCase(s[i]);
        } else if(Character.isUpperCase(s[i])) {
            s[i] = Character.toLowerCase(s[i]);
        }
    }
}