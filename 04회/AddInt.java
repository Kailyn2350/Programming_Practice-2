
public class AddInt {
    // Instance variable n
    private int n;

    // Initialization constructor n
    public AddInt(int n) {
        this.n = n;
    }

    // method return n
    public int getN() {
        return n;
    }

    // n + num method
    public int add(int num) {
        n += num;
        return n;
    }

    // Override
    public static int add(int a, int b) {
        return a + b;
    }

}
