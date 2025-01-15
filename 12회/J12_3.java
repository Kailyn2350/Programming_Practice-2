import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class J12_3 extends JFrame implements ActionListener {

    private JTextArea textArea; // テキストエリア
    private String menuOpen = "開く";
    private String menuSave = "保存する";
    private String menuEnd = "終了";

    public J12_3() {
    	setTitle("課題3");

        // メニューバーの作成
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // ファイルメニューの作成
        JMenu fileMenu = new JMenu("ファイル");
        menuBar.add(fileMenu);

        // メニュー項目の作成
        JMenuItem openItem = new JMenuItem(menuOpen);
        JMenuItem saveItem = new JMenuItem(menuSave);
        JMenuItem endItem = new JMenuItem(menuEnd);

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(endItem);

        // アクションリスナーの登録
        openItem.addActionListener(this);
        saveItem.addActionListener(this);
        endItem.addActionListener(this);

        // テキストエリアの作成
        textArea = new JTextArea();
        textArea.setLineWrap(true); // テキストが折り返されるよう設定
        textArea.setWrapStyleWord(true);

        // スクロール付きのパネル作成
        JScrollPane scrollPane = new JScrollPane(textArea);

        // テキスト表示用パネル
        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setBorder(new TitledBorder("入力")); // タイトル付き枠線
        textPanel.setPreferredSize(new Dimension(400, 300)); // パネルの大きさを指定
        textPanel.add(scrollPane, BorderLayout.CENTER);

        // 全体レイアウトに追加
        add(textPanel, BorderLayout.CENTER);

        // フレームの基本設定
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        // "開く"の処理
        if (cmd.equals(menuOpen)) {
            FileDialog fileDialog = new FileDialog(this, "ファイルを開く", FileDialog.LOAD);
            fileDialog.setVisible(true);

            String directory = fileDialog.getDirectory(); // ディレクトリ
            String file = fileDialog.getFile(); // ファイル名

            if (file != null) { // ファイルが選択された場合
                String filePath = directory + file;
                loadFile(filePath);
            }
        }

        // "保存する"の処理
        else if (cmd.equals(menuSave)) {
            FileDialog fileDialog = new FileDialog(this, "テキストを保存する", FileDialog.SAVE);
            fileDialog.setVisible(true);

            String directory = fileDialog.getDirectory(); // ディレクトリ
            String file = fileDialog.getFile(); // ファイル名

            if (file != null) { // ファイル名が入力された場合
                String filePath = directory + file;

                // 拡張子が .txt でなければ追加する
                if (!filePath.toLowerCase().endsWith(".txt")) {
                    filePath += ".txt";
                }

                saveFile(filePath);
            }
        }

        // "終了"の処理
        else if (cmd.equals(menuEnd)) {
            System.exit(0); // プログラムを終了
        }
    }

    // ファイルを読み込んでテキストエリアに表示
    private void loadFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            textArea.setText(""); // テキストエリアをクリア
            String line;
            while ((line = reader.readLine()) != null) {
                textArea.append(line + "\n"); // 行を追加
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    // テキストエリアの内容をファイルに保存
    private void saveFile(String filePath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(textArea.getText()); // テキストエリアの内容を保存
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new J12_3();
    }
}
