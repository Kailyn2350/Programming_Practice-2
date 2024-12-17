public class J6_4_1 {
    public static void main(String[] args) {
    	
    	// 完全修飾名を使ってインスタンスを生成
        p.ClassP objP = new p.ClassP();
        // 完全修飾名を使ってインスタンスを生成
        p1.p2.ClassP1P2 objP1P2 = new p1.p2.ClassP1P2();

        // メソッドの呼び出し
        objP.print();
        objP1P2.print();
    }
}