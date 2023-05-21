class Solution_2 {
    public String makeSmallestPalindrome(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j){
            if (chars[i] > chars[j]) {
                chars[i] = chars[j];
            } else if (chars[i] < chars[j]) {
                chars[j] = chars[i];
            }
            i++;
            j--;
        }
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < chars.length; k++) {
            sb.append(chars[k]);
        }
        return sb.toString();
    }
}
