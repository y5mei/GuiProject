import javax.swing.*;
import java.awt.*;
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
    }

    public class JFrameDemo extends JFrame {
        public JFrameDemo() {
            setTitle("Java 第一个 GUI 程序");    //设置显示窗口标题
            setSize(400, 200);    //设置窗口显示尺寸
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    //置窗口是否可以关闭
            JLabel jl = new JLabel("这是使用JFrame类创建的窗口");    //创建一个标签
            Container c = getContentPane();    //获取当前窗口的内容窗格
            c.add(jl);    //将标签组件添加到内容窗格上
            setContentPane(new App().panel1);
            setVisible(true);    //设置窗口是否可见
        }
    }

    /**
     * 设计主函数，显示 Frame
     **/
    public static void main(String[] args) {
        App app = new App();
        app.new JFrameDemo();
//        JFrame frame = new JFrame();
//        frame.setTitle("Java 第一个 GUI 程序");
//        frame.setSize(400, 200);    //设置窗口显示尺寸
//        frame.setContentPane(new App().panel1);
//        frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
//        frame.pack();
//        frame.setVisible(true);


    }
}
