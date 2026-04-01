class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
       for(String str : strs){
        char ch[] = str.toCharArray();
        Arrays.sort(ch);
        StringBuilder s = new StringBuilder(); 
        // 1. Added 'int' declaration for idx
        for(int idx = 0; idx < ch.length; ){ 
            char currCh = ch[idx];
            int count = 1;
            int nextIdx = idx + 1; // 2. Added missing semicolon
            while(nextIdx < ch.length && ch[idx] == ch[nextIdx]){
                count++;
                nextIdx++;
            }
            s.append(currCh).append(count);
            idx = nextIdx; // 3. Logic moves idx forward here
        }
        String newStr = s.toString();
        map.putIfAbsent(newStr, new ArrayList<>());
        map.get(newStr).add(str);
       }
        // 4. Corrected map.values()
        return new ArrayList<>(map.values()); 
    }
}