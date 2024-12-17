import java.util.Random;

abstract class Board {
    static char[][] board = new char[3][3];

    static void clear() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '〇';
            }
        }
    }

    static void print() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
        }
        System.out.println();
    }

    abstract void put();
}

class Computer extends Board {
    private char symbol;

    Computer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    void put() {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (board[row][col] == '〇') {
                board[row][col] = symbol;
                break;
            }
        }
    }
}

class J5_4 {
    public static void main(String[] args) {
        Board.clear();
        Board.print();

        Computer player1 = new Computer('①');
        Computer player2 = new Computer('②');
        Computer player3 = new Computer('③');

        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) player1.put();
            else if (i % 3 == 1) player2.put();
            else player3.put();
            Board.print();
        }
    }
}
