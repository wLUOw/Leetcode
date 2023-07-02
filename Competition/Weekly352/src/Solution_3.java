class Solution_3 {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;
        int le = 0, ri = 2;
        int max = Math.max(nums[0], nums[1]), min = Math.min(nums[0], nums[1]);
        int iMax = -1, iMin = -1;
        if (nums[0] == nums[1]) {
            iMax = 1;
            iMin = 1;
        } else {
            iMax = max == nums[0] ? 0 : 1;
            iMin = iMax == 0 ? 1 : 0;
        }
        long ans = max - min <= 2 ? 3 : 2;
        if (n == 2) return ans;
        for (; ri < n; ri++) {
            if (nums[ri] > max + 2 || nums[ri] < min - 2) {
                le = ri;
            } else if (nums[ri] == max + 2) {
                if (iMax == ri - 1) le = ri - 1;
                else le = ri;
            } else if (nums[ri] == min - 2) {
                if (iMin == ri - 1) le = ri - 1;
                else le = ri;
            } else if (nums[ri] == max) {
                iMax = ri;
            } else if (nums[ri] == min) {
                iMin = ri;
            } else if (nums[ri] == max + 1) {
                boolean b = true;
                for (int i = ri - 1; i >= le; i--) {
                    if (nums[i] == min + 1) {
                        min++;
                        iMin = i;
                        b = false;
                        break;
                    }
                }
                if (b) {
                    min += 2;
                    iMin = iMax;
                }
                max++;
                iMax = ri;
            } else if (nums[ri] == min - 1) {
                boolean b = true;
                for (int i = ri - 1; i >= le; i--) {
                    if (nums[i] == max - 1) {
                        max--;
                        iMax = i;
                        b = false;
                        break;
                    }
                }
                if (b) {
                    max -= 2;
                    iMax = iMin;
                }
                min--;
                iMin = ri;
            }
            ans += ri - le + 1;
        }
        return ans;
    }
}
