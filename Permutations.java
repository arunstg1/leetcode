class Permutations {
    List<List<Integer>> returnList = new ArrayList<>();
        
    public List<List<Integer>> permute(int[] nums) {
        permute(nums, 0);
        return returnList;
    }
    
    private void permute(int[] nums, int level) {
        if (nums.length - 1 == level) {
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                l.add(nums[i]);
            }
            returnList.add(l);
        }
        
        for (int i = level; i < nums.length; i++) {
            swap(nums, level, i);
            permute(nums, level + 1);
            swap(nums, level, i);
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
