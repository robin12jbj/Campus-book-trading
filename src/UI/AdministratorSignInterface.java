package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  AdministratorSignInterface extends JFrame implements ActionListener {
    private final JPanel pan = new JPanel();
    private final JLabel name = new JLabel("用户名");
    private final JLabel password = new JLabel("密 码");
    private final JLabel secretkey= new JLabel("邀请码");
    private final JTextField nametext = new JTextField();
    private final JPasswordField passwordtext = new JPasswordField();
    private final JTextField secretkeytext = new JTextField();
    public JButton confirm = new JButton("确认");
    public JButton cancel= new JButton("取消");

    public AdministratorSignInterface() {
        Font font = new Font("宋体", Font.BOLD, 15);
        super.setTitle("校园图书交易系统");
        pan.setLayout(null);
        pan.add(name);
        pan.add(nametext);
        pan.add(password);
        pan.add(passwordtext);
        pan.add(secretkey);
        pan.add(secretkeytext);
        pan.add(confirm);
        pan.add(cancel);
        name.setBounds(140, 80, 60, 30);
        nametext.setBounds(240, 80, 140, 30);
        password.setBounds(140, 160, 60, 30);
        passwordtext.setBounds(240, 160, 140, 30);
        secretkey.setBounds(140,240,60,30);
        secretkeytext.setBounds(240,240,140,30);
        confirm.setBounds(150, 320, 90, 20);
        cancel.setBounds(280, 320, 90, 20);
        nametext.setFont(font);
        passwordtext.setFont(font);
        secretkeytext.setFont(font);
        confirm.setFont(font);
        cancel.setFont(font);
        name.setFont(font);
        password.setFont(font);
        secretkeytext.setFont(font);
        confirm.addActionListener(this);
        cancel.addActionListener(this);

        super.add(pan);
        super.setSize(600, 600);
        super.setVisible(true);
        //设置关闭进程，退出应用程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {

        new LoginInterface();
    }


    /**
     * Invoked when an action occurs
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * 登陆按钮的事件处理函数
     */
    public void denglu(int AccountNumber, String Password) {

    }



}