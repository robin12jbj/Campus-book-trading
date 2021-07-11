package UI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class BookAlter extends JPanel implements ActionListener{
	private JTextArea text2;
	JButton btn1,btn2,btn3,btn4,btn20,btn21;

	public void test() {		//定义一个test方法
		JFrame frame=new JFrame("@author 朱旭");
		frame.setSize(800,440);
		//设置窗体大小
		frame.setLocationRelativeTo(null);
		//窗体居中
		//取消布局管理器
		frame.setLayout(null);
		//绝对定位窗体的位置和大小
		frame.setBounds(300,150,0,0); 
			
		//frame.setBounds(300,150,0,0);
		JLabel lab1=new JLabel("校园二手图书交易系统后台管理中心");
		lab1.setBackground(Color.gray);
		lab1.setOpaque(true);
		Font f1 = new Font("黑体",Font.PLAIN,15);
		lab1.setFont(f1);
		lab1.setForeground(Color.black);
		
		//创建按钮组
		JButton btn1=new JButton("买家信息");
		btn1.setBackground(Color.gray);
		btn1.setOpaque(true);
		Font f2 = new Font("黑体",Font.PLAIN,15);
		btn1.setFont(f2);
		btn1.setForeground(Color.black);
		JButton btn2=new JButton("查询售卖");
		btn2.setBackground(Color.white);
		JButton btn3=new JButton("发布求购");
		btn3.setBackground(Color.white);
		JButton btn20=new JButton("删除求购");
		btn20.setBackground(Color.white);

		
		JButton btn4=new JButton("卖家信息");
		btn4.setBackground(Color.gray);
		btn4.setOpaque(true);	
		btn4.setFont(f2);
		btn4.setForeground(Color.black);
		JButton btn5=new JButton("查询求购");
		btn5.setBackground(Color.white);
		JButton btn6=new JButton("发布售卖");
		btn6.setBackground(Color.white);	
		JButton btn21=new JButton("删除售卖");
		btn21.setBackground(Color.white);
	

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
		
		JTextArea text2=new JTextArea("表格");
		text2.setBounds(0, 80, 550, 220);
		text2.setBackground(Color.pink);
		
		pan1.add(label1);
		pan1.add(text1);
		pan1.add(button1);
		pan1.add(text2);
		
		
		
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

		
		//将按钮添加到容器中
		frame.add(lab1);
		frame.add(btn1);
		frame.add(btn2);
		frame.add(btn3);
		frame.add(btn20);
		frame.add(btn4);
		frame.add(btn5);
		frame.add(btn6);
		frame.add(btn21);
		frame.add(pan1);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭窗体结束应用程序
		//设置窗体大小
		frame.setSize(800,440);
		//设置窗体可见
		frame.setVisible(true);
		
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookAlter c= new BookAlter();
		c.test();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn1)
		{
        JDialog frame = new JDialog();//构造一个新的JFrame，作为新窗口。
        frame.setBounds(// 让新窗口与SwingTest窗口示例错开50像素。
                new Rectangle(
                        (int) this.getBounds().getX() + 50,
                        (int) this.getBounds().getY() + 50, 
                        (int) this.getBounds().getWidth(), 
                        (int) this.getBounds().getHeight()
                )
            );
        JLabel jl = new JLabel();// 注意类名。
        frame.getContentPane().add(jl);
        jl.setText("这是新窗口");
        jl.setVerticalAlignment(JLabel.CENTER);
        jl.setHorizontalAlignment(JLabel.CENTER);
     // 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
        frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);    // 设置模式类型。
        frame.setVisible(true);
        }
        if(e.getSource()==btn4);
        {
            JDialog frame = new JDialog();//构造一个新的JFrame，作为新窗口。
            frame.setBounds(// 让新窗口与SwingTest窗口示例错开50像素。
                    new Rectangle(
                            (int) this.getBounds().getX() + 50,
                            (int) this.getBounds().getY() + 50, 
                            (int) this.getBounds().getWidth(), 
                            (int) this.getBounds().getHeight()
                    )
                );
            JLabel jl = new JLabel();// 注意类名。
            frame.getContentPane().add(jl);
            jl.setText("这是新窗口");
            jl.setVerticalAlignment(JLabel.CENTER);
            jl.setHorizontalAlignment(JLabel.CENTER);
         // 参数 APPLICATION_MODAL：阻塞同一 Java 应用程序中的所有顶层窗口（它自己的子层次
            frame.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);    // 设置模式类型。
            frame.setVisible(true);
            }
	}
}