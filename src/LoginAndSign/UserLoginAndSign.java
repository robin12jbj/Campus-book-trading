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
		Font font = new Font("����", Font.BOLD, 15);
	       //�˺�
		p1=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 namelab=new JLabel("�û���");
		 t1=new JTextField(18);
		 p1.add(namelab);
		 p1.add(t1);
		 this.add(p1);
		 namelab.setFont(font);
		 
		 //��������
		 p2=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 passlab=new JLabel("����������");
		 t2=new JTextField(18);
		 p2.add(passlab);
		 p2.add(t2);
		 this.add(p2);
		 passlab.setFont(font);
		 
		 //ȷ������
		 p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 doublepasslab=new JLabel("�ٴ�ȷ������");
		 t3=new JTextField(18);
		 p3.add(doublepasslab);
		 p3.add(t3);
		 this.add(p3);
		 doublepasslab.setFont(font);
		 
		 //�Ա�ѡ��
		 p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 sex=new JLabel("�Ա�");
		 boy=new JRadioButton("��");
		 girl=new JRadioButton("Ů");		
		 this.boy.setSelected(true);
		 p4.add(sex);
		 p4.add(boy);
		 p4.add(girl);
		 this.add(p4);
		 sex.setFont(font);
		 
		 //��ʵ����
		 p7=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 name=new JLabel("��ʵ����");
		 t7=new JTextField(18);
		 p7.add(name);
		 p7.add(t7);
		 this.add(p7);
		 name.setFont(font);
		 
		 //��ϵ��ʽ
		 p5=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 information=new JLabel("��ϵ��ʽ");
		 t5=new JTextField();
		 p5.add(information);
		 p5.add(t5);
		 this.add(p5);
		 information.setFont(font);
		 
		 //ѡ��
		 p6=new JPanel(new FlowLayout(FlowLayout.LEFT));
		 confirm=new JButton("ȷ��");
		 cancel=new JButton("ȡ��");
		 p6.add(confirm);
		 p6.add(cancel);
		 this.add(p6);
		 confirm.setFont(font);
		 cancel.setFont(font);
		 
	}
	public static void main(String[] args) {
		
	}
}