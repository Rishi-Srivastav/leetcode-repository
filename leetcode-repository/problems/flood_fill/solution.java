class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m=image.length;
        int n=image[0].length;
        if(sr>m || sc>n || image[sr][sc]==newColor)
            return image;
        
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }
    
    public void fill(int[][] image, int sr, int sc, int newColor, int oldColor){
        if(sr==-1 || sc==-1 || sr==image.length || sc==image[0].length || image[sr][sc]!=oldColor)
            return;
        
        if(image[sr][sc]==oldColor){
            image[sr][sc]=newColor;     
        }
       
        fill(image, sr-1, sc, newColor,oldColor);
        fill(image, sr+1, sc, newColor, oldColor);
        fill(image, sr, sc-1, newColor, oldColor);
        fill(image, sr, sc+1, newColor, oldColor);
    }
}