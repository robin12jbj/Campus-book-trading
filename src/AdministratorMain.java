import javax.swing.*;

public class AdministratorMain extends JFrame {
    private final JPanel pan = new JPanel();
    private final JButton button = new JButton("无");
    private final int AccountNumber;

    public AdministratorMain(int AccountNumber) {
        super.add(pan);
        this.AccountNumber = AccountNumber;
        this.setLayout(null);
        pan.add(button);

        this.setVisible(true);
        this.setBounds(0, 0, 100, 100);
        setLocationRelativeTo(null);
    }



}
