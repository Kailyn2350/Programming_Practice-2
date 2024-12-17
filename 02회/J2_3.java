
public class J2_3 {
    public static void main(String[] args) {
        int totalPoints = 1000;  // 乱数の数
        int insideCircle = 0;    // 円の中に入った点の数

        // 乱数を使って(x, y)座標を生成
        for (int i = 0; i < totalPoints; i++) {
            double x = Math.random();
            double y = Math.random();

            // 点が円の中にあるかを確認
            if (x * x + y * y <= 1) {
                insideCircle++;
            }
        }

        // 4分の1の円の面積からπを計算し、4倍する
        double estimatedPi = (double) insideCircle / totalPoints * 4;

        // Mathクラスのπとの誤差を計算
        double error = Math.abs((estimatedPi - Math.PI) / Math.PI) * 100;

        // 結果出力
        System.out.println("モンテカルロ法で求めたπの値: " + estimatedPi);
        System.out.println("Math.PIの値: " + Math.PI);
        System.out.println("誤差: " + error + " %");
    }
}
