class Solution {
    public String lastSubstring(String s) {
        char[] arr = s.toCharArray();
        int left = 0; // left pointer
        int right = 1; // right pointer
        while (right < arr.length){
            if (arr[left] < arr[right]) {
                left = right++;
            } else if (arr[left] > arr[right]){
                right++;
            } else {
                int len = 1;
                while (right + len < arr.length && arr[left + len] == arr[right + len]){
                    len++;
                }
                if (right + len == arr.length) return s.substring(left);
                if (arr[left + len] > arr[right + len]) right += len + 1;
                else if (arr[left] < arr[right + len]){
                    left = right + len;
                    right += len + 1;
                } else {
                    left = right++;
                }
            }
        }
        return s.substring(left);
    }
}
