import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class CustomGraphCanvas extends Canvas {
    private String type;
    public CustomGraphCanvas() {
        this.type = "Sin"; // 初期値を "Sin" に設定
        setSize(361, 201); // Canvas大きさ指定
    }

    // グラフの種類を設定し再描画
    public void setType(String type) {
        this.type = type;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        int width = 361;
        int height = 201;

        // 背景を設定
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);

        // 曲線の色を設定
        g.setColor(type.equals("Sin") ? Color.RED : Color.BLUE);

        // 曲線を描画
        for (int x = 0; x <= 360; x++) {
            int y;
            if (type.equals("Sin")) {
                y = height / 2 - (int) (Math.sin(Math.toRadians(x)) * (height / 2 - 10));
            } else {
                y = height / 2 - (int) (Math.cos(Math.toRadians(x)) * (height / 2 - 10));
            }
            g.fillRect(x, y, 2, 2);
        }

        // タイトルを描画
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString(type, width / 2 - 30, 30);
    }
}

public class J11_1 extends JFrame implements ActionListener {
    private final CustomGraphCanvas canvas;

    // フレームとUI要素を初期化
    public J11_1() {
        super("Trigonometric Graph");
        canvas = new CustomGraphCanvas();

        // ボタンを作成
        JButton sinButton = new JButton("Sin");
        JButton cosButton = new JButton("Cos");

        // ボタンにアクションリスナーを追加
        sinButton.addActionListener(this);
        cosButton.addActionListener(this);

        // ボタン用のパネルを作成
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(sinButton);
        buttonPanel.add(cosButton);

        // コンポーネントをフレームに追加
        add(canvas, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // フレーム設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(361, 300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // ボタンのラベルに応じてグラフを切り替える
        canvas.setType(e.getActionCommand());
    }

    // メインメソッド：プログラムの開始点
    public static void main(String[] args) {
        new J11_1();
    }
}
