class Solution {
    public String foreignDictionary(String[] words) {
      /*
         * "hrn"
         * "hrf"
         * 
         * from these two words - comparing char by char n and f are different
         * so, indegree[f] = 1 and n -> f(adj of n is f, implies f comes after n)
         * 
         * "hrf"
         * "er"
         * indegree[e] = 1 and h -> e(adj of h is e, implies e comes after h)
         * 
         * "er"
         * "enn"
         * 
         * indegree[n] = 1 and r -> n(adj of r is n, implies n comes after r)
         * 
         * "enn"
         * "rfnn"
         * 
         * indegree[r] = 1 and e -> r, indegree[f] = 2 and n -> f
         * 
         * From above relation we start with indegree[h] = 0 and check its adj list
         * h -> e -> r -> n -> f
         * Topo sort implementation
         */

        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, List<Character>> adjList = new HashMap<>();

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                inDegree.putIfAbsent(ch, 0);
                adjList.putIfAbsent(ch, new ArrayList<>());
            }
        }

        for (int idx = 0; idx < words.length - 1; idx++) {
            String word1 = words[idx];
            String word2 = words[idx + 1];

            int len1 = word1.length();
            int len2 = word2.length();

            if (len1 > len2 && word1.startsWith(word2))
                return "";

            for (int i = 0; i < Math.min(len1, len2); i++) {
                char ch1 = word1.charAt(i);
                char ch2 = word2.charAt(i);

                if (ch1 != ch2) {
                    inDegree.put(ch2, inDegree.get(ch2) + 1);
                    adjList.get(ch1).add(ch2);
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();
        for (char ch : inDegree.keySet()) {
            if (inDegree.get(ch) == 0)
                q.add(ch);
        }
        StringBuilder stringBuilder = new StringBuilder();

        while (!q.isEmpty()) {
            char currChar = q.poll();
            stringBuilder.append(currChar);

            for (char nextChar : 
                adjList.getOrDefault(currChar, new ArrayList<>())) {
                inDegree.put(nextChar, inDegree.get(nextChar) - 1);
                if (inDegree.get(nextChar) == 0)
                    q.add(nextChar);
            }
        }
        if (stringBuilder.length() < inDegree.size())
            return "";
        return stringBuilder.toString();
    }
}
