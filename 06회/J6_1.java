// Lightインターフェースを定義
interface Light {
    String[] STATES = {"Walk", "Stop", "Caution"}; // 配列
    void print(); // 抽象メソッド（実装はサブクラスに任せる）
}

// GreenクラスはLightインターフェースを実装
class Green implements Light {
    @Override
    public void print() {
        System.out.println("Green is " + STATES[0]); // STATES配列の1番目の要素を使用
    }
}

// RedクラスはLightインターフェースを実装
class Red implements Light {
    @Override
    public void print() {
        System.out.println("Red is " + STATES[1]); // STATES配列の2番目の要素を使用
    }
}

// YellowクラスはLightインターフェースを実装
class Yellow implements Light {
    @Override
    public void print() {
        System.out.println("Yellow is " + STATES[2]); // STATES配列の3番目の要素を使用
    }
}

// Mainクラス
public class J6_1 {
    public static void main(String[] args) {
        // 各クラスのオブジェクトを作成
        Light green = new Green();
        Light red = new Red();
        Light yellow = new Yellow();

        // printメソッドを呼び出す
        green.print();
        red.print();
        yellow.print();
    }
}
