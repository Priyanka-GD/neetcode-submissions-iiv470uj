class Solution {
     public boolean checkValidString(String s) {
        int leftMin = 0, leftMax = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                leftMin++;
                leftMax++;
            } else if (ch == ')') {
                leftMin = Math.max(leftMin - 1, 0);
                leftMax--;
            } else { // ch == '*'
                leftMin = Math.max(leftMin - 1, 0);
                leftMax++;
            }

            if (leftMax < 0) 
                return false; // Too many `)` to be balanced
        }

        return leftMin == 0;
    }
}
