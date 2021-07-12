package UI;

import entity.Administrator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AdministratorMain extends JFrame implements ActionListener {

	private JPanel pan1, pan2;
	private JTable jt;
	private JScrollPane jp;
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11;
	Administrator administrator = new Administrator(LoginInterface.getAccountNumber(), LoginInterface.getPassWord());
	ResultSet res;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratorMain frame = new AdministratorMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AdministratorMain() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 500);
		pan1 = new JPanel();
		pan1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pan1);
		pan1.setLayout(null);

		JLabel lblNewLabel = new JLabel("校园图书二手交易系统后台管理");
		lblNewLabel.setBounds(10, 10, 218, 15);
		pan1.add(lblNewLabel);


		btn1 = new JButton("图书求购");
		btn1.setBackground(Color.LIGHT_GRAY);
		btn1.setBounds(26, 63, 93, 29);
		pan1.add(btn1);
		btn1.addActionListener(this);

		btn2 = new JButton("修改");
		btn2.setBackground(Color.WHITE);
		btn2.setBounds(26, 90, 93, 23);
		pan1.add(btn2);
		btn2.addActionListener(this);

		btn3 = new JButton("删除");
		btn3.setBackground(Color.WHITE);
		btn3.setBounds(26, 111, 93, 23);
		pan1.add(btn3);
		btn3.addActionListener(this);

		btn4 = new JButton("图书售卖");
		btn4.setBackground(Color.LIGHT_GRAY);
		btn4.setBounds(26, 148, 93, 29);
		pan1.add(btn4);
		btn4.addActionListener(this);

		btn5 = new JButton("修改");
		btn5.setBackground(Color.WHITE);
		btn5.setBounds(26, 175, 93, 23);
		pan1.add(btn5);
		btn5.addActionListener(this);

		btn6 = new JButton("删除");
		btn6.setBackground(Color.WHITE);
		btn6.setBounds(26, 196, 93, 23);
		pan1.add(btn6);
		btn6.addActionListener(this);

		btn7 = new JButton("用户管理");
		btn7.setBackground(Color.LIGHT_GRAY);
		btn7.setBounds(26, 244, 93, 29);
		pan1.add(btn7);
		btn7.addActionListener(this);

		btn8 = new JButton("修改");
		btn8.setBackground(Color.WHITE);
		btn8.setBounds(26, 271, 93, 23);
		pan1.add(btn8);
		btn8.addActionListener(this);

		btn9 = new JButton("删除");
		btn9.setBackground(Color.WHITE);
		btn9.setBounds(26, 292, 93, 23);
		pan1.add(btn9);
		btn9.addActionListener(this);

		btn10 = new JButton("用户反馈");
		btn10.setBackground(Color.LIGHT_GRAY);
		btn10.setBounds(26, 325, 93, 29);
		pan1.add(btn10);
		btn10.addActionListener(this);

		btn11 = new JButton("反馈处理");
		btn11.setBackground(Color.WHITE);
		btn11.setBounds(26, 352, 93, 23);
		pan1.add(btn11);
		btn11.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn1) {
			System.out.println(1);
			//初始化JTable	
			String[] columnName = {"求购编号", "求购者账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "售卖信息发布日期", "预期价格", "备注", "求购者联系方式",};
			Object[][] cellData = {};
			DefaultTableModel model = new DefaultTableModel(cellData, columnName);
			jt = new JTable(model);
			jp = new JScrollPane(jt);
			String[] data = new String[11];
			res = administrator.checkBuy();
			while (true) {
				try {
					if (res.next()) {
						data[0] = String.valueOf(res.getInt(1));
						data[1] = String.valueOf(res.getFloat(2));
						data[2] = res.getString(3);
						data[3] = res.getString(4);
						data[4] = res.getString(5);
						data[5] = res.getString(6);
						data[6] = String.valueOf(res.getDate(7));
						data[7] = String.valueOf(res.getDate(8));
						data[8] = res.getString(9);
						data[9] = String.valueOf(res.getInt(10));
						data[10] = res.getString(11);
						model.addRow(data);
					} else break;
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			//String[] columnName ={"求购编号","求购者账号","图书名称","图书类型","图书出版社","图书作者","出版日期","发布日期","预期求购价格","图书信息备注","求购者联系方式",};
			//Object[][] cellData={};
			//DefaultTableModel model=new DefaultTableModel(cellData, columnName);
			//jt = new JTable(model);
			//jp = new JScrollPane(jt);
			removepane();

			pan2 = new JPanel();
				pan2.setBounds(147, 70, 1100, 300);
				pan2.setLayout(null);
				jp.setBounds(0, 0, 1100, 300);
				//jt.getColumnModel().getColumn(10).setPreferredWidth(110);
				pan2.add(jp);
				pan1.add(pan2);
			}
			if (e.getSource() == btn4) {
				System.out.println(1);
				//初始化JTable
				String[] columnName = {"售卖编号", "售卖者账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "售卖信息发布日期", "预期价格", "图书相关信息", "售卖者联系方式"};
				Object[][] cellData = {};
				DefaultTableModel model = new DefaultTableModel(cellData, columnName);
				jt = new JTable(model);
				jp = new JScrollPane(jt);
				String[] data = new String[11];
				res = administrator.checkSell();
				while (true) {
					try {
						if (res.next()) {
							data[0] = String.valueOf(res.getInt(1));
							data[1] = String.valueOf(res.getFloat(2));
							data[2] = res.getString(3);
							data[3] = res.getString(4);
							data[4] = res.getString(5);
							data[5] = res.getString(6);
							data[6] = String.valueOf(res.getDate(7));
							data[7] = String.valueOf(res.getDate(8));
							data[8] = res.getString(9);
							data[9] = String.valueOf(res.getInt(10));
							data[10] = res.getString(11);
							model.addRow(data);
						} else break;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//String[] columnName ={"售卖编号","售卖者账号","图书名称","图书类型","图书出版社","图书作者","图书出版日期","售卖信息发布日期","售卖预期价格","图书相关信息","售卖者联系方式"};
				//Object[][] cellData={};
				//DefaultTableModel model=new DefaultTableModel(cellData, columnName);
				//jt = new JTable(model);
				//jp = new JScrollPane(jt);
				removepane();
				pan2 = new JPanel();
				/*jt.getColumnModel().getColumn(6).setPreferredWidth();
				jt.getColumnModel().getColumn(7).setPreferredWidth(100);
				jt.getColumnModel().getColumn(8).setPreferredWidth(100);
				jt.getColumnModel().getColumn(9).setPreferredWidth(100);
				jt.getColumnModel().getColumn(10).setPreferredWidth(100);*/
				pan2.setBounds(147, 70, 1100, 300);
				jp.setBounds(0, 0, 1100, 300);
				pan2.add(jp);
				pan1.add(pan2);
			}
			if (e.getSource() == btn7) {
				System.out.println(1);
				//初始化JTable
				String[] columnName = {"账号", "密码", "真实姓名", "性别", "联系方式"};
				Object[][] cellData = {};
				DefaultTableModel model = new DefaultTableModel(cellData, columnName);
				jt = new JTable(model);
				jp = new JScrollPane(jt);
				String[] data = new String[5];
				res = administrator.checkUser();
				while (true) {
					try {
						if (res.next()) {
							data[0] = String.valueOf(res.getInt(1));
							data[1] = res.getString(2);
							data[2] = res.getString(3);
							data[3] = res.getString(4);
							data[4] = res.getString(5);
							model.addRow(data);
						} else break;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//String[] columnName ={"账号","密码","真实姓名","性别","联系方式"};
				//Object[][] cellData={};
				//DefaultTableModel model=new DefaultTableModel(cellData, columnName);
				//jt = new JTable(model);
				//jp = new JScrollPane(jt);
				removepane();
				pan2 = new JPanel();
				pan2.setBounds(147, 70, 800, 300);
				jp.setBounds(0, 0, 800, 300);
				pan2.add(jp);
				pan1.add(pan2);
			}
			if (e.getSource() == btn10) {
				System.out.println(1);
				//初始化JTable
				String[] columnName = {"反馈信息编号", "管理员账号", "用户反馈信息", "管理员回复", "处理状态", "用户状态"};
				Object[][] cellData = {};
				DefaultTableModel model = new DefaultTableModel(cellData, columnName);
				jt = new JTable(model);
				jp = new JScrollPane(jt);
				String[] data = new String[6];
				res = administrator.checkFeedBack();
				while (true) {
					try {
						if (res.next()) {
							data[0] = String.valueOf(res.getInt(1));
							data[1] = String.valueOf(res.getInt(2));
							data[2] = res.getString(3);
							data[3] = res.getString(4);
							data[4] = String.valueOf(res.getBoolean(5));
							data[5] = String.valueOf(res.getInt(6));
							model.addRow(data);
						} else break;
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//String[] columnName ={"反馈信息编号","管理员账号","用户反馈信息","管理员回复","处理状态","用户状态"};
				//Object[][] cellData={};
				//DefaultTableModel model=new DefaultTableModel(cellData, columnName);
				//jt = new JTable(model);
				//jp = new JScrollPane(jt);
				removepane();
				pan2 = new JPanel();
				pan2.setBounds(147, 70, 800, 300);
				jp.setBounds(0, 0, 800, 300);
				pan2.add(jp);
				pan1.add(pan2);
			}

		}
		private void removepane(){
			int count=pan1.getComponentCount();
			pan1.repaint();
			for(int i=0;i<count;i++){
				Object obj= pan1.getComponent(i);
				if(obj instanceof JPanel){
					remove((JPanel)obj);
				}
			}

		}
	}