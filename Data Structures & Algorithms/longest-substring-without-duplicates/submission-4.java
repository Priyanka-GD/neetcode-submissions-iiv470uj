class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charMapWithFreq = new HashMap<>();
        int left = 0, right = 0, maxLen = 0;
        while(right < s.length()){
            char rightChar = s.charAt(right);
            charMapWithFreq.put(rightChar, charMapWithFreq.getOrDefault(rightChar, 0) + 1);

            while(charMapWithFreq.get(rightChar) > 1){
                char leftChar = s.charAt(left);
                charMapWithFreq.put(leftChar, charMapWithFreq.get(leftChar) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}

/*
Key idea: Each pointer moves only forward
right moves from 0 → n−1 → n steps
left also moves from 0 → n−1 → n steps total
Even though the inner while is nested, left never resets or moves backward.
So:
right++ happens n times
left++ happens at most n times
Total operations 𝑛(right moves)+ 𝑛(left moves) = 𝑂(n)
*/
