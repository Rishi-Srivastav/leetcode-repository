class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int n=image[0].length;
        if(sr>m || sc>n || image[sr][sc]==newColor)
            return image;
        
        int pixColor = image[sr][sc];
        
        colorIt(image, sr,sc,newColor,pixColor);
        return image;
        
        
    }
    
    public void colorIt(int[][] image, int sr, int sc, int newColor, int pixColor){
        if(sr==-1 || sc==-1 || sr==image.length || sc==image[0].length || image[sr][sc]!=pixColor ){
            return;
        }
        
        if(image[sr][sc]==pixColor){
            image[sr][sc]=newColor;
        }
        
        colorIt(image, sr-1, sc, newColor, pixColor);
        colorIt(image, sr, sc-1, newColor, pixColor);
        colorIt(image, sr, sc+1, newColor, pixColor);
        colorIt(image, sr+1, sc, newColor, pixColor);
    }
}