abstract class Light {
    // private、protected、修飾子なしで試す
    // private String str;
    // protected String str;
    String str; // デフォルトの場合

    Light(String str) {
        this.str = str; // コンストラクタで初期化
    }

    abstract void print(); // 抽象メソッド
}
class Green extends Light {
    Green(String str) {
        super(str);
    }

    @Override
    void print() {
        System.out.println("Green is " + str);
    }
}

class Red extends Light {
    Red(String str) {
        super(str);
    }

    @Override
    void print() {
        System.out.println("Red is " + str);
    }
}

class Yellow extends Light {
    Yellow(String str) {
        super(str);
    }

    @Override
    void print() {
        System.out.println("Yellow is " + str);
    }
}

class J5_2 {
    public static void main(String[] args) {
        Light green = new Green("Walk");
        Light red = new Red("Stop");
        Light yellow = new Yellow("Caution");

        green.print();
        red.print();
        yellow.print();
    }
}