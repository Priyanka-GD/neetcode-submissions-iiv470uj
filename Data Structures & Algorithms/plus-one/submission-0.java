class Solution {
    public int[] plusOne(int[] digits) {
        StringBuilder stringBuilder = new StringBuilder();
        int idx = digits.length - 1;
        int sum = digits[idx] + 1;
        int carry = sum / 10;
        stringBuilder.append(sum % 10);
        sum = carry;
        idx--;
        while (idx >= 0) {
            sum += digits[idx];
            carry = sum / 10;
            stringBuilder.append(sum % 10);
            sum = carry;
            idx--;
        }
        if(carry == 1)
           stringBuilder.append(carry);     
        stringBuilder = stringBuilder.reverse();
        int result[] = new int[stringBuilder.length()];
        for (int i = 0; i < stringBuilder.length(); i++) {
            result[i] = (int) (stringBuilder.charAt(i) - '0');
        }
        return result;
    }
}
