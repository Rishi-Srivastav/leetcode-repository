class Solution {
   
    
	   public String reformatNumber(String number) {
		 
		   number = number.replaceAll("-", "");
		   number=number.replace(" ", "");
	        
	        int l=number.length();
	        StringBuffer output = new StringBuffer();
	        int r=l, start=0;
	        while(start<l && l-start>5){
	            output.append(number.substring(start, start+3));
	            output.append("-");
	            start+=3;
	        }
	        if(l-start==5){
	            output.append(number.substring(start, start+3)).append("-").append(number.substring(start+3, l));
	           
	        }
	        if(l-start==4){
	            output.append(number.substring(start, start+2)).append("-").append(number.substring(start+2, l));
	        }
	        if(l-start==3){
	            output.append(number.substring(start, start+3));
	        }
	        if(l-start==2){
	            output.append(number.substring(start, start+2));
	        }
	        return new String(output);
	        
	    }
}