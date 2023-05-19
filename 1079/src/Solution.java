import java.util.HashSet;
import java.util.Set;

class Solution {
    char[] chars;
    Set<String> strings = new HashSet<>();

    public int numTilePossibilities(String tiles) {
        chars = tiles.toCharArray();
        int n = chars.length;
        boolean[] bools = new boolean[n];
        dfs(bools, "");
        return strings.size();
    }

    private void dfs(boolean[] bools, String s){
        for (int i = 0; i < bools.length; i++) {
            if (!bools[i] && !strings.contains(s + chars[i])) {
                String temp = s + chars[i];
                strings.add(temp);
                boolean[] newBools = bools.clone();
                newBools[i] = true;
                dfs(newBools, temp);
            }
        }
    }
}
