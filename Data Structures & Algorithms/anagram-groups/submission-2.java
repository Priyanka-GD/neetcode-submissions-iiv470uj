class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
       for(String str : strs){
            char ch[] = str.toCharArray();
            Arrays.sort(ch);
            String strVal = String.valueOf(ch);
            map.putIfAbsent(strVal, new ArrayList<>());
            map.get(strVal).add(str);
        }
        return new ArrayList<>(map.values()); 
    }
}