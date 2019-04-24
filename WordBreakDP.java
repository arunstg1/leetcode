class WordBreakDP {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        char[] chArray = s.toCharArray();
        boolean[][] arr = new boolean[s.length()][s.length()];
        Set<String> alreadyFound = new HashSet<>();
        
        for (int l = 0; l < s.length(); l++) {
            for (int i = 0; i < s.length() - l; i++) {
                int j = i + l;
                String substring = s.substring(i, j + 1);
                if (dict.contains(substring) || alreadyFound.contains(substring)) {
                    arr[i][j] = true;
                }
                if (substring.length() > 1) {
                    for (int k = i + 1; k <= j; k++) {
                        // System.out.println("Entering partition");
                        if (arr[i][k - 1] && arr[k][j]) {
                            arr[i][j] = true;
                            alreadyFound.add(substring);
                        }
                    }
                }
            }
        }
        
        /*for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }*/
        
        return arr[0][s.length() - 1];
    }
}
