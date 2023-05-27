class Solution {
    public double[] sampleStats(int[] count) {
        int min = -1;
        int max = 0;
        int cnt = 0;
        long sum = 0;
        int mode = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0 && min == -1) min = i;
            if (count[i] != 0) max = i;
            cnt += count[i];
            sum += (long) count[i] * i;
            if (count[i] > count[mode]) mode = i;
        }
        double mean = (double) sum / cnt;
        double median;
        if (cnt % 2 == 1) {
            int x = 0;
            int index = 0;
            while (x <= cnt / 2) {
                x += count[index++];
            }
            median = index - 1;
        } else {
            int x = 0;
            int index = 0;
            while (x <= cnt / 2) {
                if (x == cnt / 2) {
                    int temp = index;
                     while (true) {
                         if (count[index++] != 0) break;
                     }
                     median = (double) (temp + index) / 2 - 1;
                    return new double[]{min, max, mean, median, mode};
                }
                x += count[index++];
            }
            median = index - 1;
        }
        return new double[]{min, max, mean, median, mode};
    }
}