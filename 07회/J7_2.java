import java.util.Scanner;

class J7_2 {
    public static void main(String[] args) {
        int n = 0;
        boolean valid = false; // 入力値が有効であるか確認する変数

        while (!valid) { //有効な入力値が入るまで繰り返す
            try {
                n = Integer.parseInt(args[0]); // コマンド引数をint型に変換
                System.out.println(n);// 変換された整数を出力
                valid = true;
            } catch (ArrayIndexOutOfBoundsException e) { // args[0]が存在しない場合
                System.out.println(e);
                System.out.println("引数がありません");
                args = new String[]{readInput("int型を入力してください:")};
            } catch (NumberFormatException e) { // args[0]の値が整数に変換できない文字列の場合
                System.out.println(e);
                System.out.println("int型ではありません");
                args = new String[]{readInput("int型を入力してください:")};
            }
        }
    }

    private static String readInput(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
