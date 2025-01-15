import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class J12_2 extends JFrame {
    private JLabel displayLabel; // 結果表示ラベル
    private int firstOperand = 0; // 一つ目の数字
    private int secondOperand = 0; // 二つ目の数字
    private String operator = ""; // 演算子
    private boolean isNewInput = true; // 新しい入力の確認

    J12_2() {
        setTitle("課題2");

        // レイアウトマネージャーを設定
        setLayout(new BorderLayout());

        // ラベル生成
        displayLabel = new JLabel("0"); // 初期値
        displayLabel.setHorizontalAlignment(JLabel.CENTER); // 中央配置
        add(displayLabel, BorderLayout.NORTH);

        // ボタンパネル生成
        JPanel pc = new JPanel();
        pc.setLayout(new GridLayout(4, 3)); // 4行3列

        // 数字ボタン生成
        for (int i = 0; i < 10; i++) {
            int num = i;
            JButton numberButton = new JButton("" + i);
            numberButton.addActionListener(e -> appendNumber(num));
            pc.add(numberButton);
        }

        // "+" ボタン
        JButton plusButton = new JButton("+");
        plusButton.addActionListener(e -> setOperator("+")); // 処理
        pc.add(plusButton);

        // "=" ボタン
        JButton equalsButton = new JButton("=");
        equalsButton.addActionListener(e -> calculateResult()); // 結果計算
        pc.add(equalsButton);

        add(pc, "Center");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 200);
        setVisible(true);
    }

    // 数字をラベルに追加するメソッド
    private void appendNumber(int number) {
        if (isNewInput) {
            displayLabel.setText("" + number); // 新しい入力の場合上書きする
            isNewInput = false;
        } else {
            displayLabel.setText(displayLabel.getText() + number); // 前の値に数字を追加
        }
    }

    // 演算子を設定するメソッド
    private void setOperator(String op) {
        if (!displayLabel.getText().isEmpty()) {
            firstOperand = Integer.parseInt(displayLabel.getText()); // 一つ目の数字を保存
            operator = op; // 演算子設定
            isNewInput = true; // 次の入力待ち
        }
    }

    // 結果を計算するメソッド
    private void calculateResult() {
        if (!displayLabel.getText().isEmpty() && !operator.isEmpty()) {
            secondOperand = Integer.parseInt(displayLabel.getText()); // 二つ目の数字を保存
            int result = 0;

            // 演算遂行
            if (operator.equals("+")) {
                result = firstOperand + secondOperand;
            }

            // 結果をラベルに表示
            displayLabel.setText("" + result);

            // 初期化
            firstOperand = result; // 以前結果を一つ目の数字に設定
            operator = "";
            isNewInput = true;
        }
    }

    public static void main(String[] args) {
        new J12_2();
    }
}
