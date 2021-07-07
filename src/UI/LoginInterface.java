package UI;
import util.Jdbcs;
import LoginAndSign.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author yh128
 * @version 1.0.0
 * Login.java
 * 登录类
 * 2019年06月11日 11:27:00
 */
public class LoginInterface extends JFrame implements ActionListener {
    private final JPanel pan = new JPanel();
    private final JLabel namelab = new JLabel("用户名");
    private final JLabel passlab = new JLabel("密 码");
    private final JTextField nametext = new JTextField();
    private final JPasswordField passtext = new JPasswordField();
    public JButton denglu = new JButton("登录");
    public JButton zhuce = new JButton("注册");
    private final JRadioButton button = new JRadioButton("管理员登录");


    public LoginInterface() {
        Font font = new Font("宋体", Font.BOLD, 15);
        super.setTitle("校园图书交易系统");
        pan.setLayout(null);
        pan.add(namelab);
        pan.add(nametext);
        pan.add(passlab);
        pan.add(passtext);
        pan.add(denglu);
        pan.add(zhuce);
        pan.add(button);
        namelab.setBounds(140, 100, 60, 30);
        nametext.setBounds(240, 100, 140, 30);
        passlab.setBounds(140, 180, 60, 30);
        passtext.setBounds(240, 180, 140, 30);
        denglu.setBounds(150, 240, 90, 20);
        zhuce.setBounds(280, 240, 90, 20);
        button.setBounds(200, 280, 150, 30);
        nametext.setFont(font);
        passtext.setFont(font);
        zhuce.setFont(font);
        namelab.setFont(font);
        passlab.setFont(font);
        zhuce.addActionListener(this);
        denglu.addActionListener(this);

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
        if (e.getSource() == denglu) {

            try {
                denglu(Integer.parseInt(nametext.getText()), String.valueOf(passtext.getPassword()));
            } catch (Exception q) {
                JOptionPane.showMessageDialog(null, "请输入账号密码！");
            }
        } else if (e.getSource() == zhuce) {
            try {
                zhuce(Integer.parseInt(nametext.getText()), String.valueOf(passtext.getPassword()));
            } catch (Exception q) {
                JOptionPane.showMessageDialog(null, "请输入合法的账号（只包含数字）！");

            }
        }
    }

    /**
     * 登陆按钮的事件处理函数
     */
    public void denglu(int AccountNumber, String Password) {
        Jdbcs d = new Jdbcs();
        if (button.isSelected()) {
            //选中管理员登录按钮
            if (d.isAdmin(AccountNumber, Password)) {
                //管理员账号密码正确,登录管理员界面
                new AdministratorMain();
            }
        } else {
            //以用户身份登录
            if (d.isUser(AccountNumber, Password)) {
                //用户账号密码正确，登录用户界面
                new UserMain();

            }
        }


    }

    /**
     * 注册按钮的事件处理函数
     */
    public void zhuce(int AccountNumber, String Password) {
        Jdbcs d = new Jdbcs();
        d.insert(AccountNumber, Password);
    }
}


 