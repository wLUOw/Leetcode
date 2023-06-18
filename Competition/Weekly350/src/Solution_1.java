class Solution_1 {
    public static void main(String[] args) {
        System.out.println(new Solution_1().distanceTraveled(9, 1));
    }
    public int distanceTraveled(int mainTank, int additionalTank) {
        int cnt = 0;
        int mile = 0;
        while (true) {
            if (mainTank == 0) break;
            mainTank--;
            mile += 10;
            cnt++;
            if (cnt == 5 && additionalTank > 0) {
                cnt -= 5;
                mainTank++;
                additionalTank--;
            }
        }
        return mile;
    }
}
