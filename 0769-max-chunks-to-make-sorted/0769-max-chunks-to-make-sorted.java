class Solution {
    public int maxChunksToSorted(int[] arr) {
        int chunks=0;
        int maxSeen=-1;

        for(int i=0;i<arr.length;i++){
            maxSeen=Math.max(arr[i], maxSeen);
            if(maxSeen==i){
                chunks++;
            }
        }

        return chunks;
    }
}