class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        int counter = 0;
        
        char[] mappingHolder = new char[256];
        boolean[] tChars = new boolean[256];
        
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        while (counter < s.length()) {
            // Checking to see if the char array at index is empty
            if (mappingHolder[sArr[counter]] == '\u0000') {
                // The the char at s hasn't been seen but if the one in t has been then it's a problem.
                if (tChars[tArr[counter]]) {
                    return false;
                }
                mappingHolder[sArr[counter]] = tArr[counter];
                tChars[t.charAt(counter)] = true;
            } else {
                if (tArr[counter] != mappingHolder[sArr[counter]]) {
                    return false;
                }
            }
            counter++;
        }
        return true;
    }
}
