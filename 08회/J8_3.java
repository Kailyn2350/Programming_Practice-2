class Board {
    private char[][] board;
    int size;

    // コンストラクタでボードのサイズを指定
    public Board(int size) {
        this.size = size;
        this.board = new char[size][size];
    }

    // ボードのクリア
    public synchronized void clear() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // ボードの出力
    public synchronized void print() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // ボードに記号を置く
    public synchronized boolean put(int i, int j, char c) {
        if (board[i][j] == ' ') {
            board[i][j] = c;
            return true;
        }
        return false;
    }

}

//Runnableインタフェースを実装
class Computer implements Runnable {
    private char symbol;
    private int count = 0;
    private Board board;
    
    // コンストラクタで、記号とBoardを与える。
    public Computer(char symbol, Board board) {
        this.symbol = symbol;
        this.board = board;
    }

    @Override
    public void run() {
        int attempts = 0;
        // １００回以下試みた場合
        while (attempts < 100) {
            int i = (int) (Math.random() * board.size);
            int j = (int) (Math.random() * board.size);
            if (board.put(i, j, symbol)) {
                count++;
                attempts = 0;
            } else {
                attempts++;
            }
        }
    }

    public int getCount() {
        return count;
    }
}

public class J8_3 {
    public static void main(String[] args) throws InterruptedException {
        int size = 5;  // マスのサイズ
        Board board = new Board(size);
        board.clear();

        Computer computer1 = new Computer('①', board);
        Computer computer2 = new Computer('②', board);
        Computer computer3 = new Computer('③', board);

        Thread t1 = new Thread(computer1);
        Thread t2 = new Thread(computer2);
        Thread t3 = new Thread(computer3);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        board.print();

        System.out.println("Thread1: " + computer1.getCount());
        System.out.println("Thread2: " + computer2.getCount());
        System.out.println("Thread3: " + computer3.getCount());
        
        // 合計を計算して表示
        int total = computer1.getCount() + computer2.getCount() + computer3.getCount();
        System.out.println("合計: " + total);
    }
}
