class Solution {
    int maxArea=0;
    int area=0;
    public int maxAreaOfIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] vis=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    area=0;
                    dfs(grid, vis, i, j);
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid, int[][] vis, int i, int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]==0||vis[i][j]==1){
            return;
        }

        vis[i][j]=1;
        area++;
        maxArea=Math.max(area, maxArea);
        dfs(grid, vis, i+1, j);
        dfs(grid, vis, i, j+1);
        dfs(grid, vis, i-1, j);
        dfs(grid, vis, i, j-1);
    }
}