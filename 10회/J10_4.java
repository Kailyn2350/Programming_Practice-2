import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.ArrayList;

// Player クラス: 各選手の情報を保持する
class Player {
    String position; // ポジション (例: GK, DF, MF, FW)
    String name;     // 名前
    int year, month, day; // 生年月日 (年、月、日)

    // コンストラクタ: Player オブジェクトを初期化
    public Player(String position, String name, int year, int month, int day) {
        this.position = position;
        this.name = name;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    // Player 情報をフォーマットして文字列として返す
    @Override
    public String toString() {
        return String.format("%4d年%2d月%2d日 %s %s", year, month, day, position, name);
    }
}

public class J10_4 {
    public static void main(String[] args) throws IOException {
        ArrayList<Player> players = new ArrayList<>(); // Player オブジェクトを保存するリスト

        // ファイルを読み取るために BufferedReader を作成
        try (BufferedReader br = new BufferedReader(new FileReader("s10_4.txt"))) {
            StreamTokenizer st = new StreamTokenizer(br); // StreamTokenizer オブジェクトを作成

            // 特定の文字や動作を設定
            st.eolIsSignificant(true);  // 改行を有効なトークンとして扱う
            st.whitespaceChars(',', ','); // カンマを区切り文字として扱う
            st.whitespaceChars('/', '/'); // スラッシュを区切り文字として扱う

            String position = null, name = ""; // ポジションと名前を一時的に保存する
            int year = 0, month = 0, day = 0;  // 年、月、日を一時的に保存する

            // ファイルからトークンを1つずつ処理
            while (st.nextToken() != StreamTokenizer.TT_EOF) {
                if (st.ttype == StreamTokenizer.TT_NUMBER) { // 数字のトークン処理
                    if (year == 0) {
                        year = (int) st.nval; // 最初の数字は年
                    } else if (month == 0) {
                        month = (int) st.nval; // 次の数字は月
                    } else if (day == 0) {
                        day = (int) st.nval; // 最後の数字は日
                    }
                } else if (st.ttype == StreamTokenizer.TT_WORD) { // 単語のトークン処理
                    if (st.sval.equals("GK") || st.sval.equals("DF") || st.sval.equals("MF") || st.sval.equals("FW")) {
                        position = st.sval; // ポジションとして保存
                    } else {
                        name += st.sval + " "; // 名前として結合
                    }
                } else if (st.ttype == StreamTokenizer.TT_EOL) { // 行の終わりで Player オブジェクトを作成
                    if (position != null && !name.trim().isEmpty() && year > 0 && month > 0 && day > 0) {
                        players.add(new Player(position, name.trim(), year, month, day)); // リストに追加
                    }
                    // 次の行に向けて変数を初期化
                    position = null;
                    name = "";
                    year = month = day = 0;
                }
            }
        }

        // 全ての Player オブジェクトを出力
        for (Player player : players) {
            System.out.println(player);
        }
    }
}
