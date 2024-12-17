import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

// University クラス
class University {
    String name; // 大学名
    int n;       // 優勝回数

    // コンストラクタ
    public University(String name, int n) {
        this.name = name;
        this.n = n;
    }

    // toString メソッドをオーバーライド
    @Override
    public String toString() {
        return name + " " + n;
    }
}

// MyComp クラス
class MyComp implements Comparator<University> {  
    int m;

    MyComp(int m) {  
        this.m = m;  
    }

    public int compare(University o1, University o2) {  
        int n1 = o1.n;  // String n1 = o1.name;  コメントはnameでソートする場合  
        int n2 = o2.n;  // String n2 = o2.name;  
        if (m >= 0)  
            return n1 - n2;  // return n1.compaerTo(n2);  
        else  
        return n2 - n1;  // return n2.compareTo(n1);  
    }
}

public class J9_5 {
    public static void main(String[] args) {
        ArrayList<University> universities = new ArrayList<>();

        try {
            // ファイルからデータを読み込む
            Scanner stdin = new Scanner(new File("J9_5.txt"));
            while (stdin.hasNextLine()) {
                String line = stdin.nextLine();
                String[] parts = line.split(" "); // 空白で分割
                String name = parts[0];
                int n = Integer.parseInt(parts[1]); // 優勝回数を整数に変換
                universities.add(new University(name, n)); // リストに追加
            }
            stdin.close();
        } catch (FileNotFoundException e) {
            System.out.println("ファイルが見つかりません: " + e.getMessage());
            return;
        }

        // 優勝回数で昇順ソート
        Collections.sort(universities, new MyComp(1));
        System.out.println("------------------------");
        for (University u : universities) {
            System.out.println(u);
        }

        // 優勝回数で降順ソート
        Collections.sort(universities, new MyComp(-1));
        System.out.println("------------------------");
        for (University u : universities) {
            System.out.println(u);
        }
    }
}
