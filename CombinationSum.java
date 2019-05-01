class CombinationSum {
    List<List<Integer>> returnList = new ArrayList<>();
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return null;
        }
        combinationSum(candidates, 0, target, 0, new ArrayList<Integer>());
        return returnList;
    }
    
    private void combinationSum(int[] candidates, int start, int target, int currentSum, List<Integer> al) {
        if (target == currentSum) {
            returnList.add(new ArrayList<Integer>(al));
            return;
        }
        if (currentSum > target) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            al.add(candidates[i]);
            combinationSum(candidates, i, target, currentSum + candidates[i], al);
            al.remove(al.size() - 1);
        }
    }
}
