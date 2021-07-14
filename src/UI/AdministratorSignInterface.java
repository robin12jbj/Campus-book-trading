package UI;

import LoginAndSign.AdministratorLoginAndSign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdministratorSignInterface extends JFrame implements ActionListener {
    private final JPanel pan = new JPanel();
    private final JLabel name = new JLabel("用 户 名：");
    private final JLabel password = new JLabel("密    码：");
    private final JLabel password2 = new JLabel("确认密码：");
    private final JLabel secretkey = new JLabel("邀 请 码：");
    private final JLabel background;
    private final JTextField nametext = new JTextField();
    private final JTextField passwordtext = new JTextField(18);
    private final JTextField passwordtext2 = new JTextField(18);
    private final JTextField secretkeytext = new JTextField();
    public JButton confirm = new JButton("确认");
    public JButton cancel = new JButton("取消");
    private ImageIcon ima;


    public AdministratorSignInterface() {

        setResizable(false);
        Font font = new Font("楷体", Font.BOLD, 18);
        super.setTitle("管理员注册");
        setIconImage(new ImageIcon("./images/book.png").getImage());
        pan.setLayout(null);
        pan.add(name);
        pan.add(nametext);
        pan.add(password);
        pan.add(passwordtext);
        pan.add(password2);
        pan.add(passwordtext2);
        pan.add(secretkey);
        pan.add(secretkeytext);
        pan.add(confirm);
        pan.add(cancel);
        name.setBounds(140, 110, 100, 30);
        nametext.setBounds(240, 110, 160, 30);

        password.setBounds(140, 160, 100, 30);
        passwordtext.setBounds(240, 160, 160, 30);
        password2.setBounds(140, 210, 100, 30);
        passwordtext2.setBounds(240, 210, 160, 30);
        secretkey.setBounds(140, 260, 100, 30);
        secretkeytext.setBounds(240, 260, 160, 30);
        confirm.setBounds(150, 330, 90, 30);
        cancel.setBounds(280, 330, 90, 30);
        nametext.setFont(font);
        passwordtext.setFont(font);
        password2.setFont(font);
        passwordtext2.setFont(font);
        secretkey.setFont(font);
        secretkeytext.setFont(font);
        confirm.setFont(font);
        cancel.setFont(font);
        name.setFont(font);
        password.setFont(font);
        secretkeytext.setFont(font);

        ima = new ImageIcon("./images/管理员注册界面.png");//写入文件路径
        background = new JLabel(ima);
        background.setBackground(Color.WHITE);
        pan.add(background);
        background.setBounds(0, 0, 600, 600);

        pan.setBackground(Color.WHITE);
        super.add(pan);
        super.setSize(600, 600);
        super.setVisible(true);
        setLocationRelativeTo(null);
        //注册监听器
        confirm.addActionListener(this);
        cancel.addActionListener(this);
    }

    public static void main(String[] args) {

        new AdministratorSignInterface();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirm) {
            //管理员确认注册
            if (!passwordtext.getText().equals(passwordtext2.getText())) {
                //密码、确认密码不同
                JOptionPane.showMessageDialog(null, "两次密码不一致！请重新输入密码！");
                passwordtext.setText("");
                passwordtext2.setText("");
            } else {
                boolean f;
                f = new AdministratorLoginAndSign().Sign(Integer.parseInt(nametext.getText()), passwordtext.getText(), secretkeytext.getText());
                if (f) {
                    //注册成功，销毁当前页面
                    this.dispose();
                }
            }
        } else {
            //取消按钮,销毁当前页面
            this.dispose();
        }
    }


}