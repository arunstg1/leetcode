class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        
        for (String w : words) {
            if (!map.containsKey(w)) {
                map.put(w, 0);
            }
            map.put(w, map.get(w) + 1);
        }
        
        PriorityQueue<Data> pq = new PriorityQueue<>();
        
        for (String w : map.keySet()) {
            Data d = new Data(map.get(w), w);
            pq.offer(d);
            if (pq.size() > k) {
                Data d1 = pq.poll();
            }
        }
        
        List<String> returnList = new ArrayList<>();
        
        while (pq.size() > 0) {
            returnList.add(pq.poll().word);
        }
        
        Collections.reverse(returnList);
        return returnList;
    }
}

class Data implements Comparable<Data> {
    public int count;
    public String word;
    
    public Data(int count, String word) {
        this.count = count;
        this.word = word;
    }
    
    @Override
    public int compareTo(Data d) {
        int val = this.count - d.count;
        if (val == 0) {
            return d.word.compareTo(this.word);
        }
        return val;
    }
}
