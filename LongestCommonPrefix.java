class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int position = 0;
        StringBuilder sb = new StringBuilder();
        
        int smallestStrLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].length() < smallestStrLength) {
                smallestStrLength = strs[i].length();
            }
        }
        
        while (strs.length > 0 && position < smallestStrLength) {
            char ch = strs[0].charAt(position);
            boolean canAdd = true;
            for (int i = 1; i < strs.length; i++) {
                if (ch != strs[i].charAt(position)) {
                    canAdd = false;
                    break;
                }
            }
            if (canAdd) {
                sb.append(ch);
            } else {
                break;
            }
            position++;
        }
        return sb.toString();
    }
}
