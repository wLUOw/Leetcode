class Solution {
    public int maxValueAfterReverse(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.abs(nums[0] - nums[1]);
        int base = 0;
        int hi = 0;
        int lo = Integer.MAX_VALUE;
        int leD = 0;
        int riD = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            base += Math.abs(nums[i] - nums[i + 1]);
            int d = Math.max(nums[i], nums[i + 1]);
            if (d < lo){
                lo = d;
            }
            d = Math.min(nums[i], nums[i + 1]);
            if (d > hi){
                hi = d;
            }

            d = Math.abs(nums[i + 1] - nums[0]) - Math.abs(nums[i + 1] - nums[i]);
            if (d > leD) leD = d;
            d = Math.abs(nums[nums.length - 1] - nums[i]) - Math.abs(nums[i + 1] - nums[i]);
            if (d > riD) riD = d;
        }
        if (hi <= lo && leD <= 0 && riD <= 0) return base;
        else return base + Math.max(2 * (hi - lo), Math.max(leD, riD));
    }
}