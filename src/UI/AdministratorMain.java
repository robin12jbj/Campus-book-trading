package UI;

import entity.Administrator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdministratorMain extends JFrame {

	private JPanel contentPane;
	private JTable jt;
	private JScrollPane jp;

	//从数据库中取出信息
	//rowData用来存放行数据
	//columnNames存放列名

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
		Administrator administrator= new Administrator(LoginInterface.getAccountNumber(),LoginInterface.getPassWord());
		ResultSet res;

		String[] columnName ={"账号","密码","真实姓名","性别","联系方式"};
		Object[][] cellData={};
		DefaultTableModel model=new DefaultTableModel(cellData, columnName);
		jt = new JTable(model);
		jp = new JScrollPane(jt);
		String[] data=new String[5];
		res=administrator.checkUser();
		while (true){
			try {
				if(res.next()){
					data[0]= String.valueOf(res.getInt(1));
					data[1]=res.getString(2);
					data[2]=res.getString(3);
					data[3]=res.getString(4);
					data[4]=res.getString(5);
					model.addRow(data);
				}
				else break;
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("校园图书二手交易系统后台管理");
		lblNewLabel.setBounds(10, 10, 218, 15);
		contentPane.add(lblNewLabel);

		//初始化JTable
		jp.setBounds(147, 90, 395, 243);
		contentPane.add(jp);

		JButton btnNewButton = new JButton("图书求购");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(26, 63, 93, 29);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("修改");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(26, 90, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(26, 111, 93, 23);
		contentPane.add(btnNewButton_2);

		JButton button = new JButton("图书售卖");
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(26, 148, 93, 29);
		contentPane.add(button);

		JButton button_1 = new JButton("修改");
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(26, 175, 93, 23);
		contentPane.add(button_1);

		JButton button_2 = new JButton("删除");
		button_2.setBackground(Color.WHITE);
		button_2.setBounds(26, 196, 93, 23);
		contentPane.add(button_2);

		JButton button_3 = new JButton("用户管理");
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.setBounds(26, 244, 93, 29);
		contentPane.add(button_3);

		JButton button_4 = new JButton("修改");
		button_4.setBackground(Color.WHITE);
		button_4.setBounds(26, 271, 93, 23);
		contentPane.add(button_4);

		JButton button_5 = new JButton("删除");
		button_5.setBackground(Color.WHITE);
		button_5.setBounds(26, 292, 93, 23);
		contentPane.add(button_5);

		JButton button_6 = new JButton("反馈处理");
		button_6.setBackground(Color.LIGHT_GRAY);
		button_6.setBounds(26, 325, 93, 29);
		contentPane.add(button_6);

		JButton button_7 = new JButton("反馈处理");
		button_7.setBackground(Color.WHITE);
		button_7.setBounds(26, 352, 93, 23);
		contentPane.add(button_7);
	}
}