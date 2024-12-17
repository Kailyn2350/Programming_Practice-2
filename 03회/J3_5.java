// Scannerクラスを使用するため
import java.util.Scanner;

public class J3_5 {
    public static void main(String[] args) {
        String text = "東京特許許可局許可局長";
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("検索文字列を入力してください: ");
        String target = scanner.nextLine();

        int count = countOccurrences(text, target);
        System.out.println(text);
        System.out.printf("%d個ありました\n", count);
        
        scanner.close();
    }

    public static int countOccurrences(String text, String target) { //method to check how many target exsist in text 
        int count = 0;
        int index = 0;
        
        while ((index = text.indexOf(target, index)) != -1) {
            count++;
            index += target.length();
        }
        
        return count;
    }
}
