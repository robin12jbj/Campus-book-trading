package LoginAndSign;

import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JPanel; 
import javax.swing.JPasswordField; 
import javax.swing.JTextField; 


public class UserRegister extends JFrame  implements ActionListener{
	JPanel pan,p1,p2,p3,p4,p5,p6,p7;
	JTextField t1,t2,t3,t5,t7;
	JLabel name,namelab,passlab,doublepasslab,sex,information;
	JRadioButton boy,girl;
	JButton confirm,cancel;
	
	
	
	public UserRegister(){
		Font font = new Font("宋体", Font.BOLD, 15);
	       //账号
		p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 namelab=new JLabel("用户名");
		 t1=new JTextField(18);
		 p1.add(namelab);
		 p1.add(t1);
		 this.add(p1);
		 namelab.setFont(font);
		 
		 //密码输入
		 p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 passlab=new JLabel("请输入密码");
		 t2=new JTextField(18);
		 p2.add(passlab);
		 p2.add(t2);
		 this.add(p2);
		 passlab.setFont(font);
		 
		 //确认密码
		 p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 doublepasslab=new JLabel("再次确认密码");
		 t3=new JTextField(18);
		 p3.add(doublepasslab);
		 p3.add(t3);
		 this.add(p3);
		 doublepasslab.setFont(font);
		 
		 //性别选择
		 p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 sex=new JLabel("性别");
		 boy=new JRadioButton("男");
		 girl=new JRadioButton("女");		
		 this.boy.setSelected(true);
		 p4.add(sex);
		 p4.add(boy);
		 p4.add(girl);
		 this.add(p4);
		 sex.setFont(font);
		 
		 //真实姓名
		 p7=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 name=new JLabel("真实姓名");
		 t7=new JTextField(18);
		 p7.add(name);
		 p7.add(t7);
		 this.add(p7);
		 name.setFont(font);
		 
		 //联系方式
		 p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 information=new JLabel("联系方式");
		 t5=new JTextField();
		 p5.add(information);
		 p5.add(t5);
		 this.add(p5);
		 information.setFont(font);
		 
		 //选择
		 p6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 confirm=new JButton("确认");
		 cancel=new JButton("取消");
		 p6.add(confirm);
		 p6.add(cancel);
		 this.add(p6);
		 confirm.setFont(font);
		 cancel.setFont(font);
		 
	}
	public static void main(String[] args) {
		
	}
}