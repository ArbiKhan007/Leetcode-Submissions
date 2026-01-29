class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int[][] vis=new int[m][n];
        dfs(image,sr,sc,color,image[sr][sc],vis);
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int color, int srcCol, int[][] vis){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length){
            return;
        }

        if(image[sr][sc]!=srcCol||vis[sr][sc]==1){
            return;
        }

        vis[sr][sc]=1;
        image[sr][sc]=color;
        dfs(image,sr+1,sc,color,srcCol,vis);
        dfs(image,sr,sc+1,color,srcCol,vis);
        dfs(image,sr-1,sc,color,srcCol,vis);
        dfs(image,sr,sc-1,color,srcCol,vis);
    }
}