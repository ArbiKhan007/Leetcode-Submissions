class Solution {
    public String stringHash(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i+=k){
            int sum=0;
            for(int j=i;j<i+k;j++){
                char c=s.charAt(j);
                sum+=(int)(c-'a');
            }

            sum%=26;
            sb.append((char) (sum+'a'));
        }

        return sb.toString();
    }
}