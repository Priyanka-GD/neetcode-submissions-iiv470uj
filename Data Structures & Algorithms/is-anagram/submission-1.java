class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int countOfCharsForS[] = new int[26];
        for(char ch : s.toCharArray()){
            countOfCharsForS[ch -'a']++;
        }
        for(char ch : t.toCharArray()){
            if(countOfCharsForS[ch -'a'] > 0)
                countOfCharsForS[ch -'a']--;
            else
                return false;
        }
        return true;
    }
}
