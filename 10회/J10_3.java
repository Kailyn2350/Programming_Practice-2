import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class J10_3 {
    public static void main(String[] args) throws IOException {
        Random random = new Random(); // 乱数生成
        // 各ファイルのオブジェクト生成
        File textFile = new File("d10_3.txt");
        File binaryFile = new File("d10_3.bin");
        
        // 乱数をファイルに書き込む。
        try (FileWriter fw = new FileWriter(textFile);
             DataOutputStream dos = new DataOutputStream(new FileOutputStream(binaryFile))) {
            for (int i = 0; i < 10; i++) {
                double value = random.nextDouble();
                fw.write(value + "\n");
                dos.writeDouble(value);
            }
        }
        // 各ファイルのサイズを出力
        System.out.println("Text File Size = " + textFile.length());
        System.out.println("Binary File Size = " + binaryFile.length());
        // txtファイルの内容出力
        try (BufferedReader br = new BufferedReader(new FileReader(textFile))) {
            System.out.println("-----d10_3.txt-----");
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
        // binファイルの内容出力
        try (DataInputStream dis = new DataInputStream(new FileInputStream(binaryFile))) {
            System.out.println("-----d10_3.bin-----");
            while (true) {
                System.out.println(dis.readDouble());
            }
        } catch (EOFException e) {
        }
    }
}
