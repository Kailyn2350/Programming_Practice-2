import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

class J13_1Client {
    public static void main(String[] args) {
        if (args.length < 2) { // コマンドラインを入力してない場合
            System.out.println("Usage: java J13_1Client <server> <port>");
            return;
        }
        // サーバーとポートを取得
        String server = args[0]; 
        int port = Integer.parseInt(args[1]);

        try (Socket s = new Socket(server, port); // ソケットを作成
        	// 出力ストリーム
             OutputStream os = s.getOutputStream();
             DataOutputStream dos = new DataOutputStream(os);
        	// 入力ストリーム
             InputStream is = s.getInputStream();
             DataInputStream dis = new DataInputStream(is);
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("整数１:");
            int num1 = scanner.nextInt();
            System.out.println("整数２:");
            int num2 = scanner.nextInt();

            // 二つの整数をサーバに送る
            dos.writeInt(num1);
            dos.writeInt(num2);

            // サーバから結果をもらう
            int result = dis.readInt();
            System.out.println("Result from server: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
