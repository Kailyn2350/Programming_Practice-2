
public class Strcov {
    // Static variable END
    public static final String END = "Goodbye";

    // Method for converting character string to upper and lower case
    public static String toULCase(String input) {
        if (Character.isUpperCase(input.charAt(0))) {
            return input.toUpperCase();
        } else if (Character.isLowerCase(input.charAt(0))) {
            return input.toLowerCase();
        } else {
            return input;
        }
    }

    public static void main(String[] args) {
        // View command-line argument conversion results
        for (String arg : args) {
            System.out.print(toULCase(arg) + " ");
        }
        System.out.println("\n" + END);
    }
}
