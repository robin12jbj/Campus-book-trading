package UI;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class panetest extends JPanel {
    private JTextField textField;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_1;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;

    /**
     * Create the panel.
     */
    public panetest() {
        this.setLayout(null);

        JLabel lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u79F0\r\n");
        lblNewLabel.setBounds(144, 35, 72, 18);
        add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(230, 32, 190, 24);
        add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("\u56FE\u4E66\u7C7B\u578B");
        lblNewLabel_1.setBounds(144, 66, 72, 18);
        add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("\u51FA\u7248\u793E");
        lblNewLabel_2.setBounds(144, 97, 72, 18);
        add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("\u56FE\u4E66\u4F5C\u8005");
        lblNewLabel_3.setBounds(144, 128, 72, 18);
        add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("\u51FA\u7248\u65E5\u671F");
        lblNewLabel_4.setBounds(144, 158, 72, 18);
        add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("发布日期");
        lblNewLabel_5.setBounds(144, 189, 72, 18);
        add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("\u9884\u671F\u4EF7\u683C");//7
        lblNewLabel_6.setBounds(144, 217, 72, 18);
        add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("\u56FE\u4E66\u5907\u6CE8");
        lblNewLabel_7.setBounds(144, 248, 72, 18);
        add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("\u8054\u7CFB\u65B9\u5F0F\r\n");//9
        lblNewLabel_8.setBounds(144, 279, 72, 18);
        add(lblNewLabel_8);

        textField_2 = new JTextField();
        textField_2.setBounds(230, 94, 190, 24);
        add(textField_2);
        textField_2.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(230, 125, 190, 24);
        add(textField_3);
        textField_3.setColumns(10);

        textField_4 = new JTextField();
        textField_4.setBounds(230, 155, 72, 24);
        add(textField_4);
        textField_4.setColumns(10);

        textField_5 = new JTextField();
        textField_5.setBounds(230, 186, 72, 24);
        add(textField_5);
        textField_5.setColumns(10);

        textField_6 = new JTextField();
        textField_6.setBounds(230, 214, 190, 24);
        add(textField_6);
        textField_6.setColumns(10);

        textField_7 = new JTextField();
        textField_7.setBounds(230, 245, 190, 24);
        add(textField_7);
        textField_7.setColumns(10);

        textField_8 = new JTextField();
        textField_8.setBounds(230, 276, 190, 24);
        add(textField_8);
        textField_8.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"ECO", "POL", "PHI", "PHY", "CHE", "BIO", "HIS", "GEO", "ENT"}));
        comboBox.setBounds(230, 63, 190, 24);
        add(comboBox);

        JLabel lblNewLabel_9 = new JLabel("\u5E74");
        lblNewLabel_9.setBounds(304, 189, 15, 18);
        add(lblNewLabel_9);

        JLabel lblNewLabel_10 = new JLabel("\u6708");
        lblNewLabel_10.setBounds(353, 189, 15, 18);
        add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("\u65E5\r\n");
        lblNewLabel_11.setBounds(405, 189, 15, 18);
        add(lblNewLabel_11);

        textField_1 = new JTextField();
        textField_1.setBounds(320, 186, 32, 24);
        add(textField_1);
        textField_1.setColumns(10);

        textField_9 = new JTextField();
        textField_9.setBounds(372, 186, 32, 24);
        add(textField_9);
        textField_9.setColumns(10);

        JLabel lblNewLabel_12 = new JLabel("\u5E74");
        lblNewLabel_12.setBounds(304, 158, 15, 18);
        add(lblNewLabel_12);

        textField_10 = new JTextField();
        textField_10.setBounds(320, 155, 32, 24);
        add(textField_10);
        textField_10.setColumns(10);

        JLabel lblNewLabel_13 = new JLabel("\u6708");
        lblNewLabel_13.setBounds(353, 158, 15, 18);
        add(lblNewLabel_13);

        textField_11 = new JTextField();
        textField_11.setBounds(372, 155, 32, 24);
        add(textField_11);
        textField_11.setColumns(10);

        JLabel lblNewLabel_14 = new JLabel("\u65E5");
        lblNewLabel_14.setBounds(405, 158, 15, 18);
        add(lblNewLabel_14);
    }
}
