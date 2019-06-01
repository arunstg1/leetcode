class InsertInterval_1 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int[][] resultArray = new int[intervals.length == 0 ? 1 : intervals.length * 2][2];
        int count = 0;
        
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] > intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                // newInt: [2,3], interval: [1,5]
                newInterval = intervals[i];
            } else if (newInterval[0] > intervals[i][0] && newInterval[0] < intervals[i][1]) {
                // newInt: [2,5], interval: [1,3]
                newInterval[0] = intervals[i][0];
                newInterval[1] = Math.max(intervals[i][0], newInterval[1]);
            } else if (newInterval[1] < intervals[i][0]) {
                // newInt: [2,5], interval: [6,9]
                // Adding newInterval to the final result.
                resultArray[count++] = newInterval;
                newInterval = intervals[i];
            } else if (newInterval[1] == intervals[i][0]) {
                // newInt: [1,4], interval: [4,9]
                newInterval[1] = intervals[i][1];
            } else if (newInterval[0] < intervals[i][0] && newInterval[1] >= intervals[i][1]) {
                // newInt: [1,4], interval: [2,3] or newInt: [1,3], interval: [2,3]
                newInterval = newInterval;
            } else if (newInterval[0] > intervals[i][0] && newInterval[0] > intervals[i][1]) {
                // newInt: [4,8], interval: [1,2]
                // Adding intervals[i] to the final result
                resultArray[count++] = intervals[i];
            } else if (newInterval[0] == intervals[i][1]) {
                // newInt: [5,7], interval: [1,5]
                newInterval[0] = intervals[i][0];
            } else if (newInterval[1] > intervals[i][0] && newInterval[1] <= intervals[i][1]) {
                // newInt: [0,3], interval: [1,5]
                newInterval[1] = intervals[i][1];
            }
        }
        
        resultArray[count++] = newInterval;
                                              
        return Arrays.copyOfRange(resultArray, 0, count);
    }
            
}
