class Solution {
    public int countTime(String time) {
        int cnt = 1;

        if (time.charAt(0) == '?' && time.charAt(1) == '?') {
            cnt *= 24;
        } else if (time.charAt(0) == '?') {
            if (Integer.parseInt(time.charAt(1) + "") >= 4) cnt *= 2;
            else cnt *= 3;
        } else if (time.charAt(1) == '?') {
            if (Integer.parseInt(time.charAt(0) + "") == 2) cnt *= 4;
            else cnt *= 10;
        }

        if (time.charAt(3) == '?' && time.charAt(4) == '?') {
            cnt *= 60;
        } else if (time.charAt(3) == '?') {
            cnt *= 6;
        } else if (time.charAt(4) == '?') {
            cnt *= 10;
        }

        return cnt;
    }
}
