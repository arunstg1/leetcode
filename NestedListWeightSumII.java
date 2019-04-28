/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class NestedListWeightSumII {
    Map<Integer, ArrayList<Integer>> map = new HashMap<>();
    int maxDepth = 0;
    int totalSum = 0;
    
    public int depthSumInverse(List<NestedInteger> nestedList) {
        depthSumInverse(nestedList, 0);
        
        maxDepth++;
        
        for (Integer key : map.keySet()) {
            ArrayList<Integer> al = map.get(key);
            for (Integer i : al) {
                totalSum += (maxDepth - key) * i;
            }
        }
        
        return totalSum;
    }
    
    private void depthSumInverse(List<NestedInteger> nestedList, int depth) {
        if (depth > maxDepth) {
            maxDepth = depth;
        }
        
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                if (!map.containsKey(depth)) {
                    map.put(depth, new ArrayList<Integer>());
                }
                ArrayList<Integer> al = map.get(depth);
                al.add(ni.getInteger());
                map.put(depth, al);
            } else {
                depthSumInverse(ni.getList(), depth + 1);
            }
        }
        
    }
}
