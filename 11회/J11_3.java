import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class J11_3 extends JFrame implements ChangeListener {
    private JPanel canvas;        // 色を表示するCanvas
    private JSlider redSlider;    // Redのスライダー
    private JSlider greenSlider;  // Greenのスライダー
    private JSlider blueSlider;   // Blueのスライダー
    private JLabel redLabel;      // Rの値を表示するLabel
    private JLabel greenLabel;    // Gの値を表示するLabel
    private JLabel blueLabel;     // Bの値を表示するLabel

    public J11_3() {
        super("カラーパレット");

        // Canvas生成
        canvas = new JPanel();
        canvas.setBackground(new Color(127, 127, 127)); // 初期色設定 RGB(127, 127, 127)
        canvas.setPreferredSize(new Dimension(300, 150)); // Canvasの大きさ設定

        // Canvasを中央に配置
        JPanel canvasContainer = new JPanel(new BorderLayout());
        canvasContainer.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8)); // Canvasの周りの余白
        canvasContainer.add(canvas, BorderLayout.CENTER);
        add(canvasContainer, BorderLayout.CENTER);

        // スライダーとラベルを配置するパネルを生成
        JPanel sliderPanel = new JPanel();
        sliderPanel.setLayout(new GridLayout(3, 1, 5, 5)); // 3行 1列のレイアウト
        sliderPanel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5)); // スライダーパネルの余白

        // Redスライダー
        redSlider = createSlider();
        redLabel = new JLabel("R = 127", JLabel.CENTER); // 중앙 정렬
        sliderPanel.add(createSliderPanel(redSlider, redLabel));

        // Greenスライダー
        greenSlider = createSlider();
        greenLabel = new JLabel("G = 127", JLabel.CENTER); // 중앙 정렬
        sliderPanel.add(createSliderPanel(greenSlider, greenLabel));

        // Blueスライダー
        blueSlider = createSlider();
        blueLabel = new JLabel("B = 127", JLabel.CENTER); // 중앙 정렬
        sliderPanel.add(createSliderPanel(blueSlider, blueLabel));

        // スライダーパネルを追加
        add(sliderPanel, BorderLayout.SOUTH);

        // フレーム設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400); // ウィンドウの大きさ設定
        setVisible(true);
    }

    // スライダー生成メソッド
    private JSlider createSlider() {
        JSlider slider = new JSlider(0, 255, 127); // 0～255範囲, 初期値127
        slider.addChangeListener(this); // スライダーにイベントリスナー
        return slider;
    }

    // スライダーと値を一つのパネルに配置するメソッド
    private JPanel createSliderPanel(JSlider slider, JLabel valueLabel) {
        JPanel panel = new JPanel(new BorderLayout());

        // スライダー追加
        panel.add(slider, BorderLayout.CENTER);

        // 値を表示するラベル
        panel.add(valueLabel, BorderLayout.SOUTH);

        return panel;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        // 現在のRGBの値を持ってくる
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();

        // Canvasの背景色のアップデート
        canvas.setBackground(new Color(red, green, blue));

        // ラベルの値をアップデート
        redLabel.setText("R = " + red);
        greenLabel.setText("G = " + green);
        blueLabel.setText("B = " + blue);
    }

    public static void main(String[] args) {
        new J11_3();
    }
}
