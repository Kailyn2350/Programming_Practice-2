import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class J10_2 {
    public static void main(String[] args) throws IOException {
    	// ファイルの読み書き準備
        try (BufferedReader br = new BufferedReader(new FileReader("s10_2.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("d10_2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) { // 1行ずつ読み取ってline変数に入れる。
                StringBuffer sb = new StringBuffer(line); // 読み取った1行をtringBuffer sbに入れる。
                for (int i = 0; i < sb.length(); i++) { // 1行の中で1文字ずつ確認する。
                    if (sb.charAt(i) == 'た' && (i + 1 < sb.length() && sb.charAt(i + 1) == 'た')) { // 'た'が必要である'たた'の場合
                        sb.deleteCharAt(i); // 一つ目の'た'は削除
                        i++; // 二つ目の'た'は飛ばす。
                    } else if (sb.charAt(i) == 'た') { // 削除する'た'を見つけた場合。
                        sb.deleteCharAt(i);
                        i--;
                    }
                }
                // 処理が終わった行をd10_2.txtに入れる。
                bw.write(sb.toString());
                bw.newLine();
            }
        }
        // d10_2.txtの内容出力
        try (BufferedReader br = new BufferedReader(new FileReader("d10_2.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
