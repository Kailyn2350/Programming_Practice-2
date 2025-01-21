import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class J13_2Client extends JFrame {
    private JTextField input1, input2;
    private JButton sendButton;
    private JLabel resultLabel;

    public J13_2Client(String host, int port) {
        // JFrameの設定
        setTitle("課題2");
        setSize(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // GUIコンポーネント
        // 整数１のラベル
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("整数 1:"), gbc);

        // 整数１の入力
        input1 = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(input1, gbc);

        // 整数２のラベル
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("整数 2:"), gbc);

        // 整数２の入力
        input2 = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(input2, gbc);

        // 結果ラベル
        resultLabel = new JLabel("結果: ");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(resultLabel, gbc);

        // 送信ボタン
        sendButton = new JButton("送信");
        sendButton.setPreferredSize(new Dimension(80, 30)); // ボタンの大きさ
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(sendButton, gbc);

        // 送信ボタンのアクションリスナー
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // サーバーに接続
                    Socket socket = new Socket(host, port);

                    // 入力データの送信
                    OutputStream os = socket.getOutputStream();
                    DataOutputStream dos = new DataOutputStream(os);

                    int num1 = Integer.parseInt(input1.getText());
                    int num2 = Integer.parseInt(input2.getText());
                    dos.writeInt(num1);
                    dos.writeInt(num2);

                    // サーバーから結果を受信
                    InputStream is = socket.getInputStream();
                    DataInputStream dis = new DataInputStream(is);
                    int result = dis.readInt();

                    // 結果を結果ラベルに表示
                    resultLabel.setText("結果" + result);

                    // ソケットを閉じる
                    socket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    resultLabel.setText("エラー: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java J13_2Client <host> <port>");
            return;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        // クライアントGUIの起動
        SwingUtilities.invokeLater(() -> {
            new J13_2Client(host, port).setVisible(true);
        });
    }
}
