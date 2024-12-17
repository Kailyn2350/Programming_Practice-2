public class J8_1 {
    public static void main(String[] args) {
        Thread addThread = new Thread(new Add()); // Threadである、addThreadを生成。Add作業を実行
        Thread mulThread = new Thread(new Mul()); // Threadである、mulThreadを生成。Mul作業を実行

        addThread.start(); // スレッドの始まり。（Addクラスに定義されている足し算作業開始）
        mulThread.start(); // スレッドの始まり。（Mulクラスに定義されている掛け算作業開始）
    }
}

class Add implements Runnable { // Runnableインタフェースを実装
    @Override
    public void run() { // 足し算の定義
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
            System.out.println("Add=" + sum);
            try {
                Thread.sleep(1000);  // 1秒間待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total Add=" + sum);
    }
}

class Mul implements Runnable { // Runnableインタフェースを実装
    @Override
    public void run() { // 掛け算の定義
        int product = 1;
        for (int i = 1; i <= 10; i++) {
            product *= i;
            System.out.println("Mul=" + product);
            try {
                Thread.sleep(1000);  // 1秒間待機
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total Mul=" + product);
    }
}