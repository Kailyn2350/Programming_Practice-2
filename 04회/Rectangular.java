
public class Rectangular {
    private double length;
    private double width;

    // Initialize with two value (includes a negative value to cause an error)
    public Rectangular(double length, double width) {
        if (length < 0 || width < 0) {
            throw new IllegalArgumentException("Please input non-negative value.");
        }
        this.length = length;
        this.width = width;
    }

    // Initialize with one vluae and set width to 10(negative value causes error)
    public Rectangular(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Please input non-negative value.");
        }
        this.length = length;
        this.width = 10;
    }

    // Get Vertical Length
    public double getLength() {
        return length;
    }

    // Get Horizontal Length
    public double getWidth() {
        return width;
    }

    // Calculate area
    public double getArea() {
        return length * width;
    }

    public static void main(String[] args) {
        try {
            Rectangular rect1 = new Rectangular(5, 8);
            Rectangular rect2 = new Rectangular(-6); // error test
            System.out.println("Rectangle 1: Length = " + rect1.getLength() + ", Width = " + rect1.getWidth() + ", Area = " + rect1.getArea());
            System.out.println("Rectangle 2: Length = " + rect2.getLength() + ", Width = " + rect2.getWidth() + ", Area = " + rect2.getArea());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
