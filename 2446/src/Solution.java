class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        return !(cmp(event1[1], event2[0]) < 0 || cmp(event2[1], event1[0]) < 0);
    }

    private int cmp(String time1, String time2) {
        if (Integer.parseInt(time1.substring(0, 2)) != Integer.parseInt(time2.substring(0, 2)))
            return Integer.parseInt(time1.substring(0, 2)) - Integer.parseInt(time2.substring(0, 2));
        else return Integer.parseInt(time1.substring(3, 5)) - Integer.parseInt(time2.substring(3, 5));
    }
}