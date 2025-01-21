import java.io.DataInputStream;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

class Prefecture implements Serializable {  
    private static final long serialVersionUID = 1L; // オブジェクトのクラスはSerializableインタフェースを実装
    private String pref;  
    private int population;

    Prefecture(String pref, int population) {  
        this.pref = pref;  
        this.population = population;  
    }

    @Override
    public String toString() {  
        return pref + " : " + population;  
    }
}


public class J13_3Server {

        public static void main(String[] args) {  
            if (args.length < 1) {
                System.out.println("Usage: java J13_1Server <port>");
                return;
            }
            try {
                String[] pref = { "東京都", "神奈川県","大阪府",  "愛知県", "埼玉県", "千葉県", "兵庫" };  
                int[] population = { 13161751, 9049500, 8862896, 7408499, 7194957, 6217119, 5589177 };  
                String[] key = { "tokyo", "kanagawa", "osaka", "aichi", "saitama",  "chiba", "hyogo" };  
                Prefecture[] p = new Prefecture[pref.length];

                HashMap<String, Prefecture> hash = new HashMap<String, Prefecture>();  
                for (int i = 0; i < pref.length; i++) {
                	p[i] = new Prefecture(pref[i], population[i]);  
                	hash.put(key[i], p[i]);
                	}
                
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
                    ObjectOutputStream oos = new ObjectOutputStream(os);
                			
                    // 整数をクライアントから受け取る
                    String skey = dis.readUTF();
                    System.out.println(skey);
                    
                    // HashMap で探索
                    Prefecture result;
                    if (hash.containsKey(skey)) {
                        result = hash.get(skey);
                    } else {
                        result = new Prefecture("該当なし", 0);
                    }
                    
                    // クライアントに結果を送信
                    oos.writeObject(result);
                    
                    s.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }  
}