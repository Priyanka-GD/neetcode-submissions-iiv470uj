class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // Count frequencies of each character (a-z)
            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            // Build a unique string key based on the frequencies
            // Example: "eat" becomes "1#0#0#0#1#...#1#...0"
            StringBuilder sb = new StringBuilder();
            for (int val : count) {
                sb.append(val);
                sb.append('#'); // Separator ensures counts don't bleed together (e.g., 1 and 11)
            }
            String key = sb.toString();

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
