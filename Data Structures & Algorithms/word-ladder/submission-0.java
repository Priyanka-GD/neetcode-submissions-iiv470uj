class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> mappedWords = getMappedWords(wordList);

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<String, Integer>(beginWord, 1));

        Set<String> visited = new HashSet<>();

        while(!q.isEmpty()){
            Pair<String, Integer> currPair = q.poll();
            int level = currPair.getValue();
            String currWord = currPair.getKey();

            for(int idx = 0; idx < currWord.length(); idx++){
                String encodedWord = currWord.substring(0, idx) + "*"
                    + currWord.substring(idx + 1);
                for(String nextWord : mappedWords.getOrDefault(encodedWord,
                    new ArrayList<>())){
                        if(!visited.contains(nextWord)){
                            if(endWord.equals(nextWord))
                                return level + 1;
                            visited.add(nextWord);
                            q.add(new Pair<String, Integer>(nextWord, level + 1));
                        }
                    }
            }
        }
        return 0;
    }

    private Map<String, List<String>> getMappedWords(List<String> wordList){
        Map<String, List<String>> mappedWords = new HashMap<>();

        for(String word : wordList){
            for(int idx = 0; idx < word.length(); idx++){
                String encodedWord = word.substring(0, idx) + "*"
                    + word.substring(idx + 1);
                mappedWords.putIfAbsent(encodedWord, new ArrayList<>());
                mappedWords.get(encodedWord).add(word);
            }
        }
        return mappedWords;
    }
}
