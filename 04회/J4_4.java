import java.util.Random;

public class J4_4 {
    // Generate a random number between 0 and 100
    public static int ran() {
        Random random = new Random();
        return random.nextInt(101);
    }

    public static void main(String[] args) {
        // Create test instances for 5people
        Test[] tests = new Test[5];
        for (int i = 0; i < 5; i++) {
            tests[i] = new Test(i + 1, ran(), ran(), ran());
        }

        // Output header
        System.out.printf("%10s %5s %5s %5s %5s %10s%n", "学籍番号", "国語", "英語", "数学", "合計", "平均");
        for (Test test : tests) {
            test.print();
        }

        // Total output of all
        int grandTotal = Total.total(tests);
        System.out.println("総合計" + grandTotal);
    }
}
