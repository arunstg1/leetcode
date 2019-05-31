class ShortestDistanceToACharacter {
    public int[] shortestToChar(String S, char C) {
        
        int[] finalResult = new int[S.length()];
        
        /*for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] == C) {
                cOcc.add(i);
            }
        }
        
        int cOccIdx = 0;
        
        for (int i = 0; i < sArr.length; i++) {
            if (i < cOcc.get(cOccIdx)) {
                finalResult[i] = cOcc.get(cOccIdx) - i;
                continue;
            }
            if (cOccIdx == cOcc.size() - 1) {
                finalResult[i] = i - cOcc.get(cOccIdx);
                continue;
            }
            
            cOccIdx = (i - cOcc.get(cOccIdx)) <= (cOcc.get(cOccIdx + 1) - i) ? cOccIdx : cOccIdx + 1;
            finalResult[i] = Math.abs(i - cOcc.get(cOccIdx));
        }*/
        
        int n = S.length();
        int pos = -n;
        
        for (int i = 0; i < n; i++) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            finalResult[i] = i - pos;
        }
        pos = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                pos = i;
            }
            finalResult[i] = Math.min(finalResult[i], Math.abs(pos - i));
        }
        
        return finalResult;
        
    }
}
