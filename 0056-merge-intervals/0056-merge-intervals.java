class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res=new ArrayList<> ();
        Arrays.sort(intervals, (a,b)->{
            return a[0]-b[0];
        });
        
        int st=intervals[0][0];
        int end=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            if(intervals[i][0]>end){
                res.add(new int[]{st, end});
                st=intervals[i][0];
                end=intervals[i][1];
            }else{
                end=Math.max(intervals[i][1], end);
            }
        }

        res.add(new int[]{st, end});
        return res.toArray(new int[res.size()][]);
    }
}