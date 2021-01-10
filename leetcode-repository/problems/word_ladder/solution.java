class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet();
        
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        
        if(!set.contains(endWord)) return 0;
       
        int level = 0, wordlength = beginWord.length();
        
       // Push the starting word into the queue
        Queue<String> Q = new LinkedList<>();
        Q.add(beginWord);
       
        while(!Q.isEmpty()){
            int size = Q.size();
            level++;
            for(int i=0;i<size;i++){
                char[] w = Q.remove().toCharArray();
                
                for(int j=0;j<wordlength;j++){
                    char orig = w[j];
                    
                    for(char c='a'; c<='z';c++){
                        w[j]=c;
                        if(new String(w).equals(endWord))
                            return level+1;
                        if(set.contains(new String(w))){
                            set.remove(new String(w));
                            Q.add(new String(w));
                        }
                    }
                    w[j] = orig;
                }
            }
        }
        return 0;
    }
}