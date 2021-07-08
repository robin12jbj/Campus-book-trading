package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserSignInterface extends JFrame  implements ActionListener {
	private final JPanel pan = new JPanel();
    JTextField t1,t2,t3,t5,t7;
    JLabel name,namelab,passlab,doublepasslab,sex,information;
    JRadioButton boy,girl;
    JButton confirm,cancel;



    UserSignInterface(){
    	pan.setLayout(null);
        Font font = new Font("宋体", Font.BOLD, 15);
        //账号
        namelab=new JLabel("账号");
        t1=new JTextField(18);
        pan.add(namelab);
        pan.add(t1);
        namelab.setBounds(140,60,80,30);
        t1.setBounds(240,60,150,30);
        namelab.setFont(font);

        //密码
        passlab=new JLabel("密码");
        t2=new JTextField(18);
        pan.add(passlab);
        pan.add(t2);
        passlab.setBounds(140,110,80,30);
        t2.setBounds(240,110,150,30);
        passlab.setFont(font);

        //再次确认密码
        doublepasslab=new JLabel("确认密码");
        t3=new JTextField(18);
        pan.add(doublepasslab);
        pan.add(t3);
        doublepasslab.setBounds(140,160,80,30);
        t3.setBounds(240,160,150,30);
        doublepasslab.setFont(font);

        //性别
        sex=new JLabel("性别");
        boy=new JRadioButton("男");
        girl=new JRadioButton("女");
        this.boy.setSelected(true);
        pan.add(sex);
        pan.add(boy);
        pan.add(girl);
        sex.setBounds(140,210,60,30);
        boy.setBounds(240,210,60,30);
        girl.setBounds(320,210,60,30);
        sex.setFont(font);

        //真实姓名
        name=new JLabel("真实姓名");
        t7=new JTextField(18);
        pan.add(name);
        pan.add(t7);
        name.setBounds(140,260,80,30);
        t7.setBounds(240,260,150,30);
        name.setFont(font);

        //联系方式
        information=new JLabel("联系方式");
        t5=new JTextField();
        pan.add(information);
        pan.add(t5);
        information.setBounds(140,310,80,30);
        t5.setBounds(240,310,150,30);
        information.setFont(font);

        //选择
        confirm=new JButton("确认");
        cancel=new JButton("取消");
        pan.add(confirm);
        pan.add(cancel);
        confirm.setFont(font);
        cancel.setFont(font);
        confirm.setBounds(150,380,90,30);
        cancel.setBounds(280,380,90,30);
        
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


    public void denglu(int AccountNumber, String Password) {
    	
    }
}


 