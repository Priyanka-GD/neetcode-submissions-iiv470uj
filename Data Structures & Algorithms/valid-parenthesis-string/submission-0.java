class Solution {
    public boolean checkValidString(String s) {
        int openBraces = 0, closedBraces = 0, len = s.length() - 1;
        for(int idx = 0; idx <= len; idx++){
            char leftCh = s.charAt(idx);    
            if(leftCh == '(' || leftCh == '*')
                openBraces++;
            else
                openBraces--;
            char rightCh = s.charAt(len - idx);
            if(rightCh == ')' || rightCh == '*')
                closedBraces++;
            else
                closedBraces--;
            if(closedBraces < 0 || openBraces < 0)
                return false;
        }
        return true;
    }
}
