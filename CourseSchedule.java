class CourseSchedule {
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        
        int noOfPossibleCourses = 0;
        
        List<Integer>[] list = new List[numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            list[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        return !isCyclePresent(list);
    }
    
    private boolean isCyclePresent(List<Integer>[] list) {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> exploring = new HashSet<>();
        
        for (int i = 0; i < list.length; i++) {
            if (!visited.contains(i)) {
                if (isCyclePresent(i, list, visited, exploring)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean isCyclePresent(int i, List<Integer>[] list, Set<Integer> visited, Set<Integer> exploring) {
        exploring.add(i);
        for (Integer child : list[i]) {
            if (exploring.contains(child)) {
                return true;
            }
            if (visited.contains(child)) {
                continue;
            }
            exploring.add(child);
            if (isCyclePresent(child, list, visited, exploring)) {
                return true;
            }
        }
        exploring.remove(i);
        visited.add(i);
        return false;
    }
}
