class UniqueBST {
    public int numTrees(int n) {
        
        int[] result = new int[n + 1];
        result[0] = 1; result[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            int count = 0;
            int low = 0, high = (i - 1);
            
            while (low < i && high >= 0) {
                count += result[low] * result[high];
                low++; high--;
            }
            
            result[i] = count;
        }
        
        return result[n];
    }
}
