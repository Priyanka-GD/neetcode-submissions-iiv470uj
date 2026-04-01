class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int idx = 0; idx < strs.length; idx++) {
            char charArr[] = strs[idx].toCharArray(); 
            Arrays.sort(charArr);
            String strVal = String.valueOf(charArr);
            map.putIfAbsent(strVal, new ArrayList<>());
            map.get(strVal).add(strs[idx]);
        }
        List<List<String>> answer = new ArrayList<>(map.values());
        return answer;
    }
}
