
public class J2_4 {
    public static void main(String[] args) {
        int sum = 0;        // 和
        int squareSum = 0;  // 二乗和

        // 1〜10までの和と二乗和を計算
        for (int i = 1; i <= 10; i++) {
            sum += i;
            squareSum += i * i;
        }

        // 結果出力
        System.out.println("1〜10までの和: " + sum);
        System.out.println("1〜10までの二乗和: " + squareSum);
    }
}
