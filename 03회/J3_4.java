
public class J3_4 {
    public static void main(String[] args) {

        int[][] a = { {1, 2}, {3, 4} }; //matrix a
        int[][] b = new int[3][4]; //matrix b

        copyArray(a, b); //copy matrix

        System.out.println("a[][]"); //print matrix a
        printArray(a);
        System.out.println("b[][]"); //print matrix b
        printArray(b);
    }

    public static void copyArray(int[][] a, int[][] b) { //method to copy a matrix to b
        for (int i = 0; i < a.length; i++) {
            System.arraycopy(a[i], 0, b[i + 1], 1, a[i].length); // partial copy by using System.arraycopy
        }
    }

    public static void printArray(int[][] array) { //method to print matrix
        for (int[] row : array) {
            for (int num : row) {
                System.out.printf("%3d", num);
            }
            System.out.println();
        }
    }
}
