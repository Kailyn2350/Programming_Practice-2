import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class J11_4 extends JFrame implements ActionListener {
    private JPasswordField passwordField;  // 正解を表示するフィールド
    private JTextField guessField;         // ユーザーが入力するフィールド
    private JLabel resultLabel;            // 結果を表示するラベル
    private JButton guessButton;           // Guessボタン
    private String targetNumber;           // 正解の数字

    public J11_4() {
        super("NumerOn");

        // mainパネル
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // 結果ラベル
        resultLabel = new JLabel("...", JLabel.CENTER);
        resultLabel.setPreferredSize(new Dimension(150, 20)); // 大きさ指定
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // 中央整列
        mainPanel.add(resultLabel);

        // 余白
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 正解フィールド
        passwordField = new JPasswordField();
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setEditable(false); // 修正不可能
        passwordField.setPreferredSize(new Dimension(150, 20)); // 大きさ指定
        passwordField.setMaximumSize(passwordField.getPreferredSize()); // 固定大きさ
        passwordField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(passwordField);

        // 余白
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // 入力フィールド
        guessField = new JTextField();
        guessField.setHorizontalAlignment(JTextField.CENTER);
        guessField.setPreferredSize(new Dimension(150, 20)); // 大きさ指定
        guessField.setMaximumSize(guessField.getPreferredSize()); // 固定大きさ
        guessField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(guessField);

        // 余白
        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Guessボタン
        guessButton = new JButton("Guess");
        guessButton.setPreferredSize(new Dimension(100, 30)); // 大きさ指定
        guessButton.setMaximumSize(guessButton.getPreferredSize()); // 固定大きさ
        guessButton.setAlignmentX(Component.CENTER_ALIGNMENT); // 中央整列
        guessButton.addActionListener(this);
        mainPanel.add(guessButton);

        // mainパネルをフレームに追加
        add(mainPanel);

        // 正解の数字生成
        targetNumber = setNum();
        passwordField.setText("****"); // 隠蔽

        // フレーム設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(220, 220);
        setVisible(true);
    }

    // 4桁のランダム数字を生成するメソッド
    private String setNum() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < 4) {
            int digit = rand.nextInt(10); // 0～９の数字
            if (sb.indexOf(String.valueOf(digit)) == -1) {
                sb.append(digit); // 中腹を拒否
            }
        }
        return sb.toString();
    }

    // 入力された数字と正解を比較して結果を返すメソッド
    private String judge(String guess, String target) {
        int eat = 0;
        int bite = 0;

        for (int i = 0; i < guess.length(); i++) {
            char g = guess.charAt(i);
            if (target.charAt(i) == g) {
                eat++; // 位置と数字全て当てはまる
            } else if (target.indexOf(g) != -1) {
                bite++; // 数字は当てはまるけど位置が違う
            }
        }

        return eat + " eat " + bite + " bite";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String guess = guessField.getText();

        // 検査
        if (guess.length() != 4 || !guess.matches("\\d{4}")) {
            resultLabel.setText("4桁の数字を入力してください。");
            return;
        }

        // 結果計算
        String result = judge(guess, targetNumber);
        resultLabel.setText(result);

        // 正解を入力した場合
        if (result.equals("4 eat 0 bite")) {
            JOptionPane.showMessageDialog(this, "おめでとうございます！正解です！", "ゲームクリア", JOptionPane.INFORMATION_MESSAGE);
//            targetNumber = setNum(); // 
            passwordField.setText("****"); // 隠蔽
            System.out.println("答え: " + targetNumber); // 正解を出力
        }
    }

    public static void main(String[] args) {
        new J11_4();
    }
}
