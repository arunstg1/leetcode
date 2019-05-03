class FactorCombination {
    List<List<Integer>> returnList = new ArrayList<>();
    
    public List<List<Integer>> getFactors(int n) {
        if (n == 1) {
            return returnList;
        }
        getFactors(n, n, 2, new ArrayList<Integer>());
        return returnList;
    }
    
    private void getFactors(int n, int goTill, int start, List<Integer> l) {
        if (n == 1) {
            returnList.add(new ArrayList<>(l));
            return;
        }
        for (int i = start; i <= goTill/2 && i <= n; i++) {
            if (n % i == 0) {
                l.add(i);
                getFactors(n/i, goTill, i, l);
                l.remove(l.size() - 1);
            }
        }
    }
}
