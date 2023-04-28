public class Test {
    public static void main(String[] args) {
        /*
        *["DinnerPlates","push","push","popAtStack","pop","push","push","pop","pop"]
        * [[1],[1],[2],[1],[],[1],[2],[],[]]
        * */

        DinnerPlates plates = new DinnerPlates(1);

        plates.push(1);
        plates.push(2);
        plates.print();

        plates.popAtStack(1);
        plates.print();

        plates.pop();
        plates.print();

        plates.push(1);
        plates.push(2);
        plates.print();

        plates.pop();
        plates.print();
        plates.pop();
        plates.print();

    }
}
