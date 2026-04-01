class Solution {
    public boolean isAnagram(String s, String t) {
        int[] countS = new int[26];
        int[] countT = new int[26];

        for(char ch : s.toCharArray()){
            countS[ch -'a']++;
        }
        for(char ch : t.toCharArray()){
            countT[ch - 'a']++;
        }
        for(int idx = 0; idx < 26; idx++){
            if(countT[idx] != countS[idx])
                return false;
        }
        return true;
    }
}
