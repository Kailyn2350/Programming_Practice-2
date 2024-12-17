
public class J3_1 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("整数を１つ入力してください。"); //変数がない場合
			return;
		}
		try {
			int number = Integer.parseInt(args[0]);
			System.out.println("2進数: " + Integer.toBinaryString(number)); //2進数の出力
			System.out.println("16進数: " + Integer.toHexString(number)); //16進数の出力
		} catch (NumberFormatException e) {
			System.out.println("有効な整数を入力してください。"); //正数ではない場合
		}
	}
}
