class Solution_1 {
    public String removeTrailingZeros(String num) {
        int n = num.length() - 1;
        while (true) {
            if (num.charAt(n) == '0') n--;
            else break;
        }
        return num.substring(0, n + 1).equals("") ? "0" : num.substring(0, n + 1);
    }
}
