class Solution {
    List<Integer> res=new ArrayList<> ();
    public List<Integer> lexicalOrder(int n) {
        for(int i=1;i<10;i++){
            helper(i, n);
        }

        return res;
    }

    public void helper(int curr,int n){
        if(curr>n) return;

        res.add(curr);
        curr*=10;

        for(int i=0;i<10;i++){
            helper(curr+i, n);
        }
    }
}