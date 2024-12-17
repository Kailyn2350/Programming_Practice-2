import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class J9_3 {
    public static void main(String[] args) {
        // ArrayList の宣言
        ArrayList<Integer> numbers = new ArrayList<>();

        // Random クラスを使用して乱数を生成
        Random random = new Random();

        while (numbers.size() < 10) { // 0〜9の異なる値を格納する
            int randomNumber = random.nextInt(10); // 0〜9 の乱数
            if (!numbers.contains(randomNumber)) { // 重複を防ぐ
                numbers.add(randomNumber);
            }
        }

        // 昇順にソート
        Collections.sort(numbers);

        // 拡張for文で昇順表示
        for (int number : numbers) {
            System.out.println(number);
        }

        // 昇順のリストを出力
        System.out.println(numbers);

        // 降順にソート
        Collections.reverse(numbers);

        // 拡張for文で降順表示
        for (int number : numbers) {
            System.out.println(number);
        }

        // 降順のリストを出力
        System.out.println(numbers);
    }
}
