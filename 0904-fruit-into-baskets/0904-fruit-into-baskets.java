class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> baskets=new HashMap<> ();

        int maxFruits=01;
        int i=0,j=0;

        while(j<fruits.length){
            while(baskets.size()>2){
                baskets.put(fruits[i], baskets.get(fruits[i])-1);
                if(baskets.get(fruits[i])==0) baskets.remove(fruits[i]);
                i++;
            }

            maxFruits=Math.max(maxFruits, j-i+1);
            baskets.put(fruits[j], baskets.getOrDefault(fruits[j],0)+1);
            j++;
        }

        return maxFruits;
    }
}