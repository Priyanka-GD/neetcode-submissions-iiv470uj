class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tWindowMap = new HashMap<>();
        Map<Character, Integer> sWindowMap = new HashMap<>();
        for(char ch : t.toCharArray()){
            tWindowMap.put(ch, tWindowMap.getOrDefault(ch, 0) + 1);
        }

        int requiredCount = tWindowMap.size();
        int result[] = {0, 0, -1};
        int formedWord = 0, right = 0, left = 0;

        while(right < s.length()){
            char rightChar = s.charAt(right);
            sWindowMap.put(rightChar, sWindowMap.getOrDefault(rightChar, 0) + 1);

            if(tWindowMap.containsKey(rightChar) 
                && tWindowMap.get(rightChar).intValue() == sWindowMap.get(rightChar).intValue()){
                formedWord++;
            }

            while(left <= right && formedWord == requiredCount){
                if(result[2] == -1 || (right - left + 1) < result[2]){
                    result[0] = left;
                    result[1] = right;
                    result[2] = right - left + 1;
                }
                char leftChar = s.charAt(left);
                sWindowMap.put(leftChar, sWindowMap.get(leftChar) - 1);
                if(tWindowMap.containsKey(leftChar) 
                    && sWindowMap.get(leftChar).intValue() < tWindowMap.get(leftChar).intValue()){
                    formedWord--;
                }
                left++;
            }
            right++;
        }
        return result[2] == -1 ? "" : s.substring(result[0], result[1] + 1);
    }
}
