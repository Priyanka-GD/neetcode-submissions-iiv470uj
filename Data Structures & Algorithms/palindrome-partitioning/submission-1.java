class Solution {
    List<List<String>> answer = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(0, s, new ArrayList<>());
        return answer;
    }

    private boolean isPalindrome(String str) {
        for (int idx1 = str.length() - 1, idx2 = 0; idx1 >= 0 && idx2 < str.length() / 2; idx1--, idx2++) {
            if (str.charAt(idx1) != str.charAt(idx2))
                return false;
        }
        return true;
    }

    private void backtrack(int start, String s, List<String> combination) {
        if (s.length() == start) {
            answer.add(new ArrayList<>(combination));
            return;
        }
        for (int idx = start; idx < s.length(); idx++) {
            String substring = s.substring(start, idx + 1);
            if (isPalindrome(substring)) {
                combination.add(substring);
                backtrack(idx + 1, s, combination);
                combination.remove(combination.size() - 1);
            }
        }
    }
}
