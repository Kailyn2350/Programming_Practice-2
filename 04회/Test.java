public class Test {
    private int id;
    private int japanese;
    private int english;
    private int math;
    private int totalScore;

    // Constructor
    public Test(int id, int japanese, int english, int math) {
        this.id = id;
        this.japanese = japanese;
        this.english = english;
        this.math = math;
        this.totalScore = sum();
    }

    // Calculate the total score of the three subjects
    public int sum() {
        return japanese + english + math;
    }

    // Get total points
    public int getSum() {
        return totalScore;
    }

    // Calculate the average score of three subjects
    public double average() {
        return totalScore / 3.0;
    }

    // Print score
    public void print() {
        System.out.printf("%10d %5d %5d %5d %5d %10.6f%n", id, japanese, english, math, totalScore, average());
    }
}
