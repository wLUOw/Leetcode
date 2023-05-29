class Solution {
    public int averageValue(int[] nums) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] % 6 == 0 ? nums[i] : 0;
            cnt += nums[i] % 6 == 0 ? 1 : 0;
        }
        return cnt == 0 ? 0 : sum / cnt;
    }
}

