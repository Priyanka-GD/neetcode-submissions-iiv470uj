class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapOfTFreq = new HashMap<>();
        for(char ch : t.toCharArray()){
            mapOfTFreq.put(ch, mapOfTFreq.getOrDefault(ch, 0) + 1);
        }
        Map<Character, Integer> mapOfSFreq = new HashMap<>();
        int right = 0, left = 0, formed = 0, required = mapOfTFreq.size();
        int[] index = {0, 0, -1};
        while(right < s.length()){
            char rCh = s.charAt(right);
            mapOfSFreq.put(rCh, mapOfSFreq.getOrDefault(rCh, 0) + 1);

            if(mapOfTFreq.containsKey(rCh) && mapOfTFreq.get(rCh) == mapOfSFreq.get(rCh)){
                formed++;
            }

            while(left <= right && formed == required){
                if(right - left + 1 < index[2] || index[2] == -1){
                    index[0] = left;
                    index[1] = right;
                    index[2] = right - left + 1;
                }

                char lCh = s.charAt(left);
                mapOfSFreq.put(lCh, mapOfSFreq.get(lCh) - 1);

                if(mapOfTFreq.containsKey(lCh) && mapOfTFreq.get(lCh) > mapOfSFreq.get(lCh)){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return index[2] == -1? "": s.substring(index[0], index[1] + 1);
    }
}
