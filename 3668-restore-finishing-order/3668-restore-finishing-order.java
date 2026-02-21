class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        Set<Integer> set=new HashSet<> ();
        int[] res=new int[friends.length];
        int idx=0;

        for(int fri:friends){
            set.add(fri);
        }

        for(int i=0;i<order.length;i++){
            if(set.contains(order[i])){
                res[idx++]=order[i];
            }
        }

        return res;
    }
}