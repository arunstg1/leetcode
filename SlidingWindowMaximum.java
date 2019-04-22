class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];
        
        int max = Integer.MIN_VALUE, start = 0, end = k - 1, maxIdx = -1, idx = 0;
        
        // Iterate thru the first k elements and find the max value
        for (int i = 0; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        
        // Add the max to the first index of result
        result[idx++] = max;
        
        while (end < nums.length - 1) {
            end++; start++;
            // If the new end is greater than max then its straight forward
            if (nums[end] > max) {
                max = nums[end];
                maxIdx = end;
            } else if (start - 1 == maxIdx) {
                // If the element that is being removed out was the previous max
                // then we need to scan the next 'k' elements to find max
                max = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    if (nums[i] > max) {
                        max = nums[i];
                        maxIdx = i;
                    }
                }
            }
            // else, if max is within the sliding window, no-op
            result[idx++] = max;
        }

        return result;
    }
}
