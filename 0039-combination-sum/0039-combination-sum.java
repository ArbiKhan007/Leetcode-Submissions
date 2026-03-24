class Solution {
    List<List<Integer>> res=new ArrayList<> ();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        fillRes(candidates, target, 0, 0, new ArrayList<> ());
        return res;
    }

    public void fillRes(int[] candidates, int target, int idx, int sum, List<Integer> list){
        if(idx>=candidates.length||sum>target){
            return;
        }

        if(sum==target){
            res.add(new ArrayList<> (list));
            return;
        }

        list.add(candidates[idx]);
        fillRes(candidates, target, idx, sum+candidates[idx], list);
        list.remove(list.size()-1);

        fillRes(candidates, target, idx+1, sum, list);
    }
}