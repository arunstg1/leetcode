/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class PopulateRightNode {
    Queue<Node> q = new LinkedList<>();
    
    public Node connect(Node root) {
        if (root == null) {
            return root;
        } 
        
        q.add(root);
        int currSize = 1;
        
        Node returnNode = root;
        
        while (q.size() != 0) {
            
            while (currSize > 0) {
                Node n = q.remove();
                
                Node temp = q.peek();
                if (temp != null && currSize != 1) {
                    n.next = temp;
                }
                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
                currSize--;
            }
            currSize = q.size();
        }
        return returnNode;
    }
}
