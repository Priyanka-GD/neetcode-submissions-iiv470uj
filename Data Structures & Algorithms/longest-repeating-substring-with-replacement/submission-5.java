class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, count = 0, maxFreq = 0;
        while(right < s.length()){
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(rChar));
            int replacableFreq = right - left + 1 - maxFreq;

            if(replacableFreq > k){
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) - 1);
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
