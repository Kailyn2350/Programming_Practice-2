import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class NewCanvas extends Canvas {
    private int x, y; // 現在の座標
    private int diameter = 20; // 直径
    private Color color = Color.BLUE; // 円の色（初期値：青）

    public NewCanvas() { // コンストラクタ
        this.setBackground(Color.PINK); // 背景色
        x = 140; // 円の初期x位置
        y = 90; // 円の初期y位置
    }

    public void moveCircle(int dx, int dy) { // 移動のメソッド
        x += dx; // x移動量
        y += dy; // y移動量
        repaint(); // 画面の更新
    }

    public void resetCircle() { // Centerメソッド
        x = 140;
        y = 90;
        repaint();
    }

    public void changeColor(Color newColor) { // 色を変えるメソッド
        color = newColor;
        repaint();
    }

    @Override
    public void paint(Graphics g) { // Canvasに円を描くメソッド
        if (x == 0 && y == 0) {
            x = (getWidth() / 2) - (diameter / 2);
            y = (getHeight() / 2) - (diameter / 2);
        }
        g.setColor(color);
        g.fillOval(x, y, diameter, diameter);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200); // Canvasの基本大きさを設定
    }
}

public class J12_1 extends JFrame {
    public J12_1() {
        setTitle("課題1");
        setLayout(new BorderLayout());

        // CanvasをNORTHに生成
        NewCanvas canvas = new NewCanvas();
        add(canvas, BorderLayout.NORTH);

        // ボタンを配置するパネルを生成
        JPanel movePanel = new JPanel();
        movePanel.setLayout(new BorderLayout());

        // 各ボタン生成
        JButton upButton = new JButton("↑");
        upButton.addActionListener(e -> canvas.moveCircle(0, -5));
        movePanel.add(upButton, BorderLayout.NORTH);

        JButton downButton = new JButton("↓");
        downButton.addActionListener(e -> canvas.moveCircle(0, 5));
        movePanel.add(downButton, BorderLayout.SOUTH);

        JButton leftButton = new JButton("←");
        leftButton.addActionListener(e -> canvas.moveCircle(-5, 0));
        movePanel.add(leftButton, BorderLayout.WEST);

        JButton rightButton = new JButton("→");
        rightButton.addActionListener(e -> canvas.moveCircle(5, 0));
        movePanel.add(rightButton, BorderLayout.EAST);

        JButton centerButton = new JButton("Center");
        centerButton.addActionListener(e -> canvas.resetCircle());
        movePanel.add(centerButton, BorderLayout.CENTER);

        add(movePanel, BorderLayout.CENTER);

        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(1, 2));

        JButton blueButton = new JButton("Blue");
        blueButton.addActionListener(e -> canvas.changeColor(Color.BLUE));
        colorPanel.add(blueButton);

        JButton redButton = new JButton("Red");
        redButton.addActionListener(e -> canvas.changeColor(Color.RED));
        colorPanel.add(redButton);

        add(colorPanel, BorderLayout.SOUTH);

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new J12_1();
    }
}
