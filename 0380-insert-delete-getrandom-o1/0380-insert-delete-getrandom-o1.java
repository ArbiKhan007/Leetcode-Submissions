import java.util.Random;
class RandomizedSet {
    Set<Integer> set;
    public RandomizedSet() {
        set=new HashSet<> ();
    }
    
    public boolean insert(int val) {
        boolean present=set.contains(val);
        set.add(val);
        return !present;
    }
    
    public boolean remove(int val) {
        boolean present=set.contains(val);
        set.remove(val);
        return present;
    }
    
    public int getRandom() {
        int len=set.toArray().length;
        int idx=new Random().nextInt(len);
        return (int) set.toArray()[idx];
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */