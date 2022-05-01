class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int n=tokens.length;
        int sum=0;
        if(n==1)
            return Integer.parseInt(tokens[0]);
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("/") || tokens[i].equals("*")){
                int a=stack.pop();
                int b=stack.pop();
                sum=operation(a,b,tokens[i]);
                stack.push(sum);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return sum;        
    }
    
    public int operation(int a, int b, String s){
        int ans=0;
        switch(s){
            case "+": ans=a+b;
                break;
            case "-": ans=b-a;
                break;
            case "/":ans=b/a;
                break;
            case "*":ans=a*b;
                break;
        }
        return ans;
    }
}