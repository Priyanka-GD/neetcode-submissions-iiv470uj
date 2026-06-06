class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tWindow = new HashMap<>();
        for(char ch : t.toCharArray()){
            tWindow.put(ch, tWindow.getOrDefault(ch , 0) + 1);
        }
        Map<Character, Integer> sWindow = new HashMap<>();
        int[] index = new int[]{0, 0, -1};

        int right = 0, left = 0, required = tWindow.size(), formed = 0;

        while(right < s.length()){
            char rChar = s.charAt(right);
            sWindow.put(rChar, sWindow.getOrDefault(rChar , 0) + 1);

            if(tWindow.containsKey(rChar) 
                && tWindow.get(rChar).intValue() == sWindow.get(rChar).intValue()){
                formed++;
            }
            while (left <= right && formed == required) {
                if (index[2] == -1 || right - left + 1 < index[2]) {
                    index[0] = left;
                    index[1] = right;
                    index[2] = right - left + 1;
                }

                char lChar = s.charAt(left);
                sWindow.put(lChar, sWindow.get(lChar) - 1);
                
                if (tWindow.containsKey(lChar) && 
                    sWindow.get(lChar).intValue() < tWindow.get(lChar).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return index[2] != -1? s.substring(index[0], index[1] + 1) : "";
    }
}
