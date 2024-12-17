import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class J10_1 {
    public static void main(String[] args) throws IOException {
        if (args.length < 3) { // ファイルが3個未満の場合はエラーメッセージを出力して終了
            System.out.println("Usage: java MergeFiles <file1> <file2> <outputFile>");
            return;
        }

        // 入力ファイルと出力ファイルのパス
        String file1 = args[0];
        String file2 = args[1];
        String outputFile = args[2];

        // 出力ファイルの準備
        try (FileWriter fw = new FileWriter(outputFile);
             FileReader fr1 = new FileReader(file1);
             FileReader fr2 = new FileReader(file2)) {

            // 各ファイルから1文字ずつ読み込む
            int ch1 = fr1.read();
            int ch2 = fr2.read();

            // 両方のファイルの内容が終了するまで繰り返し処理
            while (ch1 != -1 || ch2 != -1) {
                if (ch1 != -1) { // ファイル1から文字を読み込む
                    fw.write(ch1);
                    ch1 = fr1.read();
                }
                if (ch2 != -1) { // ファイル2から文字を読み込む
                    fw.write(ch2);
                    ch2 = fr2.read();
                }
            }
        }

        // 出力ファイルの内容をコンソールに表示
        try (FileReader fr = new FileReader(outputFile)) {
            int ch;
            while ((ch = fr.read()) != -1) {
                System.out.print((char) ch);
            }
        }
    }
}
