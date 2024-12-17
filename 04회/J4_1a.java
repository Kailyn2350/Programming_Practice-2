
public class J4_1a {
    public static void main(String[] args) {
        // Generating AddInt instances and test each method.
        AddInt addInt = new AddInt(5);
        System.out.println("Initial n: " + addInt.getN());
        System.out.println("After add(3): " + addInt.add(3));
        System.out.println("Static add(10, 20): " + AddInt.add(10, 20));
    }
}
