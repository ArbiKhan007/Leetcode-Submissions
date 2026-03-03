class Solution {
    public boolean isValidSerialization(String preorder) {
        int vac=1;
        String[] prearr=preorder.split(",");
        for(String str:prearr){
            vac--;
            if(str.equals("#")){
                if(vac<0) return false;
            }else{
                if(vac<0) return false;
                vac+=2;
            }
        }

        return vac==0;
    }
}