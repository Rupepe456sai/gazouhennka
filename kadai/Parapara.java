import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Parapara extends Object {
    private JLabel imageLabel;
    private Image[] images;// 配列を使う
    private int currentIndex = 0;/* 何回も繰り返す為*//*If文でループから抜け出すことができる*/
    private Timer timer;
    private int imageWidth = 700; // 画像の幅
    private int imageHeight = 700; // 画像の高さ

    public void perform() {
        // 画像の読み込み
        ImageIcon image1 = new ImageIcon("1.jpeg");
        ImageIcon image2 = new ImageIcon("2.jpeg");
        ImageIcon image3 = new ImageIcon("3.jpeg");
        ImageIcon image4 = new ImageIcon("4.jpeg");
        // 画像配列の初期化
        images = new Image[] { image1.getImage(), image2.getImage(), image3.getImage(), image4.getImage() };//配列の中に読み込んだ画像を格納する

        // ウィンドウのフレームを作成
        JFrame frame = new JFrame("ParaPara");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 画像を表示するためのラベル
        imageLabel = new JLabel(new ImageIcon(images[currentIndex].getScaledInstance/*画像の幅や高さを調整する*/(imageWidth, imageHeight, Image.SCALE_DEFAULT)));
        frame.add(imageLabel, BorderLayout.CENTER);

        // Timer を使って画像を自動的に切り替える
        timer = new Timer(100, new ActionListener() {// 時間の設定
            public void actionPerformed(ActionEvent e) {// 上記の時間が経った時に下の処理を行う
                currentIndex = (currentIndex + 1) % images.length;// ここで何番目の画像を表示させるかをcurrentIndexに格納する
                imageLabel.setIcon(new ImageIcon(images[currentIndex].getScaledInstance/* 上のgetScaledInstanceで定義した幅や高さで画像を表示する */(imageWidth,imageHeight, Image.SCALE_DEFAULT)));
            }
        });
        timer.start(); // タイマーを開始

        frame.pack();
        frame.setLocationRelativeTo(null); // ウィンドウを中央に配置
        frame.setVisible(true);//ウィンドウを表示
    }

}
