import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class J14_1 extends JFrame {
    private int radius = 50; // 初期半径
    private int speed = 50; // 初期速度
    private double angle = 0; // 角度
    private Timer timer;

    public J14_1() {
        setTitle("円運動"); // タイトル設定
        setSize(400, 400); // ウィンドウの大きさ設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ダブルバッファリングを使用したパネル
        BufferedPanel panel = new BufferedPanel();
        add(panel, BorderLayout.CENTER);

        // 半径スライダー
        JSlider radiusSlider = new JSlider(1, 100, radius); // 範囲1～100に設定
        JLabel radiusLabel = new JLabel("半径: " + radius);
        radiusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        radiusSlider.addChangeListener(e -> {
            radius = radiusSlider.getValue();
            radiusLabel.setText("半径: " + radius);
            panel.repaint();
        });

        // 速度スライダー
        JSlider speedSlider = new JSlider(1, 100, speed); // 範囲1～100に設定
        JLabel speedLabel = new JLabel("速度: " + speed);
        speedLabel.setHorizontalAlignment(SwingConstants.CENTER);
        speedSlider.addChangeListener(e -> {
            speed = speedSlider.getValue();
            speedLabel.setText("速度: " + speed);
            timer.setDelay(speed > 0 ? 1000 / speed : Integer.MAX_VALUE);
        });

        // スライダーとラベルを追加
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(4, 1));
        sliderPanel.add(radiusSlider);
        sliderPanel.add(radiusLabel);
        sliderPanel.add(speedSlider);
        sliderPanel.add(speedLabel);

        add(sliderPanel, BorderLayout.SOUTH);

        // タイマーの設定
        timer = new Timer(1000 / speed, e -> {
            angle += Math.PI / 50; // 点の位置が表す角度（Math.PI / 50ずつ変化）
            if (angle > 2 * Math.PI) { // 2πを超えた場合初期化
                angle -= 2 * Math.PI;
            }
            panel.repaint();
        });
        timer.start();
    }

    // ダブルバッファリングを使用したパネル
    class BufferedPanel extends JPanel {
        private Image bufferImage;
        private Graphics bufferGraphics;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // バッファイメージの初期化
            if (bufferImage == null) {
                bufferImage = createImage(getWidth(), getHeight());
                bufferGraphics = bufferImage.getGraphics();
            }

            // バッファに描画
            Dimension size = getSize();
            int c = (int) (127.5 * (1 + Math.sin(angle))); // 背景色の計算

            bufferGraphics.setColor(new Color(c, c, c)); // ダブルバッファリングを使用
            for (int i = 0; i < size.width; i++) {
                bufferGraphics.drawLine(i, 0, i, size.height - 1);
            }

            // 円の中心座標
            int centerX = size.width / 2;
            int centerY = size.height / 2;

            // 円を描画
            bufferGraphics.setColor(Color.RED);
            bufferGraphics.drawOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);

            // 点を描画
            int x = centerX + (int) (radius * Math.cos(angle));
            int y = centerY + (int) (radius * Math.sin(angle));
            bufferGraphics.setColor(Color.BLUE);
            bufferGraphics.fillOval(x - 5, y - 5, 10, 10);

            // バッファイメージを画面に描画
            g.drawImage(bufferImage, 0, 0, this);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            J14_1 app = new J14_1();
            app.setVisible(true);
        });
    }
}
