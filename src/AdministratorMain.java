import javax.swing.*;

public class AdministratorMain extends JFrame {
    private final JPanel pan = new JPanel();
    private final JButton button = new JButton("无");

    public AdministratorMain() {

        this.setLayout(null);
        pan.add(button);
        super.add(pan);
        this.setVisible(true);
        this.setBounds(0, 0, 100, 100);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new UserMain();
    }


}
