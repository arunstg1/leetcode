/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BinaryTreeLeaves {
    
    List<List<Integer>> returnList = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        findLevels(root);
        return returnList;
    }
    
    private int findLevels(TreeNode root) {
        if (root == null) {
            return -1;
        }
        
        // post order traversal        
        int levelLeft = findLevels(root.left);
        int levelRight = findLevels(root.right);
        
        int retVal = Math.max(levelLeft, levelRight) + 1;
        
        if (returnList.size() == retVal) {
            returnList.add(new ArrayList<>());
        }
        returnList.get(retVal).add(root.val);
        
        return retVal;
    }
}
