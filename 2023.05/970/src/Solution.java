import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> list = new ArrayList<>();
        if (bound < 2) return list;
        list.add(2);
        for (int i = 0; i < 21; i++) {
            for (int j = 0; j < 21; j++) {
                if (i == 0 && j == 0) continue;
                int num = (int) (Math.pow(x, i) + Math.pow(y, j));
                boolean b = true;
                for (int k = 0; k < list.size(); k++) {
                    if (num == list.get(k)){
                        b = false;
                        break;
                    }
                }
                if (num > 0 && num <= bound){
                    if (b) list.add(num);
                }
                else break;
            }
        }
        return list;
    }
}