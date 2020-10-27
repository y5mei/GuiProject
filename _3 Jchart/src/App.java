import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {

    private JPanel panel1;
    private JButton pieChartButton;
    private JCheckBox timeSeqAnalyCheckBox;
    private JPanel picturePanel;

    // 设置按键反应
    public App() {
        pieChartButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                PieChart.main(new String[0]);
            }
        });
        timeSeqAnalyCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                TimeSeriesDemo1.main(new String[0]);

            }
        });
//        try {
//            BufferedImage myPicture = ImageIO.read(new File("40x50xiaozhu.png"));
//        } catch (IOException ex) {
//            System.out.println("no this image");
//        }

//        panel1.add(picturePanel);
    }

    /**
     * 设计主函数，显示 Frame
     **/
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Java 第一个 GUI 程序");
        frame.setSize(400, 200);    //设置窗口显示尺寸
        frame.setContentPane(new App().panel1);
        frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
        frame.pack();
        frame.setVisible(true);


    }
}
