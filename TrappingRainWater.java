class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int sum = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                sum += (maxLeft - height[left]);
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                sum += (maxRight - height[right]);
            }
        }
        return sum;
    }
}
