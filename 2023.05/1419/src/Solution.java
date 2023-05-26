class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int[] croaks = new int[5];
        int cnt = 0;
        for (int i = 0; i < croakOfFrogs.length(); i++) {
            char c = croakOfFrogs.charAt(i);
            if (c == 'c'){
                if (croaks[4] > 0) croaks[4]--;
                else cnt++;
                croaks[0]++;
            }
            else if (c == 'r'){
                croaks[0]--;
                croaks[1]++;
                if (croaks[0] < 0) return -1;
            }
            else if (c == 'o'){
                croaks[1]--;
                croaks[2]++;
                if (croaks[1] < 0) return -1;
            }
            else if (c == 'a'){
                croaks[2]--;
                croaks[3]++;
                if (croaks[2] < 0) return -1;
            }
            else if (c == 'k'){
                croaks[3]--;
                croaks[4]++;
                if (croaks[3] < 0) return -1;
            }
        }
        if (croaks[0] == 0 && croaks[1] == 0 && croaks[2] == 0 && croaks[3] == 0) return cnt;
        return -1;
    }
}