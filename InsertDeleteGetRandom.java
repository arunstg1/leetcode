class InsertDeleteGetRandom {
    List<Integer> l;
    int size;
    Map<Integer, HashSet<Integer>> positionMap;
    Random random;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        l = new ArrayList<>();
        size = 0;
        positionMap = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean notContainsKey = true;
        if (positionMap.containsKey(val)) {
            notContainsKey = false;
        }
        l.add(size, val);
        HashSet hs = positionMap.getOrDefault(val, new HashSet<>());
        hs.add(size);
        positionMap.put(val, hs);
        size++;
        return notContainsKey;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        HashSet<Integer> set = positionMap.getOrDefault(val, null);
        if (set == null) {
            return false;
        }
        
        int idx = -1;
        for (int i : set) {
            idx = i;
            break;
        }
        
        set.remove(idx);
        if (set.size() == 0) {
            positionMap.remove(val);
        }
        
        if (idx < size - 1) {
            l.set(idx, l.get(size - 1));
            HashSet<Integer> hs = positionMap.get(l.get(size - 1));
            hs.remove(size - 1);
            hs.add(idx);
        }
        
        size--;
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int pos = (int) (random.nextInt(size));
        return l.get(pos);
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
