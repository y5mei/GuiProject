import javax.swing.*;

public class SwingWindow {
    private JPanel panelMain;
    private JButton button1;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new SwingWindow().panelMain);
        frame.setDefaultCloseOperation(JFrame.TEXT_CURSOR);
        frame.pack();
        frame.setVisible(true);

    }
}
