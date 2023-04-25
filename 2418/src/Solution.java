import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        ArrayList<People> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            people.add(new People(names[i], heights[i]));
        }
        Collections.sort(people);
        Collections.sort(people, new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return 0;
            }
        });
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = people.remove(0).name;
        }
        return ans;
    }
}

class People implements Comparable<People>{
    String name;
    int height;


    public People(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int compareTo(People o) {
        return o.height - this.height;
    }
}
