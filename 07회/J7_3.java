import java.util.Scanner;

class BankAccount {
    private int balance = 0; // 残額変数

    public void deposit(int amount) { // 預入のメソッド
        if (amount <= 0) { // 例外処理（預入金額が０または負）
            throw new IllegalArgumentException("預入金額が０または負です");
        }
        balance += amount;
    }

    public void withdraw(int amount) { // 引出のメソッド
        if (amount <= 0) { // 例外処理
            throw new IllegalArgumentException("引出金額が０または負です");
        }
        if (amount > balance) { // 例外処理
            throw new IllegalArgumentException("残高不足の為引出出来ません");
        }
        balance -= amount;
    }

    public int getBalance() { // 現在の残額を返還
        return balance;
    }
}

class J7_3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(); // インスタンス生成
        Scanner scanner = new Scanner(System.in);
        String command; // 入力される命令語を入れる変数

        while (true) {
            System.out.println("預入 d: 引出 w: 残高照会 g: 終了 e");
            command = scanner.nextLine();
            if (command.equals("e")) {
                System.out.println("取引終了");
                break;
            }

            try {
                switch (command) {
                    case "d": // 預入の場合
                        System.out.println("預入金額を入力");
                        int depositAmount = scanner.nextInt();
                        scanner.nextLine(); // 入力バッファーに残ってる改行文字を消す。
                        account.deposit(depositAmount);
                        System.out.println("残高:" + account.getBalance());
                        break;
                    case "w": // 引出の場合
                        System.out.println("引出金額を入力");
                        int withdrawAmount = scanner.nextInt();
                        scanner.nextLine(); // 入力バッファーに残ってる改行文字を消す。
                        account.withdraw(withdrawAmount);
                        System.out.println("残高:" + account.getBalance());
                        break;
                    case "g":
                        System.out.println("残高:" + account.getBalance());
                        break;
                    default:
                        System.out.println("無効なコマンドです");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.out.println("int型を入力してください");
                scanner.nextLine(); // 入力バッファーに残ってる改行文字を消す。
            }
        }
    }
}
