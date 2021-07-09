package UI;

import java.awt.*;
import javax.swing.*;
public class AdministratorMain {
		public void test() {		//定义一个test方法
		JFrame frame=new JFrame("@author 林白水");
		//取消布局管理器
		frame.setLayout(null);
		//绝对定位窗体的位置和大小
		frame.setBounds(0,0,200,150); 
		//创建两个按钮	
		JLabel lab1=new JLabel("校园二手图书交易系统后台管理中心");
		lab1.setBackground(Color.gray);
		lab1.setOpaque(true);
		Font f1 = new Font("黑体",Font.PLAIN,15);
		lab1.setFont(f1);
		lab1.setForeground(Color.black);
		
		JLabel lab2=new JLabel("图书求购",JLabel.CENTER);
		lab2.setBackground(Color.gray);
		lab2.setOpaque(true);
		Font f2 = new Font("黑体",Font.PLAIN,15);
		lab2.setFont(f2);
		lab2.setForeground(Color.black);
			
		JButton btn1=new JButton("增加");
		btn1.setBackground(Color.white);
		JButton btn2=new JButton("删除");
		btn2.setBackground(Color.white);
		
		JLabel lab3=new JLabel("图书售卖",JLabel.CENTER);
		lab3.setBackground(Color.gray);
		lab3.setOpaque(true);	
		lab3.setFont(f2);
		lab3.setForeground(Color.black);
			
		JButton btn3=new JButton("增加");
		btn3.setBackground(Color.white);
		JButton btn4=new JButton("删除");
		btn4.setBackground(Color.white);
		
		JLabel lab4=new JLabel("图书售购查询",JLabel.CENTER);
		lab4.setBackground(Color.gray);
		lab4.setOpaque(true);	
		lab4.setFont(f2);
		lab4.setForeground(Color.black);
			
		JButton btn5=new JButton("购买查询");
		btn5.setBackground(Color.white);
		JButton btn6=new JButton("出售查询");
		btn6.setBackground(Color.white);
		
		//绝对定位按钮的位置和按钮的大小
		lab1.setBounds(0, 0, 800, 40);		
		lab2.setBounds(60, 70, 100, 25);
		btn1.setBounds(60, 95, 100, 25);
		btn2.setBounds(60, 120, 100, 25);
		lab3.setBounds(60, 150, 100, 25);
		btn3.setBounds(60, 175, 100, 25);
		btn4.setBounds(60, 200, 100, 25);
		lab4.setBounds(60, 230, 100, 25);
		btn5.setBounds(60, 255, 100, 25);
		btn6.setBounds(60, 280, 100, 25);
		
		//将按钮添加到容器中
		frame.add(lab1);
		frame.add(lab2);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(lab3);
		frame.add(btn3);
		frame.add(btn4);
		frame.add(lab4);
		frame.add(btn5);
		frame.add(btn6);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗体结束应用程序
		//设置窗体大小
		frame.setSize(800,400);
		//设置窗体可见
		frame.setVisible(true);
		
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			AdministratorMain c= new AdministratorMain();
			c.test();
		}
}
	
	

	
	
	

