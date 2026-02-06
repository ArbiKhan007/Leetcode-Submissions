class Solution {
    Map<Integer, Integer> parent;
    Map<Integer, Integer> size;
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        parent=new HashMap<> ();
        size=new HashMap<> ();
        
        for(int num:nums){
            parent.put(num, num);
            size.put(num, 1);
        }

        for(int num:nums){
            if(parent.containsKey(num+1)){
                union(num, num+1);
            }
        }

        int longest = 0;
        for (int num : size.keySet()) {
            longest = Math.max(longest, size.get(findPar(num)));
        }
        return longest;
    }

    public int findPar(int x){
        if(parent.get(x)!=x){
            parent.put(x, findPar(parent.get(x)));
            return parent.get(x);
        }

        return x;
    }

    public void union(int u, int v){
        int pu=findPar(u);
        int pv=findPar(v);

        if(pu==pv) return;

        if (size.get(pu) < size.get(pv)) {
            parent.put(pu, pv);
            size.put(pv, size.get(pv) + size.get(pu));
        } else {
            parent.put(pv, pu);
            size.put(pu, size.get(pu) + size.get(pv));
        }
    }
}