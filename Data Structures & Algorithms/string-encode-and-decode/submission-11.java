class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s : strs) {
            str.append(s.length()).append("#").append(s);
        }
        return str.toString();
    }
    
    /*In Java, strings are immutable (unchangeable). 
    When you call str.substring(), Java cannot just modify the existing 
    string or give you a cheap pointer. It is forced to allocate a brand new 
    String object and physically copy the characters one by one from the old string into the new one.*/

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int idx = 0;
        
        while (idx < str.length()) {
            // Search for '#' starting ONLY from the current index
            int splitIdx = str.indexOf("#", idx); 
            
            // Extract the length of the upcoming string
            int strLen = Integer.parseInt(str.substring(idx, splitIdx));
            
            // Calculate where the actual string starts and ends
            int startOfWord = splitIdx + 1;
            int endOfWord = startOfWord + strLen;
            
            // Extract the word and add to result
            result.add(str.substring(startOfWord, endOfWord));
            
            // Move our pointer right past the processed word
            idx = endOfWord;
        }
        return result;
    }
}