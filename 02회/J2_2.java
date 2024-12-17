
public class J2_2 {
    public static void main(String[] args) {
        // new演算子を使って3次元ベクトルを宣言
        double[] vector = new double[3];
        vector[0] = 3.0;  // x
        vector[1] = 4.0;  // y
        vector[2] = 5.0;  // z
        
        // ベクトルの大きさの計算
        double magnitude = Math.sqrt(vector[0]*vector[0] + vector[1]*vector[1] + vector[2]*vector[2]);
        
        // 結果
        System.out.println("ベクトルの大きさは: " + magnitude);
    }
}
