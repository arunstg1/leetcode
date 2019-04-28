class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int word1Idx = -1;
        int word2Idx = -1;
        
        boolean idxUpdated = false;
        
        int shortestDist = Integer.MAX_VALUE;
        
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                word1Idx = i;
                idxUpdated = true;
            } else if (word2.equals(words[i])) {
                word2Idx = i;
                idxUpdated = true;
            }
            
            if (idxUpdated && (word1Idx != -1 && word2Idx != -1)) {
                int diff;
                if (word1Idx >= word2Idx) {
                    diff = word1Idx - word2Idx;
                } else {
                    diff = word2Idx - word1Idx;
                }
                
                if (diff < shortestDist) {
                    shortestDist = diff;
                }
            }
            idxUpdated = false;
        }
        
        return shortestDist;       
    }
}
