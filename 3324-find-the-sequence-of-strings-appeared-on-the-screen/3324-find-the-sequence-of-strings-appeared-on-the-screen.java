class Solution {
    public List<String> stringSequence(String target) {
        //sharma
        //idx -> target idx
        //a,b,c,d.....s,s
        List<String> res=new ArrayList<> ();
        int idx=0;
        StringBuilder sb=new StringBuilder();

        char c='a';
        while(c<='z'){
            if(idx==target.length()) break;
            if(idx>0) res.add(target.substring(0,idx)+c);
            else res.add(""+c);

            if(target.charAt(idx)==c){
                c='a';
                idx++;
                continue;
            }

            c++;
        }

        return res;
    }
}