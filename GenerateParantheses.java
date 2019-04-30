class GenerateParantheses {
    List<String> l = new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        generateParenthesis("", n, n);
        return l;
    }
    
    private void generateParenthesis(String str, int openCount, int closeCount) {
        if (openCount == 0 && closeCount == 0) {
            l.add(str);
            return;
        }
        if (openCount > 0) {
            generateParenthesis(str + "(", openCount - 1, closeCount);
        }
        if (closeCount > 0 && openCount < closeCount) {
            generateParenthesis(str + ")", openCount, closeCount - 1);
        }
    }
    
}
