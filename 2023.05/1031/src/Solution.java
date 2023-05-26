class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int add = 1;

        int firstMax1 = prefixSum[firstLen];
        int allMax1 = prefixSum[firstLen + secondLen];
        int firstMax2 = prefixSum[secondLen];
        int allMax2 = prefixSum[firstLen + secondLen];

        for (; firstLen + secondLen + add - 1 < n; add++) {
            int tempFirstMax1 = prefixSum[firstLen + add] - prefixSum[add];
            if (tempFirstMax1 > firstMax1){
                firstMax1 = tempFirstMax1;
            }
            int tempAllMax1 = prefixSum[firstLen + secondLen + add] - prefixSum[firstLen + add] + firstMax1;
            allMax1 = Math.max(tempAllMax1, allMax1);

            int tempFirstMax2 = prefixSum[secondLen + add] - prefixSum[add];
            if (tempFirstMax2 > firstMax2){
                firstMax2 = tempFirstMax2;
            }
            int tempAllMax2 = prefixSum[firstLen + secondLen + add] - prefixSum[secondLen + add] + firstMax2;
            allMax2 = Math.max(tempAllMax2, allMax2);
        }

        return Math.max(allMax1, allMax2);
    }
}
