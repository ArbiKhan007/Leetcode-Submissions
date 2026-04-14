class Solution {
    public int maxDepth(String s) {
        int dep=0;
        int maxDep=0;

        for(char c:s.toCharArray()){
            if(c=='('){
                dep++;
                maxDep=Math.max(dep, maxDep);
            }else if(c==')'){
                dep--;
            }
        }

        return maxDep;
    }
}