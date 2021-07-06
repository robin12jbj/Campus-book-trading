import javax.swing.*;

public class UserMain extends JFrame {
    private final JPanel pan = new JPanel();
    private final JButton button = new JButton("无");

    public UserMain() {

        this.setLayout(null);
        pan.add(button);
        super.add(pan);
        this.setVisible(true);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new UserMain();
    }


}
