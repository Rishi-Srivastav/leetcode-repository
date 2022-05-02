class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
            .map(q->new StringBuilder(q))
            .map(q->q.reverse())
            .reduce((a,b)->(a.append(" ").append(b)))
            .get()
            .toString();
    }
}