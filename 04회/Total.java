
public class Total {
    // Static method for obtaining the total sum of the tests
    public static int total(Test[] tests) {
        int sumTotal = 0;
        for (Test test : tests) {
            sumTotal += test.getSum();
        }
        return sumTotal;
    }
}
