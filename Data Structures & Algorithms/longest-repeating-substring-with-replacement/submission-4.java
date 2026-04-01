class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 0, count = 0, maxCount = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            maxCount = Math.max(maxCount, map.get(ch));
            int window = right - left - maxCount + 1;
            if(window > k){
                char leftCh = s.charAt(left);
                map.put(leftCh, map.get(leftCh) - 1);
                left++;
            }
            count = Math.max(count, right - left + 1);
            right++;
        }
        return count;
    }
}
