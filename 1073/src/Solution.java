class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int m = Math.max(arr1.length, arr2.length);
        int n = Math.min(arr1.length, arr2.length);
        int[] a1 = arr1.length == m ? arr1 : arr2;
        int[] a2 = a1 == arr1 ? arr2 : arr1;
        
        int[] temp = new int[m + 2];
        for (int i = 0; i < m + 2; i++) {
            if (i < m)
                if (n - 1 - i >= 0)
                    temp[m + 1 - i] += a1[m - 1 - i] + a2[n - 1 - i];
                else
                    temp[m + 1 - i] += a1[m - 1 - i];
            if (temp[m + 1 - i] >= 2) {
                temp[m + 1 - i] -= 2;
                temp[m - i] -= 1;
            } else if (temp[m + 1 - i] == -1) {
                temp[m + 1 - i] = 1;
                temp[m - i] ++;
            }
        }

        int cnt = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == 0) cnt++;
            else break;
        }
        if (cnt == temp.length) return new int[]{0};

        int[] arr = new int[temp.length - cnt];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i + cnt];
        }

        return arr;
    }
}