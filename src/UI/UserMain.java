package UI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class UserMain extends JFrame implements ActionListener{
	private JTextArea text2;
	JButton btn2,btn3,btn5,btn6,btn20,btn21,btn8;
	public  JButton btn1=new JButton("买家信息");
	public 	JButton btn4=new JButton("卖家信息");
	public 	JButton btn7=new JButton("反馈信息");
	JPanel pan1,pan2;
	panetest pan3;
	panel2 pan4;
	Container jpanel;
	public UserMain() {		//定义一个test方法
		//JFrame frame=new JFrame("@author 朱旭");
		this.setSize(800,440);
		//设置窗体大小
		this.setLocationRelativeTo(null);
		//窗体居中
		//取消布局管理器
		this.setLayout(null);
		//绝对定位窗体的位置和大小
		this.setBounds(300,150,0,0);
		Container jpanel=this.getContentPane();
		jpanel.setLayout(null);
		//frame.setBounds(300,150,0,0);
		JLabel lab1=new JLabel("校园二手图书交易系统后台管理中心");
		lab1.setBackground(Color.gray);
		lab1.setOpaque(true);
		Font f1 = new Font("黑体",Font.PLAIN,15);
		lab1.setFont(f1);
		lab1.setForeground(Color.black);

		//创建按钮组
		//JButton btn1=new JButton("买家信息");
		btn1.setBackground(Color.gray);
		btn1.setOpaque(true);
		Font f2 = new Font("黑体",Font.PLAIN,15);
		btn1.setFont(f2);
		btn1.setForeground(Color.black);
		btn2=new JButton("查询售卖");
		btn2.setBackground(Color.white);
		btn3=new JButton("发布求购");
		btn3.setBackground(Color.white);
		btn20=new JButton("删除求购");
		btn20.setBackground(Color.white);


		//JButton btn4=new JButton("卖家信息");		btn4.setBackground(Color.gray);
		btn4.setOpaque(true);
		btn4.setFont(f2);
		btn4.setForeground(Color.black);
		btn4.setBackground(Color.gray);
		btn5=new JButton("查询求购");
		btn5.setBackground(Color.white);
		btn6=new JButton("发布售卖");
		btn6.setBackground(Color.white);
		btn21=new JButton("删除售卖");
		btn21.setBackground(Color.white);
		btn7=new JButton("反馈信息");
		btn7.setBackground(Color.gray);
		btn7.setOpaque(true);
		Font f3 = new Font("黑体",Font.PLAIN,15);
		btn1.setFont(f3);
		btn1.setForeground(Color.black);
		btn8=new JButton("用户反馈");
		btn8.setBackground(Color.white);


		//创建右部的显示面板
		pan1=new JPanel();
		pan1.setBackground(Color.white);
		pan1.setOpaque(true);
		pan1.setLayout(null);
		pan1.setBounds(190,60,550,320);

		JLabel label1=new JLabel("买家信息");
		label1.setBackground(Color.pink);
		label1.setOpaque(true);
		Font f4 = new Font("黑体",Font.PLAIN,15);
		label1.setFont(f4);
		label1.setForeground(Color.black);
		label1.setBounds(0, 0, 550, 35);

		JTextField text1=new JTextField();
		text1.setBounds(20, 40, 200, 25);

		JButton button1=new JButton("搜索");
		button1.setBackground(Color.gray);
		button1.setBounds(250, 40, 80, 25);

		JTextArea text2=new JTextArea("表格");
		text2.setBounds(0, 80, 550, 220);
		text2.setBackground(Color.pink);

		pan1.add(label1);
		pan1.add(text1);
		pan1.add(button1);
		pan1.add(text2);
		pan1.setVisible(false);
		
		//创建右部的显示面板
		pan2=new JPanel();
		pan2.setBackground(Color.white);
		pan2.setOpaque(true);
		pan2.setLayout(null);
		pan2.setBounds(190,60,550,320);
		pan2.setVisible(false);
		
		JLabel label2=new JLabel("卖家信息");
		label2.setBackground(Color.pink);
		label2.setOpaque(true);

		Font f5 = new Font("黑体",Font.PLAIN,15);
		label2.setFont(f5);
		label2.setForeground(Color.black);
		label2.setBounds(0, 0, 550, 35);

		JTextField text3=new JTextField();
		text1.setBounds(20, 40, 200, 25);

		JButton button2=new JButton("搜索");
		button1.setBackground(Color.gray);
		button1.setBounds(250, 40, 80, 25);

		JTextArea text4=new JTextArea("表格");
		text4.setBounds(0, 80, 550, 220);
		text4.setBackground(Color.pink);


		pan2.add(label2);
		pan2.add(text3);
		pan2.add(button2);
		pan2.add(text4);
		pan2.setVisible(false);
		
		//发布售卖信息panel
		
		pan3 = new panetest();
		pan3.setBackground(Color.pink);
		pan3.setOpaque(true);
		pan3.setLayout(null);
		pan3.setBounds(190,60,550,320);
		pan3.setVisible(false);
      
		pan4 = new panel2();
		pan4.setBackground(Color.pink);
		pan4.setOpaque(true);
		pan4.setLayout(null);
		pan4.setBounds(190,60,550,320);
		pan4.setVisible(false);
		
		//绝对定位按钮的位置和按钮的大小
		lab1.setBounds(0, 0, 800, 40);
		btn1.setBounds(60, 70, 100, 25);
		btn2.setBounds(60, 100, 100, 25);
		btn3.setBounds(60, 130, 100, 25);
		btn20.setBounds(60, 160, 100, 25);
		btn4.setBounds(60, 190, 100, 25);
		btn5.setBounds(60, 220, 100, 25);
		btn6.setBounds(60, 250, 100, 25);
		btn21.setBounds(60, 280, 100, 25);
		btn7.setBounds(60, 310, 100, 25);
		btn8.setBounds(60, 340, 100, 25);


		//将按钮添加到容器中
		jpanel.add(lab1);
		jpanel.add(btn1);
		jpanel.add(btn2);
		jpanel.add(btn3);
		jpanel.add(btn20);
		jpanel.add(btn4);
		jpanel.add(btn5);
		jpanel.add(btn6);
		jpanel.add(btn21);
		jpanel.add(btn7);
		jpanel.add(btn8);

		jpanel.add(pan1);
		jpanel.add(pan2);
		jpanel.add(pan3);
		jpanel.add(pan4);
		
    
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗体结束应用程序
		//设置窗体大小
		setSize(800,440);
		//设置窗体可见
		setVisible(true);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn20.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn21.addActionListener(this);
		btn7.addActionListener(this);
		btn8.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new UserMain();

	}

	@Override
	public void actionPerformed(ActionEvent e) {


		//int count=this.getContentPane().getComponentCount();//10个
		//System.out.println(count);
		if(e.getSource() == btn1)
		{	
			//System.out.println(1);
			pan1.setVisible(true);
			pan2.setVisible(false);
			pan3.setVisible(false);
			pan4.setVisible(false);
		}
		if(e.getSource()==btn2)
		{
			
			
		}
		if(e.getSource()==btn3)
		{
			//System.out.println(1);
			pan1.setVisible(false);
			pan2.setVisible(false);
			pan3.setVisible(true);
			pan4.setVisible(false);
			
		}
		if(e.getSource()==btn20)
		{
			
			
		}
		if(e.getSource() == btn4)
		{
			//System.out.println(1);
			pan1.setVisible(false);
			pan2.setVisible(true);
			pan3.setVisible(false);
			pan4.setVisible(false);
			/*//this.getContentPane().repaint();
			System.out.println(1);
			this.getContentPane().repaint();
			for(int i=0;i<count;i++){
				Object obj= this.getContentPane().getComponent(i);
				if(obj instanceof JPanel){
					((JPanel)obj).removeAll();					
				}
			}*/

		}
		if(e.getSource()==btn5)
		{
			
			
		}
		if(e.getSource()==btn6)
		{
			//System.out.println(1);
			pan1.setVisible(false);
			pan2.setVisible(false);
			pan3.setVisible(true);
			pan4.setVisible(false);
		}
		if(e.getSource()==btn21)
		{
			
			
		}
		if(e.getSource()==btn7)
		{
			
			pan1.setVisible(false);
			pan2.setVisible(false);
			pan3.setVisible(false);
			pan4.setVisible(true);
		}
		if(e.getSource()==btn8)
		{
			pan1.setVisible(false);
			pan2.setVisible(false);
			pan3.setVisible(false);
			pan4.setVisible(true);
			
		}
	}
	
			
		
	}
