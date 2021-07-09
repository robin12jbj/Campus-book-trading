package UI;

import java.awt.*;
import javax.swing.*;
public class AdministratorMain {
		public void test() {		//定义一个test方法
			JFrame frame=new JFrame("@author 林白水");
			//取消布局管理器
			frame.setLayout(null);
			//绝对定位窗体的位置和大小
			frame.setBounds(300,150,0,0); 
				
			JLabel lab1=new JLabel("校园二手图书交易系统后台管理中心");
			lab1.setBackground(Color.gray);
			lab1.setOpaque(true);
			Font f1 = new Font("黑体",Font.PLAIN,15);
			lab1.setFont(f1);
			lab1.setForeground(Color.black);
			
			//创建按钮组
			JButton btn1=new JButton("图书求购");
			btn1.setBackground(Color.gray);
			btn1.setOpaque(true);
			Font f2 = new Font("黑体",Font.PLAIN,15);
			btn1.setFont(f2);
			btn1.setForeground(Color.black);
				
			JButton btn2=new JButton("修改");
			btn2.setBackground(Color.white);
			JButton btn3=new JButton("删除");
			btn3.setBackground(Color.white);
			
			JButton btn4=new JButton("图书售卖");
			btn4.setBackground(Color.gray);
			btn4.setOpaque(true);	
			btn4.setFont(f2);
			btn4.setForeground(Color.black);
				
			JButton btn5=new JButton("修改");
			btn5.setBackground(Color.white);
			JButton btn6=new JButton("删除");
			btn6.setBackground(Color.white);
			
			JButton btn7=new JButton("用户反馈");
			btn7.setBackground(Color.gray);
			btn7.setOpaque(true);	
			btn7.setFont(f2);
			btn7.setForeground(Color.black);
				
			JButton btn8=new JButton("反馈处理");
			btn8.setBackground(Color.white);
			
			JButton btn9=new JButton("用户管理");
			btn9.setBackground(Color.gray);
			btn9.setOpaque(true);	
			btn9.setFont(f2);
			btn9.setForeground(Color.black);
				
			JButton btn10=new JButton("修改");
			btn10.setBackground(Color.white);
			JButton btn11=new JButton("删除");
			btn11.setBackground(Color.white);
			
			//创建右部的显示面板
			JPanel pan1=new JPanel();
			pan1.setBackground(Color.white);
			pan1.setOpaque(true);
			pan1.setLayout(null);
			pan1.setBounds(190,60,550,320);
			
			JLabel label1=new JLabel("图书求购信息");
			label1.setBackground(Color.pink);
			label1.setOpaque(true);
			Font f3 = new Font("黑体",Font.PLAIN,15);
			label1.setFont(f3);
			label1.setForeground(Color.black);
			label1.setBounds(0, 0, 550, 35);
			
			JTextField text1=new JTextField();
			text1.setBounds(20, 40, 200, 25);
					
			JButton button1=new JButton("搜索");		
			button1.setBackground(Color.gray);
			button1.setBounds(250, 40, 80, 25);
			
			JTextArea text2=new JTextArea("之后在这里想想怎么用表格显示数据库内容，先用输入框代替");
			text2.setBounds(0, 80, 550, 220);
			text2.setBackground(Color.pink);
			
			pan1.add(label1);
			pan1.add(text1);
			pan1.add(button1);
			pan1.add(text2);
			
			
			
			//绝对定位按钮的位置和按钮的大小
			lab1.setBounds(0, 0, 800, 40);		
			btn1.setBounds(60, 70, 100, 25);
			btn2.setBounds(60, 95, 100, 25);
			btn3.setBounds(60, 120, 100, 25);
			btn4.setBounds(60, 150, 100, 25);
			btn5.setBounds(60, 175, 100, 25);
			btn6.setBounds(60, 200, 100, 25);
			btn7.setBounds(60, 230, 100, 25);
			btn8.setBounds(60, 255, 100, 25);
			btn9.setBounds(60, 285, 100, 25);
			btn10.setBounds(60, 310, 100, 25);
			btn11.setBounds(60, 335, 100, 25);		
			
			
			//将按钮添加到容器中
			frame.add(lab1);
			frame.add(btn1);
			frame.add(btn2);
			frame.add(btn3);
			frame.add(btn4);
			frame.add(btn5);
			frame.add(btn6);
			frame.add(btn7);
			frame.add(btn8);
			frame.add(btn9);
			frame.add(btn10);
			frame.add(btn11);
			frame.add(pan1);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗体结束应用程序
			//设置窗体大小
			frame.setSize(800,440);
			//设置窗体可见
			frame.setVisible(true);
			
			}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			AdministratorMain c= new AdministratorMain();
			c.test();
		}
}
	
	

	
	
	

