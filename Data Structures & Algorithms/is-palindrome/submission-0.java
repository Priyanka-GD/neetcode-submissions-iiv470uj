class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        int sLength = s.length();
       
       for(int idx1 = sLength - 1, idx2 = 0; 
        idx1 >= 0 && idx2 < sLength; 
        idx1--, idx2++){
            if(s.charAt(idx1) != s.charAt(idx2))
                return false;
       }
       return true;
    }
}
