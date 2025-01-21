import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class J13_3Client extends JFrame {
    private JTextField input1, input2;
    private JButton sendButton;

    public J13_3Client(String host, int port) {
        // JFrameの設定
        setTitle("課題3");
        setSize(250, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        // Keyのラベル
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("Key : "), gbc);

        // Keyの入力欄
        input1 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        add(input1, gbc);

        // 結果のラベル
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(new JLabel("結果: "), gbc);

        // 結果の表示欄
        input2 = new JTextField(15);
        input2.setEditable(false); // 入力不可
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(input2, gbc);

        // 送信ボタン
        sendButton = new JButton("送信");
        sendButton.setPreferredSize(new Dimension(80, 30));
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

                    String key = input1.getText();
                    dos.writeUTF(key);

                    // サーバーから結果を受信
                    InputStream is = socket.getInputStream();
                    ObjectInputStream ois = new ObjectInputStream(is);
                    Prefecture result = (Prefecture) ois.readObject();

                    // 結果を結果ラベルに表示
                    input2.setText(result.toString());

                    // ソケットを閉じる
                    socket.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    input2.setText("エラー: " + ex.getMessage());
                }
            }
        });
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java J13_3Client <host> <port>");
            return;
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);

        SwingUtilities.invokeLater(() -> {
            new J13_3Client(host, port).setVisible(true);
        });
    }
}
