import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

class J13_1Server {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java J13_1Server <port>");
            return;
        }    
            try {
                // ポートを取得
                int port = Integer.parseInt(args[0]);
                
                // サーバーソケットを作成
                ServerSocket ss = new ServerSocket(port);
                
                System.out.println("Server is listening on port " + port);
                
                // 無限ループ
                while(true) {
                	// クライアントからの要求を受け取る
                	Socket s = ss.accept();
                	
                	// 入力ストリーム
                	InputStream is = s.getInputStream();
                	DataInputStream dis = new DataInputStream(is);
                	
                	// 出力ストリーム
                	OutputStream os = s.getOutputStream();
                	DataOutputStream dos = new DataOutputStream(os);
                			
                    // 整数をクライアントから受け取る
                    int num1 = dis.readInt();
                    int num2 = dis.readInt();
                    System.out.println("Received numbers: " + num1 + ", " + num2);
                    
                    // 足し算を計算してクライアントに送り返す
                    int result = num1 + num2;
                    dos.writeInt(result);
                    
                    s.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
    }
}
