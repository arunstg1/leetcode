class MaxStack {
    
    Node currNode = null;

    /** initialize your data structure here. */
    public MaxStack() {
        
    }
    
    public void push(int x) {
        Node n = new Node(x, currNode);
        currNode = n;
    }
    
    public int pop() {
        int val = currNode.val;
        currNode = currNode.prev;
        return val;
    }
    
    public int top() {
        return currNode.val;
    }
    
    public int peekMax() {
        return currNode.max;
    }
    
    public int popMax() {
        int currMax = currNode.max;
        Node temp = currNode;
        Node secondary = null;
        while (temp != null) {
            if (temp.val == currMax) {
                pop();
                reAdd(secondary);
                secondary = null;
                break;
            } else {
                Node t1 = new Node(pop(), secondary);
                secondary = t1;
            }
            temp = temp.prev;
        }
        temp = null;
        return currMax;
    }
    
    private void reAdd(Node n) {
        //System.out.println(n);
        while (n != null) {
            push(n.val);
            n = n.prev;
        }
    }
}

class Node {
    public int val, max;
    public Node prev;
    public Node (int val, Node prev) {
        this.val = val;
        this.prev = prev;
        if (prev == null) {
            max = val;
        } else {
            max = (val > prev.max) ? val : prev.max;
        }
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
