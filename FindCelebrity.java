/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindCelebrity.java extends Relation {
    public int findCelebrity(int n) {
        
        int i = 0, j = n - 1;
        
        while (i < j) {
            if (knows(i, j)) {
                i++;
            } else {
                j--;
            }
        }
        
        for (int k = 0; k < n; k++) {
            if (k == i) {
                continue;
            }
            if (!knows(k, i) || knows(i, k)) {
                return -1;
            }
        }
        return i;
    }
}
