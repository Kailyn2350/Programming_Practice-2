
public class J2_1 {
	public static void main(String[] args) {
        // 配列宣言
        int[] a = {2, 5, 3, 8, 9, 7, 6, 1, 4, 10};
        int sum = 0;
        
        // 配列の全要素の合計を計算
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        
        // 結果
        System.out.println("配列の合計は: " + sum);
    }
}
