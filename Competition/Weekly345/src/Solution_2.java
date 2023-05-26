class Solution_2 {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        if (n == 1) return derived[0] == 0;
        int[] arr = new int[n];
        arr[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            if (derived[i] == 0) arr[i + 1] = arr[i];
            if (derived[i] == 1) arr[i + 1] = arr[i] == 0 ? 1 : 0;
        }
        if (arr[n - 1] == arr[0] && derived[n - 1] == 0) return true;
        if (arr[n - 1] != arr[0] && derived[n - 1] == 1) return true;
        return false;
    }
}
