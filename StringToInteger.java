class StringToInteger {
    public int myAtoi(String str) {
        
        if (str == null || str.length() == 0) {
            return 0;
        }
        
        if (str.contains("+-") || str.contains("-+") ||
           str.contains("++") || str.contains("--")) {
            if (str.endsWith("++") || str.endsWith("--")) {
                
            } else {
                return 0;
            }
        }
        
        double returnVal = 0;
        
        char[] charArr = str.toCharArray();
        
        boolean foundNumber = false;
        boolean isNegative = false, isPositive = false;
        
        int startIdx = -1, endIdx = -1;
        
        for (int i = 0; i < str.length(); i++) {
            if (charArr[i] == ' ') {
                if (foundNumber || isNegative || isPositive) {
                    break;
                }
                continue;
            }
            if (charArr[i] >= 'a' && charArr[i] <= 'z') {
                if (!foundNumber) {
                    return 0;
                } else {
                    break;
                }
            }
            if (charArr[i] == '-') {
                if (!foundNumber) {
                    isNegative = true;
                } else {
                    break;
                }
            }
            if (charArr[i] == '+') {
                if (!foundNumber) {
                    isPositive = true;
                } else {
                    break;
                }
            }
            if (charArr[i] >= '0' && charArr[i] <= '9' || charArr[i] == '.') {
                foundNumber = true;
                if (startIdx == -1) {
                    startIdx = i;
                }
                endIdx = i;
            }
        }
        
        if (startIdx == -1) {
            return 0;
        }
        
        boolean itsADot = false;
        for (int i = startIdx; i <= endIdx; i++) {
            if (charArr[i] == '.') {
                itsADot = true;
                continue;
            }
            
            if (itsADot) {
                return (charArr[i] < '5') ? (int) returnVal : (int) returnVal + 1;
            }
            
            returnVal = (returnVal * 10) + (charArr[i] - '0');
        }
        
        if (isNegative) {
            returnVal *= -1;
        }
        
        return (int) returnVal;
        
    }
}
