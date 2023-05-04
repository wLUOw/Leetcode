class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1];
        int maxId = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            if (logs[i][1] - logs[i - 1][1] > maxTime){
                maxTime = logs[i][1] - logs[i - 1][1];
                maxId = logs[i][0];
            } else if (logs[i][1] - logs[i - 1][1] == maxTime && logs[i][0] < maxId){
                maxId = logs[i][0];
            }
        }
        return maxId;
    }
}