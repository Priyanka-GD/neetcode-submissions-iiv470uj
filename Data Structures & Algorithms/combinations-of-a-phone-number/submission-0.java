class Solution {
    Map<Integer, String> mapOfDigitToNum = Map.of(
    2, "abc", 
    3, "def", 
    4, "ghi", 
    5, "jkl", 
    6, "mno", 
    7, "pqrs", 
    8, "tuv", 
    9, "wxyz"
    );
    String phoneNumber;
    List<String> combinations = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return combinations;
        phoneNumber = digits;
        backtrack(0, new StringBuilder());
        return combinations;
    }

    private void backtrack(int idx, StringBuilder string){
        if(string.length() == phoneNumber.length()){
            combinations.add(string.toString());
            return;
        }
        int digit = phoneNumber.charAt(idx) - '0';
        String alphabets = mapOfDigitToNum.get(digit);
        for(char ch : alphabets.toCharArray()){
            string.append(ch);
            backtrack(idx + 1, string);
            string.deleteCharAt(string.length() - 1);
        }
    }
}
