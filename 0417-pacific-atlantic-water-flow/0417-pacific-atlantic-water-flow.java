class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row=heights.length;
        int col=heights[0].length;
        boolean[][] pac=new boolean[row][col];
        boolean[][] atl=new boolean[row][col];

        for (int i = 0; i < row; i++) {
            dfs(heights, pac, i, 0);// left column
            dfs(heights, atl, i, col-1);// right column
        }

        for (int j = 0; j < col; j++) {
            dfs(heights, pac, 0, j);// top row
            dfs(heights, atl, row-1, j);// bottom row
        }

        List<List<Integer>> res=new ArrayList<> ();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(atl[i][j]&&pac[i][j]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    public void dfs(int[][] heights, boolean[][] vis, int i, int j){
        int m=heights.length;
        int n=heights[0].length;

        if(vis[i][j]) return;
        vis[i][j]=true;

        int[] dir={0,1,0,-1,0};

        for(int k=0;k<4;k++){
            int ni=i+dir[k];
            int nj=j+dir[k+1];

            if(ni>=m||nj>=n||ni<0||nj<0||vis[ni][nj]) continue;
            if(heights[ni][nj]>=heights[i][j]){
                dfs(heights, vis, ni, nj);
            }
        }
    }
}