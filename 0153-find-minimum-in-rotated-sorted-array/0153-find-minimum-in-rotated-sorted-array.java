class Solution {
    public int findMin(int[] arr) {
        int l=0,r=arr.length-1;

        while(l<r){
            int mid=l+(r-l)/2;

            if(arr[r]<arr[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }

        return arr[l];
    }
}