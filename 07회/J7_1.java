import java.util.Scanner;

class J7_1 {
    public static void main(String[] args) {
        a();// 静的メソッドa()を呼び出す。
        System.out.println("main:終了");
    }

    public static void a() {
        b();// 静的メソッドb()を呼び出す。
    }

    public static void b() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("2つの整数を入力してください:");
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(n / m);
        } catch (ArithmeticException e) { // 例外処理
//            e.printStackTrace();
//             System.out.println(e);
//             System.out.println(e.getMessage());
             System.out.println("0で割っています");
        } finally {
            System.out.println("b: finally");
        }
    }
}