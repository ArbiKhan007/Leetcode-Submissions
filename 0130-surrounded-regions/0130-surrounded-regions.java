class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;

        boolean[][] vis=new boolean[m][n];

        for(int i=0;i<m;i++){
            if(!vis[i][0]&&board[i][0]=='O'){
                dfs(board,m,n,i,0,vis);
            }

            if(!vis[i][n-1]&&board[i][n-1]=='O'){
                dfs(board,m,n,i,n-1,vis);
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[0][i]&&board[0][i]=='O'){
                dfs(board,m,n,0,i,vis);
            }

            if(!vis[m-1][i]&&board[m-1][i]=='O'){
                dfs(board,m,n,m-1,i,vis);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j]&&board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

    public void dfs(char[][] board, int m, int n, int i, int j, boolean[][] vis){
        if(i<0||j<0||i>=m||j>=n||board[i][j]=='X'||vis[i][j]) return;

        vis[i][j]=true;
        dfs(board, m, n, i+1, j, vis);
        dfs(board, m, n, i, j+1, vis);
        dfs(board, m, n, i-1, j, vis);
        dfs(board, m, n, i, j-1, vis);
    }
}