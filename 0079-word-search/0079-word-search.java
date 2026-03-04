class Solution {
    public boolean exist(char[][] board, String word) {
        int[] freq = new int[128];

        for(char[] row : board)
            for(char c : row)
                freq[c]++;

        for(char c : word.toCharArray())
            if(--freq[c] < 0)
                return false;

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                char c=board[i][j];
                if(c==word.charAt(0)){
                    if(dfs(board, word, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int idx){
        if(i<0||j<0||i>=board.length||j>=board[0].length||word.charAt(idx)!=board[i][j]){
            //System.out.println("here");
            return false;
        }

        if(idx==word.length()-1){
            if(word.charAt(idx)==board[i][j]){
                return true;
            }

            return false;
        }

        char temp=board[i][j];
        board[i][j]='%';
        boolean up=dfs(board, word, i-1, j, idx+1);
        boolean down=dfs(board, word, i+1, j, idx+1);
        boolean left=dfs(board, word, i, j-1, idx+1);
        boolean right=dfs(board, word, i, j+1, idx+1);
        board[i][j]=temp;
        
        return up||down||left||right;
    }
}