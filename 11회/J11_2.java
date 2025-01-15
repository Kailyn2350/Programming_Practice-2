import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class J11_2 extends JFrame implements ActionListener {
    private JLabel resultLabel;       // 結果を表示するラベル
    private JTextField inputField;   // ユーザー入力フィールド
    private JRadioButton sinButton, cosButton, tanButton; // 三角関数選択ボタン
    private JButton computeButton;   // 計算ボタン
    private ButtonGroup group;       // ラジオボタンをグループ化

    public J11_2() {
        super("Compute");

        // メインパネル設定
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // 結果ラベル
        resultLabel = new JLabel("0.0", JLabel.CENTER);
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // 中央揃え
        mainPanel.add(resultLabel);

        // 入力フィールド
        inputField = new JTextField(10);
        inputField.setHorizontalAlignment(JTextField.CENTER); // 入力テキストを中央配置
        inputField.setMaximumSize(new Dimension(200, 30));
        inputField.setAlignmentX(Component.CENTER_ALIGNMENT); // 中央揃え
        mainPanel.add(inputField);

        // ラジオボタンパネル
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // 水平揃え
        sinButton = new JRadioButton("Sin", true); // 初期選択: Sin
        cosButton = new JRadioButton("Cos");
        tanButton = new JRadioButton("Tan");

        // ラジオボタンをグループ化
        group = new ButtonGroup();
        group.add(sinButton);
        group.add(cosButton);
        group.add(tanButton);

        // ラジオボタンをパネルに追加
        radioPanel.add(sinButton);
        radioPanel.add(cosButton);
        radioPanel.add(tanButton);
        mainPanel.add(radioPanel);

        // 計算ボタン
        computeButton = new JButton("Compute");
        computeButton.addActionListener(this); // ボタンにアクションリスナーを追加
        computeButton.setAlignmentX(Component.CENTER_ALIGNMENT); // 中央揃え
        mainPanel.add(computeButton);

        // メインパネルをフレームに追加
        add(mainPanel);

        // フレーム設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300); // 適切なサイズを設定
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // 入力フィールドから値を取得
            String inputText = inputField.getText();
            double degree = Double.parseDouble(inputText); // 度単位で入力値を処理

            // 度をラジアンに変換
            double radians = Math.toRadians(degree);

            // 選択された三角関数を計算
            double result = 0.0;
            if (sinButton.isSelected()) {
                result = Math.sin(radians); // Sinを計算
            } else if (cosButton.isSelected()) {
                result = Math.cos(radians); // Cosを計算
            } else if (tanButton.isSelected()) {
                result = Math.tan(radians); // Tanを計算
            }

            // 結果をラベルに表示
            resultLabel.setText(String.format("%.16f", result));
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid Input"); // 無効な入力を処理
        }
    }

    public static void main(String[] args) {
        new J11_2();
    }
}
