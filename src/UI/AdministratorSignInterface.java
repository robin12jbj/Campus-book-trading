package UI;

import LoginAndSign.AdministratorLoginAndSign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class  AdministratorSignInterface extends JFrame implements ActionListener {
    private final JPanel pan = new JPanel();
    private final JLabel name = new JLabel("用户名");
    private final JLabel password = new JLabel("密码");
    private final JLabel password2 = new JLabel("确认密码");
    private final JLabel secretkey= new JLabel("邀请码");
    private final JTextField nametext = new JTextField();
    private final JTextField passwordtext = new JTextField(18);
    private final JTextField passwordtext2 = new JTextField(18);
    private final JTextField secretkeytext = new JTextField();
    public JButton confirm = new JButton("确认");
    public JButton cancel= new JButton("取消");

    public AdministratorSignInterface() {
        Font font = new Font("宋体", Font.BOLD, 15);
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
        name.setBounds(140, 120, 90, 30);
        nametext.setBounds(240, 120, 140, 30);

        password.setBounds(140, 160, 90, 30);
        passwordtext.setBounds(240, 160, 140, 30);

        password2.setBounds(140, 200, 90, 30);
        passwordtext2.setBounds(240, 200, 140, 30);

        secretkey.setBounds(140,240,90,30);
        secretkeytext.setBounds(240,240,140,30);
        confirm.setBounds(150, 320, 90, 20);
        cancel.setBounds(280, 320, 90, 20);
        nametext.setFont(font);
        passwordtext.setFont(font);
        password2.setFont(font);
        passwordtext2.setFont(font);
        secretkeytext.setFont(font);
        confirm.setFont(font);
        cancel.setFont(font);
        name.setFont(font);
        password.setFont(font);
        secretkeytext.setFont(font);
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
        if(e.getSource()==confirm){
            //管理员确认注册
            if(!passwordtext.getText().equals(passwordtext2.getText())){
                //密码、确认密码不同
                JOptionPane.showMessageDialog(null, "两次密码不一致！请重新输入密码！");
                passwordtext.setText("");
                passwordtext2.setText("");
            }else{
                 boolean f;
                 f=new AdministratorLoginAndSign().Sign(Integer.parseInt(nametext.getText()),passwordtext.getText(),secretkeytext.getText());
                 if(f){
                    //注册成功，销毁当前页面
                    this.dispose();
                }
            }
        }else{
            //取消按钮,销毁当前页面
            this.dispose();
        }
    }






}