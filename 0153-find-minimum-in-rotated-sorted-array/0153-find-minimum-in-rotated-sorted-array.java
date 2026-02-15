class Solution {
    public int findMin(int[] arr) {
        int l=0,r=arr.length-1;

        while(l<=r){
            int mid=l+(r-l)/2;

            if(arr[l]<=arr[mid]&&arr[mid]<=arr[r]){
                return arr[l];
            }else if(arr[l]<=arr[mid]){
                l=mid+1;
            }else if(arr[mid]<=arr[r]){
                r=mid-1;
                //System.out.print("this ran");
            }
        }

        return arr[l];
    }
}