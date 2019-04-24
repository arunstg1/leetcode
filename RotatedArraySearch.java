class RotatedArraySearch {
    public int search(int[] nums, int target) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        // Handling array length of 1 and 2
        if (nums.length == 1) {
            return (nums[0] == target) ? 0 : -1;
        } else if (nums.length == 2) {
            if (nums[0] == target) {
                return 0;
            } else if (nums[1] == target) {
                return 1;
            } else {
                return -1;
            }
        }
        
        // Checking if the target is the first or the last one.
        if (nums[0] == target) {
            return 0;
        } else if (nums[nums.length - 1] == target) {
            return nums.length - 1;
        }
        
        int pivot = findPivot(nums, 0, nums.length - 1);
        
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.length - 1);
        } else if (nums[pivot] == target) {
            return pivot;
        } else if (target >= nums[pivot] && target <= nums[nums.length - 1]) {
            return binarySearch(nums, target, pivot, nums.length - 1);
        } else {
            return binarySearch(nums, target, 0, pivot - 1);
        }
    }
    
    private int findPivot(int[] nums, int start, int end) {        
        if (end < start) {
            return -1;
        }
        
        int mid = start + (end - start)/2;
        
        // If its sorted in asc order with no rotation
        if ((nums[start] < nums[mid] && nums[mid] < nums[end])) {
            return -1;
        }
        
        // If the length is 2 we can directly compare.
        if (end - start == 1) {
            if (nums[start] > nums[end]) {
                return end;
            } else {
                return -1;
            }
        }
        
        if (nums[mid - 1] > nums[mid]) {
            return mid;
        } else if (nums[mid] > nums[mid + 1]) {
            return mid + 1;
        } else if (nums[0] < nums[mid] ) {
            return findPivot(nums, mid + 1, end);
        } else {
            return findPivot(nums, start, mid - 1);
        }
    }
    
    private int binarySearch(int[] nums, int target, int start, int end) {
        int mid = start + (end - start)/2;
        //System.out.println("Binary search -- Start = " + start + ", end = " + end + ", mid = " + mid);
        if (end < start) {
            return -1;
        }
        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return binarySearch(nums, target, start, mid - 1);
        } else {
            return binarySearch(nums, target, mid + 1, end);
        }
    }
    
}
