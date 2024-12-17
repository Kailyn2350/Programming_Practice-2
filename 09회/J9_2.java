import java.util.Random;

public class J9_2 {
    public static void main(String[] args) {
        // ガウス分布に従う乱数を生成するための Random オブジェクト
        Random random = new Random();

        // ±3σ の範囲をカバーする配列
        int[] distribution = new int[61]; // -3.0 から 3.0 (0.1間隔で61個)

        // 乱数を生成して分布を計算
        int totalCount = 1_000_000;
        int withinRangeCount = 0;
        for (int i = 0; i < totalCount; i++) {
            double value = random.nextGaussian(); // ガウス分布乱数 (平均0, 標準偏差1)
            
            // ±3σ に収まる範囲か確認
            if (value >= -3.0 && value <= 3.0) {
                withinRangeCount++;
                int index = (int) Math.round((value + 3.0) * 10); // -3.0を0, 3.0を60にマッピング
                distribution[index]++; //マッピングしたindexの配列要素を++
            }
        }

        // グラフを出力
        for (int i = 0; i < distribution.length; i++) {
            double range = -3.0 + (i * 0.1); // 現在の範囲
            StringBuilder bar = new StringBuilder();
            for (int j = 0; j < distribution[i] / 1000; j++) {
                bar.append("*"); // 1000個ごとに1個の'*'
            }
            System.out.printf("%4.1f: %s\n", range, bar);
        }

        // ±3σ に収まる割合を計算して出力
        double percentage = (double) withinRangeCount / totalCount * 100;
        System.out.printf("±3σ に収まる割合: %.4f%%\n", percentage);
    }
}
