class Counter {
    private int count = 0;
    // カウントを1つ増やす
    public synchronized void countUp() {
        count++;
    }
    // 現在のカウント値を取得
    public int getCount() {
        return count;
    }
}

class ThreadX extends Thread {
	// ThreadXクラスで使用するCounterオブジェクトを参照する変数。
	// 色んなスレッドが同じCounterオブジェクトを共有する。
    private Counter counter; 
    
    // コンストラクタからCounterオブジェクトをもらってcounterに割り当てる。
    public ThreadX(Counter counter) {
        this.counter = counter;
    }

    @Override
    // 10,000回実行
    public void run() {
        for (int i = 0; i < 10000; i++) {
            counter.countUp();
        }
    }
}

public class J8_2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        ThreadX thread1 = new ThreadX(counter);
        ThreadX thread2 = new ThreadX(counter);
        ThreadX thread3 = new ThreadX(counter);

        thread1.start();
        thread2.start();
        thread3.start();

        // スレッドの終了を待つ
        thread1.join();
        thread2.join();
        thread3.join();

        System.out.println("Final count: " + counter.getCount()); // 結果確認
    }
}
