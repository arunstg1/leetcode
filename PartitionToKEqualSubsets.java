class PartitionToKEqualSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        
        Arrays.sort(nums);
        
        int sum = 0;
        for (int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
        }
        
        if (sum % k != 0) {
            return false;
        }
        
        int eachSubset = sum / k;
        
        int counter = nums.length - 1;
        
        while (nums[counter] == eachSubset) {
            counter--;
        }
        
        return canPartition(nums, counter, new int[k - (nums.length - counter) + 1], eachSubset);
    }
    
    private boolean canPartition(int[] nums, int counter, int[] partitions, int eachSubset) {
        if (counter < 0) {
            return true;
        }
        
        int currValue = nums[counter];
        
        for (int i = 0; i < partitions.length; i++) {
            if (partitions[i] + currValue <= eachSubset) {
                partitions[i] += currValue;
                if (canPartition(nums, counter - 1, partitions, eachSubset)) {
                    return true;
                }
                partitions[i] -= currValue;
            }
        }
        return false;
    }
}
