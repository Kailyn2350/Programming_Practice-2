// ExtoStringクラス: x, yの値を保持し、toString()をオーバーライ
class ExtoString {
    private int x, y; // 2つの整数をフィールドとして持つ

    // コンストラクタでxとyを初期化
    public ExtoString(int x, int y) {
        this.x = x;
        this.y = y;
    }

//    // ObjectクラスのtoString()をオーバーライド
//    @Override
//    public String toString() {
//        // フィールドx, yの値を含む文字列を返す
//        return "オーバーライド toString  x = " + x + " , y = " + y;
//    }
    
    // オーバーライドしない toString メソッド名を変更
    public String NoOverridetoString() {
        return "オーバーライドしない x = " + x + " ,  y = " + y;
    }
}

// メインクラス
public class J6_5 {
    public static void main(String[] args) {
        // ExtoStringオブジェクトを作成
        ExtoString obj = new ExtoString(10, 20);

        // オーバーライドされたtoString()メソッドが呼び出される
        System.out.println(obj);
    }
}
