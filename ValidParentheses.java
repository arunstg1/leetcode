class ValidParentheses {
    public boolean isValid(String s) {
        char[] arr = s.toCharArray();
        
        Stack<Character> st = new Stack();
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{' ) {
                st.push(arr[i]);
            } else {
                if (st.size() == 0) {
                    return false;
                }
                Character ch = st.peek();
                if (arr[i] == ')') {
                    if (ch == '(') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if (arr[i] == ']') {
                    if (ch == '[') {
                        st.pop();
                    } else {
                        return false;
                    }
                } else if (arr[i] == '}') {
                    if (ch == '{') {
                        st.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return st.size() == 0;
    }
}
