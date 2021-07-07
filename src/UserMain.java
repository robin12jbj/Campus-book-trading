import javax.swing.*;

public class UserMain extends JFrame {
    private final JPanel pan = new JPanel();
    private final JButton button = new JButton("无");
    private final int AccountNumber;
    private int Password;

    public UserMain(int AccountNumber) {
        super.add(pan);
        this.AccountNumber = AccountNumber;

        this.setLayout(null);
        pan.add(button);

        this.setVisible(true);

        setLocationRelativeTo(null);
    }




}
