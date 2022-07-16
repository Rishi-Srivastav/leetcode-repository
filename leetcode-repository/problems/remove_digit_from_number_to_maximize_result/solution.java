class Solution {
    public String removeDigit(String number, char digit) {
        String res="";
        for(int i=0;i<number.length()-1;i++){
            if(number.charAt(i)==digit && number.charAt(i)<number.charAt(i+1)){
                res=number.substring(0,i)+number.substring(i+1);
                break;
            }    
        }
        if(res.isEmpty()){
            int i=number.lastIndexOf(digit);
            res=number.substring(0,i)+number.substring(i+1);
        }
        return res;
    }
}