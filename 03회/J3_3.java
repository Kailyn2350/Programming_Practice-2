// Scannerクラスを使用するため
import java.util.Scanner;

public class J3_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer("横浜学部学EP");
		
		System.out.println("文字列1入力してください："); //input first string
		String str1 = scanner.nextLine(); //using scanner save string to str1
		
		System.out.println("文字列2を入力してください："); //input second string
		String str2 = scanner.nextLine(); //using scanner save string to str2
		
		sb.insert(2, str1); //inser str1 in sb second index
		sb.insert(sb.indexOf("学") + 1, str2); //inser str2 in sb after 学
		
		System.out.println("完成した文字列：" + sb.toString()); //print complete string
		System.out.println("文字数：" + sb.length()); //print number of word
		System.out.println("容量：" + sb.capacity()); //capacity
		
		scanner.close();
	}
}
