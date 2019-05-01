class RandomPickWithWeight {
    
    int[] aggWt;
    int total;
    Random rand;

    public Solution(int[] w) {
        rand = new Random();
        total = w[0];
        aggWt = new int[w.length + 1];
        aggWt[0] = 0;
        for (int i = 1; i < w.length; i++) {
            aggWt[i] = w[i - 1] + aggWt[i - 1];
            total += w[i];
        }
        aggWt[aggWt.length - 1] = w[w.length - 1] + aggWt[w.length - 1];
    }
    
    public int pickIndex() {
        int randomVal = rand.nextInt(total);
        int closestIdx = findClosestIndex(randomVal);
        return closestIdx;
    }
    
    private int findClosestIndex(int no) {
        int low = 0, high = aggWt.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (low == high) {
                if (low == aggWt.length - 1) {
                    return low - 1;
                }
                return low;
            } else if (no >= aggWt[mid] && no < aggWt[mid + 1]) {
                return mid;
            } else if (aggWt[mid] > no) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
