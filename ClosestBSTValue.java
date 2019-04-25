/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class ClosestBSTValue {
    int closestVal = Integer.MAX_VALUE;
    int minDiff = Integer.MAX_VALUE;
    
    public int closestValue(TreeNode root, double target) {     
        if (root == null)  {
            return -1;
        }
        
        if (root.val == target) {
            return root.val;
        } else if (root.val > target) {
            int thisDiff = (int) (root.val - Math.round(target));
            if (thisDiff == 0) {
                return root.val;
            }
            
            if (thisDiff < minDiff) {
                closestVal = root.val;
                minDiff = thisDiff;
            }
            
            int retVal = closestValue(root.left, target);
            return retVal == -1 ? closestVal : retVal;
        } else {
            int thisDiff = (int) (Math.round(target) -  root.val);
            if (thisDiff == 0) {
                return root.val;
            }
            
            if (thisDiff < minDiff) {
                closestVal = root.val;
                minDiff = thisDiff;
            }
            
            int retVal = closestValue(root.right, target);
            return retVal == -1 ? closestVal : retVal;
        }
    }
}
