class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        int rightPointer = 0, leftPointer = 0, maxSubstringLength = 0, maxCharFrequency = 0;
        
        while (rightPointer < s.length()) {
            char currentRightChar = s.charAt(rightPointer);
            charFrequencyMap.put(currentRightChar, charFrequencyMap.getOrDefault(currentRightChar, 0) + 1);
            maxCharFrequency = Math.max(maxCharFrequency, charFrequencyMap.get(currentRightChar));
            
            int windowSizeWithoutMaxChar = rightPointer - leftPointer - maxCharFrequency + 1;
            if (windowSizeWithoutMaxChar > k) {
                char currentLeftChar = s.charAt(leftPointer);
                charFrequencyMap.put(currentLeftChar, charFrequencyMap.get(currentLeftChar) - 1);
                leftPointer++;
            }
            
            maxSubstringLength = Math.max(maxSubstringLength, rightPointer - leftPointer + 1);
            rightPointer++;
        }
        
        return maxSubstringLength;
    }
}
