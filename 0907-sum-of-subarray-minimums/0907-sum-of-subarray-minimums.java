class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        long total=0;
        int mod=(int) 1e9+7;

        int[] psee=psee(arr);
        int[] nse=nse(arr);

        for(int i=0;i<n;i++){
            //System.out.println(psee[i]+":"+nse[i]);
            int left=i-psee[i];
            int right=nse[i]-i;

            long contrib=(long) left*right*arr[i];
            total=(total+contrib)%mod;
        }

        return (int) total;
    }

    public int[] nse(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<> ();

        for(int i=n-1;i>=0;i--){
            int num=arr[i];
            while(!st.isEmpty()&&arr[st.peek()]>=num){
                st.pop();
            }

            res[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }

        return res;
    }

    public int[] psee(int[] arr){
        int n=arr.length;
        int[] res=new int[n];
        Stack<Integer> st=new Stack<> ();

        for(int i=0;i<n;i++){
            int num=arr[i];
            while(!st.isEmpty()&&arr[st.peek()]>num){
                st.pop();
            }

            res[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }

        return res;
    }
}