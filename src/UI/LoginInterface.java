package UI;

import LoginAndSign.AdministratorLoginAndSign;
import LoginAndSign.UserLoginAndSign;

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
    //private final JPanel pan = new JPanel();
    private final JLabel title=new JLabel("校园图书交易系统");
    private final JPanel pan2=new JPanel();
    private final JLabel namelab = new JLabel("用户名");
    private final JLabel passlab = new JLabel("密 码");
    private final JTextField nametext = new JTextField();
    private final JPasswordField passtext = new JPasswordField();
    public JButton denglu = new JButton("登录");
    public JButton zhuce = new JButton("注册");
    private final JRadioButton button = new JRadioButton("管理员登录/注册");


    public LoginInterface() {
        this.setSize(600, 500);
        this.setVisible(true);
        this.setIconImage(new ImageIcon("./images/book.png").getImage());
        Font font = new Font("宋体", Font.BOLD, 15);
        this.setTitle("校园图书交易系统");
        //添加背景图片面板
        //添加主面板
        //this.add(pan);
        class ImagePanel extends JPanel {
            Dimension d;
            Image image;
            public ImagePanel(Dimension d, Image image) {
                super();
                this.d = d;
                this.image = image;
            }
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, d.width, d.height, this);
                repaint();
            }
        }
        ImagePanel bgpan=new ImagePanel(new Dimension(this.getWidth(),this.getHeight()),new ImageIcon("./images/book.png").getImage());
        this.setContentPane(bgpan);
        bgpan.setLayout(null);
        //pan2.setBounds(0,0,super.getWidth(),super.getHeight());
        // JLabel lbBg = new JLabel(new ImageIcon("./images/book.png"));
        // lbBg.setBounds(0, 0,pan.getWidth(), pan.getHeight());
        //pan.add(lbBg);
        //最精准的布局模式空布局
        title.setFont(new Font("宋体",Font.BOLD,20));
        bgpan.add(title);
        title.setBounds(190,10,200,80);

        this.getContentPane().add(namelab);
        this.getContentPane().add(nametext);
        this.getContentPane().add(passlab);
        this.getContentPane().add(passtext);
        this.getContentPane().add(denglu);
        this.getContentPane().add(zhuce);
        this.getContentPane().add(button);
        namelab.setBounds(140, 100, 60, 30);
        nametext.setBounds(240, 100, 140, 30);
        passlab.setBounds(140, 180, 60, 30);
        passtext.setBounds(240, 180, 140, 30);
        denglu.setBounds(150, 240, 90, 20);
        //denglu.setContentAreaFilled(false);
        //zhuce.setContentAreaFilled(false);
        //denglu.setBorderPainted(false);
        //zhuce.setBorderPainted(false);
        zhuce.setBounds(280, 240, 90, 20);
        button.setBounds(200, 280, 150, 30);
        button.setContentAreaFilled(false);
        nametext.setFont(font);
        passtext.setFont(font);
        namelab.setFont(font);
        passlab.setFont(font);
        zhuce.setFont(font);
        zhuce.addActionListener(this);
        denglu.addActionListener(this);
        //设置关闭进程，退出应用程序
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //让窗体居中显示
        setLocationRelativeTo(null);
        //禁用最大化按钮
        setResizable(false);
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
                //没有输入账号密码，提示输入
                JOptionPane.showMessageDialog(null, "请输入账号密码！");
            }
        } else if (e.getSource() == zhuce) {
           //注册按钮，开启用户注册或管理员注册页面
                if(button.isSelected()){
                    new AdministratorSignInterface();
                }
                else{
                    new UserSignInterface();
                }
        }
    }

    /**
     * 登陆按钮的事件处理函数
     */
    public void denglu(int AccountNumber, String Password) {

        if (button.isSelected()) {
            //选中管理员登录按钮
            if (new AdministratorLoginAndSign().Login(AccountNumber,Password)) {
                //管理员账号密码正确,登录管理员界面
                //账号密码不正确的提示在Login函数中，无需继续添加提示
                new AdministratorMain().test();
                this.dispose();
            }
        } else {
            //以用户身份登录
            if (new UserLoginAndSign().Login(AccountNumber,Password)) {
                //用户账号密码正确，登录用户界面
                //账号密码不正确的提示在Login函数中，无需继续添加提示

                new UserMain();
                this.dispose();

            }
        }


    }



}


 