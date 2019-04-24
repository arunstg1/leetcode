class ClosestKElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        List<Integer> returnList = new ArrayList<>();
        
        // When x is less than all or greater than all elements in array
        if (x < arr[0]) {
            for (int i = 0; i < k; i++) {
                returnList.add(arr[i]);
            }
            return returnList;
        } else if (x > arr[arr.length - 1]) {
            for (int i = arr.length - k; i < arr.length; i++) {
                returnList.add(arr[i]);
            }
            return returnList;
        }
        
        int leftIdx = getEltOrClosest(arr, x);
        int rightIdx = leftIdx + 1;
        
        leftIdx--;
        
        int counter = 1;
        while (counter < k) {
            int leftDiff = Integer.MAX_VALUE;
            int rightDiff = Integer.MAX_VALUE;
            
            if (leftIdx >= 0) {
                leftDiff = x - arr[leftIdx];
            }
            if (rightIdx < arr.length) {
                rightDiff = arr[rightIdx] - x;
            }
            
            if (leftDiff <= rightDiff) {
                leftIdx--;
            } else {
                rightIdx++;
            }
            counter++;
        }
        
        for (int i = leftIdx + 1; i < rightIdx; i++) {
            returnList.add(arr[i]);
        }
        
        return returnList;
    }
    
    private int getEltOrClosest(int[] arr, int x) {
        
        int maxDiff = Integer.MAX_VALUE; int idx = -1;
        
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            
            int diffFromX = Math.abs(arr[mid] - x);
            if (diffFromX < maxDiff) {
                maxDiff = diffFromX;
                idx = mid;
            }
            
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return idx;
    }
}
