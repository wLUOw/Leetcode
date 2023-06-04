class Solution_2 {
    public int semiOrderedPermutation(int[] nums) {
        int p = -1;
        int q = -1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) p = i;
            if (nums[i] == n) q = i;
        }
        if (p < q) return p + n - q - 1;
        else return p + n - q - 2;
    }
}
