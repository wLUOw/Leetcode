import java.util.TreeSet;

class DinnerPlates {
    int[][] stacks;
    int cap;
    int maxNum;
    int last;
    TreeSet<Integer> notFull;

    public DinnerPlates(int capacity) {
        cap = capacity;
        maxNum = 200000 / capacity + 1;
        stacks = new int[maxNum][capacity + 1];
        last = -1;
        notFull = new TreeSet<>();
    }

    public void push(int val) {
        if (notFull.isEmpty()){
            last++;
            stacks[last][0]++;
            stacks[last][1] = val;
            if (cap > 1) notFull.add(last);
        } else {
            int minIndex = notFull.first();
            stacks[minIndex][0]++;
            stacks[minIndex][stacks[minIndex][0]] = val;
            if (stacks[minIndex][0] == cap){
                notFull.pollFirst();
            }
        }
    }

    public int pop() {
        if (last < 0) return -1;
        return popAtStack(last);
    }

    public int popAtStack(int index) {
        if (index > last || stacks[index][0] == 0) return -1;
        else {
            int res = stacks[index][stacks[index][0]];
            stacks[index][stacks[index][0]--] = 0;
            if (index == last){  // is the last stack
                if (stacks[last][0] == 0){  // last stack become empty
                    boolean b = true;
                    while (b){
                        notFull.remove(last);
                        last--;
                        if (last < 0 || stacks[last][0] != 0) b = false;
                    }
                }
                if (last >= 0) notFull.add(last);
            } else {
                notFull.add(index);
            }
            return res;
        }
    }

    public void print(){
        System.out.println("-------------");
        for (int i = 0; i < last + 1; i++) {
            for (int j = 0; j < stacks[0].length; j++) {
                System.out.print(stacks[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("last " + last);
        //System.out.println(notFull.contains(0));
        System.out.println("-------------");
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
