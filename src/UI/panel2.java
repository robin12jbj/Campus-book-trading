package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class panel2 extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public panel2() {
		setBackground(Color.PINK);
		this.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u53CD    \u9988    \u4FE1    \u606F    \u586B    \u5199");
		lblNewLabel.setFont(new Font("楷体", Font.ITALIC, 18));
		lblNewLabel.setBackground(Color.PINK);
		lblNewLabel.setBounds(37, 13, 459, 43);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(37, 107, 470, 102);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u53CD\u9988\uFF1A");
		lblNewLabel_1.setFont(new Font("方正舒体", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel_1.setBounds(36, 57, 107, 27);
		add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setBounds(91, 241, 113, 27);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88\r\n");
		btnNewButton_1.setBounds(338, 241, 113, 27);
		add(btnNewButton_1);
	}
}
