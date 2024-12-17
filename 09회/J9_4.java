import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Prefecture クラス
class Prefecture {
    private String name; // 都道府県名
    private String capital; // 都道府県庁所在地

    // コンストラクタ
    public Prefecture(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }

    // toString メソッドをオーバーライド
    @Override
    public String toString() {
        return name + " , " + capital;
    }
}

public class J9_4 {
    public static void main(String[] args) {
        // データの準備
        String[][] str = {{"東京都", "神奈川県", "埼玉県", "千葉県", "茨城県", "栃木県", "群馬県"},
                          {"新宿区", "横浜市", "さいたま市", "千葉市", "水戸市", "宇都宮市", "前橋市"}};
        String[] strkey = {"tokyo", "kanagawa", "saitama", "chiba", "ibaraki", "tochigi", "gunma"};

        // HashMap の作成
        HashMap<String, Prefecture> prefectures = new HashMap<>();
        for (int i = 0; i < strkey.length; i++) {
            prefectures.put(strkey[i], new Prefecture(str[0][i], str[1][i]));
        }

        // HashMap のすべてのキーと値を表示
        for (Map.Entry<String, Prefecture> entry : prefectures.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // キーボード入力を利用した探索機能
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("キー入力 : ");
            String input = scanner.nextLine();
            
            if (input.equals("end")) {
                break;
            }
            
            if (prefectures.containsKey(input)) {
                System.out.println(prefectures.get(input));
            } else {
                System.out.println("見つかりません");
            }
        }
        scanner.close();
    }
}
