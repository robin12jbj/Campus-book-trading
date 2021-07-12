package UI;

import LoginAndSign.UserLoginAndSign;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserSignInterface extends JFrame  implements ActionListener {
	private final JPanel pan = new JPanel();
	private ImageIcon ima;
    JTextField t1,t2,t3,t5,t7;
    JLabel background,name,namelab,passlab,doublepasslab,sex,information;
    JRadioButton boy,girl;
    JButton confirm,cancel;
    ButtonGroup buttonGroup=new ButtonGroup();



    UserSignInterface(){
    	pan.setBackground(Color.WHITE);
    	pan.setLayout(null);
        Font font = new Font("楷体", Font.BOLD, 18);
        super.setTitle("学生注册");
        
        //账号
        namelab=new JLabel("账    号：");
        t1=new JTextField(18);
        pan.add(namelab);
        pan.add(t1);
        namelab.setBounds(140,60,100,30);
        t1.setBounds(240,60,150,30);
        namelab.setFont(font);
        setIconImage(new ImageIcon("./images/book.png").getImage());
        //密码
        passlab=new JLabel("密    码：");
        t2=new JTextField(18);
        pan.add(passlab);
        pan.add(t2);
        passlab.setBounds(140,110,100,30);
        t2.setBounds(240,110,150,30);
        passlab.setFont(font);

        //再次确认密码
        doublepasslab=new JLabel("确认密码：");
        t3=new JTextField(18);
        pan.add(doublepasslab);
        pan.add(t3);
        doublepasslab.setBounds(140,160,100,30);
        t3.setBounds(240,160,150,30);
        doublepasslab.setFont(font);

        //性别
        sex=new JLabel("性    别：");
        boy=new JRadioButton("男");
        girl=new JRadioButton("女");
        boy.setOpaque(false);
        girl.setOpaque(false);
        //按钮组实现只能选择一个

        buttonGroup.add(boy);
        buttonGroup.add(girl);
        this.boy.setSelected(true);
        pan.add(sex);
        pan.add(boy);
        pan.add(girl);
        sex.setBounds(140,210,100,30);
        boy.setBounds(240,210,60,30);
        girl.setBounds(320,210,60,30);
        sex.setFont(font);
        boy.setFont(font);
        girl.setFont(font);
        //真实姓名
        name=new JLabel("真实姓名：");
        t7=new JTextField(18);
        pan.add(name);
        pan.add(t7);
        name.setBounds(140,260,100,30);
        t7.setBounds(240,260,150,30);
        name.setFont(font);

        //联系方式
        information=new JLabel("联系方式：");
        t5=new JTextField();
        pan.add(information);
        pan.add(t5);
        information.setBounds(140,310,100,30);
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
        cancel.setBounds(300,380,90,30);

        ima=new ImageIcon("./images/学生注册页面.png");//写入文件路径
        background=new JLabel(ima);
        background.setBackground(Color.WHITE);
        pan.add(background);
        background.setBounds(0,0,600,600);
        
        //添加事件监听
        confirm.addActionListener(this);
        cancel.addActionListener(this);
        getContentPane().add(pan);
        this.setSize(600, 600);
        this.setVisible(true);
        //关闭该窗体，应用程序不退出，继续显示登陆界面
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public static void main(String[] args) {

        new UserSignInterface();
    }


    /**
     * Invoked when an action occurs
     */
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==confirm) {
        //确认按钮，触发事件,确认注册，进行判断
           if(!t2.getText().equals(t3.getText())){
               //两次输入密码不一致
               JOptionPane.showMessageDialog(null, "两次密码不一致！请重新输入密码！");
               t2.setText("");
               t3.setText("");
           }else{
                    boolean f;
                   if(boy.isSelected()){
                       //男
                       f=new UserLoginAndSign().Sign(Integer.parseInt(t1.getText()),t2.getText(),t7.getText(), boy.getText(),t5.getText());
                   }else{
                       //女
                       f=new UserLoginAndSign().Sign(Integer.parseInt(t1.getText()),t2.getText(),t7.getText(), girl.getText(),t5.getText());
                   }
                   if(f){
                       this.dispose();
                       //注册成功，销毁当前页面
                   }

           }
       }else{
           //取消按钮，触发事件，销毁当前页面，但不停止程序运行
           this.dispose();
       }
    }

}


 