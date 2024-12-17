class Producer extends Thread {
    Queue queue;
    int currentValue = 0; // データをAddする際値を維持するための変数

    Producer(Queue queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                // Queueが空になる場合だけデータを追加
                currentValue = queue.addWhenEmpty(currentValue);
                Thread.sleep(1000); // Producer速度1秒制御
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer extends Thread {
    String str;
    Queue queue;

    Consumer(String str, Queue queue) {
        this.str = str;
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(str + ": " + queue.remove());
                Thread.sleep(1000); // Consumer速度1秒制御
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Queue {
    private final static int SIZE = 10;
    int array[] = new int[SIZE];
    int count = 0; // Queueに入っているデータの数

    synchronized int addWhenEmpty(int startValue) {
        while (count != 0) { // Queueが空ではないとき待機
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(0);
            }
        }

        // Queueに数を入れる
        for (int j = 0; j < SIZE; j++) {
            array[j] = startValue++;
            count++;
        }
        notifyAll(); // Queueが一杯になるとConsumerを起こす。
        return startValue; // 次追加するときの値を返す。
    }

    synchronized int remove() {
        while (count == 0) { // Queueが空の場合待機
            try {
                wait();
            } catch (InterruptedException ie) {
                ie.printStackTrace();
                System.exit(0);
            }
        }

        int element = array[--count]; // Queueの後ろ空データを削除（LIFO）
        if (count == 0) { // Queueが空になるとProducerを起こす。
            notifyAll();
        }
        return element;
    }
}

class J8_4 {
    public static void main(String args[]) {
        Queue queue = new Queue();
        new Producer(queue).start();
        new Consumer("ConsumerA", queue).start();
        new Consumer("ConsumerB", queue).start();
        new Consumer("ConsumerC", queue).start();
    }
}
