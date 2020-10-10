import javax.swing.*;

public class TestPicture {
    //    private JPanel panel1;
    private JPanel panel1;
    private JButton button1;
    private JTable table1;


    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new TestPicture().panel1);
        frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
        frame.pack();
        frame.setVisible(true);

    }
}
