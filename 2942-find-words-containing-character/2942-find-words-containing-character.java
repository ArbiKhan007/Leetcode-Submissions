class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res=new ArrayList<> ();
        for(int i=0;i<words.length;i++){
            String str=words[i];
            if(str.indexOf(x)!=-1){
                res.add(i);
            }
        }

        return res;
    }
}