
public class J3_2 {
	public static void main(String[] args) {
		if(args.length != 3) {
			System.out.println("例：１２＋８");
			return;
		}
		try {
			double num1 = Double.parseDouble(args[0]);
			double num2 = Double.parseDouble(args[2]);
			char operator = args[1].charAt(0);
			
			switch(operator) {
			case '+':
				System.out.println("結果：" + (num1 + num2)); //足し算演算子の場合
				break;
			case '-':
				System.out.println("結果：" + (num1 - num2)); //引き算演算子の場合
				break;
			case 'X':
				System.out.println("結果：" + (num1 * num2)); //掛け算演算子の場合
				break;
			case '/':
				if(num2 != 0) {
					System.out.println("結果：" + (num1 / num2)); //割り算演算子の場合
				}
				else {
					System.out.println("ゼロ以外の数字を入力してください。"); //to prevent the case of dividing by zero 
				}
				break;
			default:
				System.out.println("有効な演算子を入力してください。"); //to prevent case of inputing wrong operator
			}
		}
		catch (NumberFormatException e) {
			System.out.println("有効な数字を入力してください。");
		}
	}
}
