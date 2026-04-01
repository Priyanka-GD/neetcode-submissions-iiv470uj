class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int mid = s.length() / 2;

        for(int left = 0, right = s.length() - 1;
            left < mid && right >= mid; left++, right--){
                if(s.charAt(left) != s.charAt(right))
                    return false;
        }
        return true;
    }
}
