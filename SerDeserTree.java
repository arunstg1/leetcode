/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class SerDeserTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        
        int noOfElts = q.size();
        
        
        // serializing it in level order
        while(!q.isEmpty()) {
            StringBuilder sbTemp = new StringBuilder();
            boolean nonNullPresent = false;
            
            while (noOfElts > 0) {
                TreeNode tn = q.poll();
                if (sbTemp.length() != 0) {
                    sbTemp.append(",");
                }
                if (tn == null) {
                    sbTemp.append("#");
                } else {
                    sbTemp.append(tn.val);
                    q.add(tn.left);
                    q.add(tn.right);
                    
                    nonNullPresent = true;
                }
                noOfElts--;
            }
            if (nonNullPresent) {
                if (sb.length() != 0) {
                    sb.append(",");
                }
                sb.append(sbTemp);
                sbTemp = new StringBuilder();
            }
            noOfElts = q.size();
        }
        //System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.trim().length() == 0) {
            return null;
        }
        String[] dataArr = data.split(",");
        
        List<TreeNode> l1 = new ArrayList<>();
        List<TreeNode> l2 = new ArrayList<>();
        
        TreeNode tn = new TreeNode(Integer.parseInt(dataArr[0]));
        
        if (dataArr.length > 1 && !"#".equals(dataArr[1])) {
            tn.left = new TreeNode(Integer.parseInt(dataArr[1]));
            l1.add(tn.left);
        }
        if (dataArr.length > 1 && !"#".equals(dataArr[2])) {
            tn.right = new TreeNode(Integer.parseInt(dataArr[2]));
            l1.add(tn.right);
        }
        
        int idx = 3;
        
        // considering 2 levels at a time and storing them in separate lists.
        // not storing nulls (#) and calculating the total size based on non-null values.
        while (true) {
            int total = l1.size() * 2;
            int i = 1;
            //System.out.println("total = " + total);
            while (i <= total && idx < dataArr.length) {
                if (!dataArr[idx].equals("#")) {
                    int parent = (int) (Math.ceil(i / 2d) - 1d);
                    //System.out.println("i = " + i + ", Parent = " + l1.get(parent).val + " and child = " + dataArr[idx]);
                    TreeNode tn1 = new TreeNode(Integer.parseInt(dataArr[idx]));
                    l2.add(tn1);
                    if (i % 2 != 0) {
                        l1.get(parent).left = tn1;
                    } else {
                        l1.get(parent).right = tn1;
                    }                    
                }
                i++; idx++;
            }
            
            if (idx >= dataArr.length) {
                break;
            }
            
            l1 = l2;
            l2 = new ArrayList<>();
            
        }
        return tn;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
