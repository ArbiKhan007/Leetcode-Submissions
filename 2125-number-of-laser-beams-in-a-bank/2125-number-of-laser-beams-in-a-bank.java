class Solution {
    public int numberOfBeams(String[] bank) {
        int totalBeam=0;
        int prevLvlCount=0;

        for(String level:bank){
            int levelCount=0;
            for(char block:level.toCharArray()){
                if(block=='1'){
                    totalBeam+=prevLvlCount;
                    levelCount++;
                }
            }
            if(levelCount!=0) prevLvlCount=levelCount;
        }

        return totalBeam;
    }
}