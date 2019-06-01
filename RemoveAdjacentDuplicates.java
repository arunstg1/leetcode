class RemoveAdjacentDuplicates {
    public String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (i == -1 || arr[i] != arr[j]) {
                arr[++i] = arr[j];
            } else {
                i--;
            }
        }
        return new String(arr, 0, i + 1);
    }
}
