class Solution {
    public boolean isAnagram(String s, String t) {
        int countS[] = new int[26];
        for(char c : s.toCharArray()){
            countS[c - 'a']++;
        }
        for(char c : t.toCharArray()){
             countS[c - 'a']--;
        }
        for(int idx = 0; idx < 26; idx++){
            if(countS[idx] != 0)
                return false;
        }
        return true;
    }
}
