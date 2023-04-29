import java.util.HashMap;

class Solution {
    public boolean equalFrequency(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        int size = 0;
        for (char i = 'a'; i < 'z' + 1; i++) {
            map.put(i, 0);
        }
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            map.put(c, map.get(c) + 1);
            if (map.get(c) == 1) size++;
        }

        if (size == 1) return true;
        else {
            char c = 'a';
            while (map.get(c) == 0){
                c++;
            }
            int num1 = map.get(c++);
            //System.out.println("num1 " + num1 + " char " + c);
            while (map.get(c) == 0){
                c++;
            }
            int num2 = map.get(c++);
            //System.out.println("num2 " + num2 + " char " + c);
            if (Math.abs(num1 - num2) != 1 && num1 != num2 && size != 2 && num1 != 1 && num2 != 1) return false;
            else if (size == 2){
                if (num1 == 1 || num2 == 1) return true;
                return Math.abs(num1 - num2) == 1;
            }
            else {
                int n;
                if (num1 == num2){
                    n = num1;
                    boolean b = true;
                    while (c <= 'z'){
                        while (map.get(c) == 0 && c < 'z'){
                            c++;
                        }
                        int num = map.get(c++);
                        if (b && num - n == 1){
                            b = false;
                        } else if (num != n && num != 0) return false;
                    }
                    if (b && n != 1) return false;
                } else {
                    while (map.get(c) == 0){
                        c++;
                    }
                    int num3 = map.get(c++);
                    if (num3 == num1 || num3 == num2) n = num3;
                    else {
                        return false;
                    }
                    int x;
                    if (num3 == num1) x = num2;
                    else x = num1;
                    if (x - n != 1 && x != 1) return false;
                    while (c <= 'z'){
                        while (map.get(c) == 0 && c < 'z'){
                            c++;
                        }
                        int num = map.get(c++);
                        if (num != n && num != 0 && x != 1 && size != 3) return false;
                    }
                }
                return true;
            }
        }
    }
}
