class ShortestWordDistanceII {
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            ArrayList<Integer> al = map.get(words[i]);
            al.add(i);
            map.put(words[i], al);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> word1Idx = map.get(word1);
        List<Integer> word2Idx = map.get(word2);
        
        int word1Count = 0, word2Count = 0;
        
        int minDist = Integer.MAX_VALUE;
        
        while (word1Count < word1Idx.size() && word2Count < word2Idx.size()) {
            if (word1Idx.get(word1Count) <= word2Idx.get(word2Count)) {
                int diff = word2Idx.get(word2Count) - word1Idx.get(word1Count);
                if (diff < minDist) {
                    minDist = diff;
                }
                word1Count++;
            } else {
                int diff = word1Idx.get(word1Count) - word2Idx.get(word2Count);
                if (diff < minDist) {
                    minDist = diff;
                }
                word2Count++;
            }
        }
        
        // Below 2 are not technically needed. The min distance would be found within
        // the length of the shorter array.
        while (word1Count < word1Idx.size()) {
            int diff = Math.abs(word1Idx.get(word1Count) - word2Idx.get(word2Idx.size() - 1));
            if (diff < minDist) {
                minDist = diff;
            }
            word1Count++;
        }
        
        while (word2Count < word2Idx.size()) {
            int diff = Math.abs(word2Idx.get(word2Count) - word1Idx.get(word1Idx.size() - 1));
            if (diff < minDist) {
                minDist = diff;
            }
            word2Count++;
        }
        
        return minDist;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
