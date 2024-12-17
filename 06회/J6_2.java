import java.util.Random;
import java.util.Scanner;

// Jyankenインターフェースを定義
interface Jyanken {
    String[] HANDS = {"グー", "チョキ", "パー"}; // 定数配列
    int play(); // 抽象メソッド（じゃんけんの手を出す）
}

// HumanクラスはJyankenインターフェースを実装
class Human implements Jyanken {
    @Override
    public int play() {
        Scanner scanner = new Scanner(System.in); // キーボード入力
        int input;
        while (true) { // 入力が正しい値になるまで繰り返す
            System.out.println("0:グー 1:チョキ 2:パー"); // 指示を出力
            input = scanner.nextInt();
            if (input >= 0 && input <= 2) { // 入力が0, 1, 2の場合ループを抜ける
                break;
            } else {
                System.out.println("0か1か2の中で入力してください。"); // エラーメッセージ
            }
        }
        return input;
    }
}

// ComputerクラスはJyankenインターフェースを実装
class Computer implements Jyanken {
    @Override
    public int play() {
        Random random = new Random(); // 乱数生成
        return random.nextInt(3); // 0, 1, 2 のいずれかをランダムに返す
    }
}

// Judgeクラスで勝敗判定を行う
class Judge {
    public static int judge(int humanHand, int computerHand) {
        if (humanHand == computerHand) return 0; // あいこ
        if ((humanHand == 0 && computerHand == 1) || // 人間が勝つ条件
            (humanHand == 1 && computerHand == 2) ||
            (humanHand == 2 && computerHand == 0)) return 1;
        return -1; // コンピュータが勝つ
    }
}

// Mainクラス
public class J6_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("あなたは何回勝つまでプレイしますか？");
        int targetWins = scanner.nextInt(); // 勝利目標回数を入力
        int humanWins = 0, computerWins = 0, draws = 0; // スコア初期化

        // Jyankenインターフェース型のオブジェクトを作成
        Jyanken human = new Human();
        Jyanken computer = new Computer();

        // 人間が目標回数勝つまで繰り返す
        while (humanWins < targetWins) {
            int humanHand = human.play(); // 人間の手
            int computerHand = computer.play(); // コンピュータの手

            // 結果を表示
            System.out.println("あなたは" + Jyanken.HANDS[humanHand]);
            System.out.println("コンピュータは" + Jyanken.HANDS[computerHand]);

            // 勝敗を判定
            int result = Judge.judge(humanHand, computerHand);
            if (result == 0) {
                System.out.println("あいこです");
                draws++;
            } else if (result == 1) {
                System.out.println("あなたの勝ちです");
                humanWins++;
            } else {
                System.out.println("あなたの負けです");
                computerWins++;
            }

            // スコアを表示
            System.out.println("あなたの " + humanWins + " 勝 " + computerWins + " 負 " + draws + " あいこ です");
        }

        // 終了メッセージ
        System.out.println("お疲れさまでした");
    }
}
