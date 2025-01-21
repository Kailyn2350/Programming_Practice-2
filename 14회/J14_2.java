import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class J14_2 extends JFrame {
    private JTextField[] slots = new JTextField[3];
    private JButton startButton = new JButton("Start");
    private JButton[] stopButtons = new JButton[3];
    private SlotThread[] threads = new SlotThread[3];

    public J14_2() {
        // GUI レイアウト設定
        setTitle("スロット マシン"); // タイトル設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // フォントとサイズの設定
        Font font = new Font("SanSerif", Font.ITALIC, 75);

        // 数字フィールドとストップボタンを追加
        for (int i = 0; i < 3; i++) {
            // 数字フィールド
            slots[i] = new JTextField("0");
            slots[i].setFont(font);
            slots[i].setHorizontalAlignment(JTextField.CENTER);
            slots[i].setEditable(false);
            gbc.gridx = i;
            gbc.gridy = 0;
            gbc.insets = new Insets(10, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(slots[i], gbc);

            // ストップボタン
            stopButtons[i] = new JButton("Stop" + i);
            stopButtons[i].setEnabled(false);
            stopButtons[i].addActionListener(new StopAction(i));
            stopButtons[i].setPreferredSize(new Dimension(150, 20));
            gbc.gridy = 1;
            gbc.insets = new Insets(5, 5, 5, 5);
            add(stopButtons[i], gbc);
        }

        // Start ボタンを追加
        startButton.setEnabled(true);
        startButton.addActionListener(new StartAction());
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3; // Start ボタン中央配置のため幅を設定
        gbc.insets = new Insets(10, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(startButton, gbc);

        setSize(300, 250); // 全体のウィンドウサイズ
        setVisible(true);
    }

    // Start ボタンのクリック動作
    private class StartAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            startButton.setEnabled(false);
            for (int i = 0; i < 3; i++) {
                stopButtons[i].setEnabled(true);
                threads[i] = new SlotThread(slots[i]);
                threads[i].start();
            }
        }
    }

    // Stop ボタンのクリック動作
    private class StopAction implements ActionListener {
        private int index;

        public StopAction(int index) {
            this.index = index;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            stopButtons[index].setEnabled(false);
            threads[index].stopRunning();

            // 全てのスレッドが停止した場合
            if (allStopped()) {
                startButton.setEnabled(true); // Start ボタンを有効化
            }
        }

        private boolean allStopped() {
            for (JButton button : stopButtons) {
                if (button.isEnabled()) {
                    return false;
                }
            }
            return true;
        }
    }

    // スレッドクラス
    private static class SlotThread extends Thread {
        private JTextField slotField;
        private boolean running = true;
        private int currentNumber = 0;

        public SlotThread(JTextField slotField) {
            this.slotField = slotField;
        }

        @Override
        public void run() {
            while (running) {
                currentNumber = (currentNumber + 1) % 10; // 0から９まで巡回
                slotField.setText(String.valueOf(currentNumber));
                try {
                    Thread.sleep(100); // 0.1秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopRunning() {
            running = false;
        }
    }

    public static void main(String[] args) {
        new J14_2();
    }
}
