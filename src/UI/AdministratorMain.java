package UI;

import entity.Administrator;
import entity.BookType;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class AdministratorMain extends JFrame implements ActionListener {


    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, button1, button2, button3, button4;

    //btn1-11代表左侧11个按钮，button1-3代表求购、售卖、用户管理进行修改时的提交按钮,button4为回复反馈信息确认按钮
    JLabel aimId;
    JLabel aimUserId;
    Administrator administrator;
    ResultSet res;
    JTextField[] text = new JTextField[11];
    JTextField[] text2 = new JTextField[4];//text2为用户管理修改界面的4个文本框
    JTextArea answer;
    JLabel[] lab = new JLabel[11];
    JLabel[] lab2 = new JLabel[11];
    JLabel[] lab3 = new JLabel[4];
    //11个标签代表求购、售卖修改界面左侧标签,lab->求购，lab2->售卖,lab3->用户管理界面中，修改标签，
    JComboBox type;

    private JPanel pan2;
    private final ImagePanel pan1;
    private JTable jt;

    public AdministratorMain(int AccountNumber, String Password) {
        setResizable(false);
        setSize(1300, 500);
        this.setLocationRelativeTo(null);
        administrator = new Administrator(AccountNumber, Password);
        this.setVisible(true);
        this.setIconImage(new ImageIcon("./images/book.png").getImage());
        type = new JComboBox();
        type.setModel(new DefaultComboBoxModel(new String[]{"ECO", "POL", "PHI", "PHY", "CHE", "BIO", "HIS", "GEO", "ENT"}));
        setTitle("校园图书二手交易系统后台管理");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pan1 = new ImagePanel(new Dimension(this.getWidth(), this.getHeight()), new ImageIcon("./images/Main.png").getImage());
        pan1.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(pan1);
        pan1.setLayout(null);


        btn1 = new JButton("图书求购");
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.setBounds(26, 75, 93, 30);
        pan1.add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("修改");
        btn2.setBackground(Color.WHITE);
        btn2.setBounds(26, 105, 93, 30);
        pan1.add(btn2);
        btn2.addActionListener(this);

        btn3 = new JButton("删除");
        btn3.setBackground(Color.WHITE);
        btn3.setBounds(26, 135, 93, 30);
        pan1.add(btn3);
        btn3.addActionListener(this);
        //按钮组上下间隔10 按钮高30
        btn4 = new JButton("图书售卖");
        btn4.setBackground(Color.LIGHT_GRAY);
        btn4.setBounds(26, 175, 93, 30);
        pan1.add(btn4);
        btn4.addActionListener(this);

        btn5 = new JButton("修改");
        btn5.setBackground(Color.WHITE);
        btn5.setBounds(26, 205, 93, 30);
        pan1.add(btn5);
        btn5.addActionListener(this);

        btn6 = new JButton("删除");
        btn6.setBackground(Color.WHITE);
        btn6.setBounds(26, 235, 93, 30);
        pan1.add(btn6);
        btn6.addActionListener(this);

        btn7 = new JButton("用户管理");
        btn7.setBackground(Color.LIGHT_GRAY);
        btn7.setBounds(26, 275, 93, 30);
        pan1.add(btn7);
        btn7.addActionListener(this);

        btn8 = new JButton("修改");
        btn8.setBackground(Color.WHITE);
        btn8.setBounds(26, 305, 93, 30);
        pan1.add(btn8);
        btn8.addActionListener(this);

        btn9 = new JButton("删除");
        btn9.setBackground(Color.WHITE);
        btn9.setBounds(26, 335, 93, 30);
        pan1.add(btn9);
        btn9.addActionListener(this);

        btn10 = new JButton("用户反馈");
        btn10.setBackground(Color.LIGHT_GRAY);
        btn10.setBounds(26, 375, 93, 30);
        pan1.add(btn10);
        btn10.addActionListener(this);

        btn11 = new JButton("反馈处理");
        btn11.setBackground(Color.WHITE);
        btn11.setBounds(26, 405, 93, 30);
        pan1.add(btn11);
        btn11.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JScrollPane jp;
        if (e.getSource() == btn1)//图书求购显示，完成
        {
            //初始化JTable
            pan2 = new JPanel();
            String[] columnName = {"求购编号", "求购者账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "售卖信息发布日期", "预期价格", "备注", "求购者联系方式"};
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
                        data[1] = String.valueOf(res.getInt(2));
                        data[2] = res.getString(3);
                        data[3] = res.getString(4);
                        data[4] = res.getString(5);
                        data[5] = res.getString(6);
                        data[6] = String.valueOf(res.getDate(7));
                        data[7] = String.valueOf(res.getDate(8));
                        data[8] = res.getString(9);
                        data[9] = String.valueOf(res.getString(10));
                        data[10] = res.getString(11);
                        model.addRow(data);
                    } else break;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            removepane();

            pan2.setBounds(147, 75, 1100, 300);
            pan2.setLayout(null);
            jp.setBounds(0, 0, 1100, 300);
            //jt.getColumnModel().getColumn(10).setPreferredWidth(110);
            pan2.add(jp);
            pan1.add(pan2);
            pan1.revalidate();


        }
        JPanel pan3;
        if (e.getSource() == btn2)//图书求购修改，完成
        {
            pan3 = new JPanel();
            pan3.setBounds(147, 75, 800, 330);
            pan3.setLayout(null);
            button1 = new JButton("提交");
            pan3.add(button1);
            button1.addActionListener(this);
            button1.setBounds(360, 130, 60, 20);
            pan2.setVisible(false);
            //jp.setVisible(false);
            pan1.revalidate();
            lab[0] = new JLabel("求购编号");
            lab[1] = new JLabel("求购者账号");
            lab[2] = new JLabel("图书名称");
            lab[3] = new JLabel("图书类型");
            lab[4] = new JLabel("图书出版社");
            lab[5] = new JLabel("图书作者");
            lab[6] = new JLabel("出版日期");
            lab[7] = new JLabel("发布日期");
            lab[8] = new JLabel("预期求购价格");
            lab[9] = new JLabel("图书信息备注");
            lab[10] = new JLabel("求购者联系方式");
            type.setBounds(180, 94, 100, 20);
            type.setSelectedItem(jt.getValueAt(jt.getSelectedRow(), 3));
            pan3.add(type);

            for (int i = 0; i < 11; i++) {
                text[i] = new JTextField("", 30);
                pan3.add(text[i]);
                pan3.add(lab[i]);
            }
            int index1 = jt.getSelectedRow();//获取选中的行
            for (int i = 0; i < 11; i++) {
                text[i].setText(jt.getValueAt(index1, i).toString());
                text[i].setBounds(180, 4 + 30 * i, 100, 20);
                lab[i].setBounds(50, 4 + 30 * i, 100, 20);
            }
            pan1.remove(pan2);
            pan3.remove(text[3]);
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();


        }
        if (e.getSource() == button1)//修改确认按钮，已实现
        {
            DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqlDate1 = null, sqlDate2 = null;
            try {
                sqlDate1 = new java.sql.Date(sf.parse(text[6].getText()).getTime());
                sqlDate2 = new java.sql.Date(sf.parse(text[7].getText()).getTime());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            try {

                assert sqlDate1 != null;
                administrator.updateBuyMessage(Integer.parseInt(text[0].getText()), Integer.parseInt(text[1].getText()), text[2].getText(),
                            BookType.valueOf(type.getSelectedItem().toString()), text[4].getText(), text[5].getText(), sqlDate1,
                        sqlDate2, Double.parseDouble(text[8].getText()), text[9].getText(), text[10].getText());

                JOptionPane.showMessageDialog(null, "更改成功！");
                pan1.remove(pan2);
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == btn3)//图书求购删除，已完成
        {
            int a = JOptionPane.showConfirmDialog(null, "是否确认删除");
            if (a == 0)
            //是
            {
                administrator.deleteBuyMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()));
            }


        }


        if (e.getSource() == btn4)//图书售卖显示，已完成
        {

            //初始化JTable
            pan2 = new JPanel();
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
                        data[1] = String.valueOf(res.getInt(2));
                        data[2] = res.getString(3);
                        data[3] = res.getString(4);
                        data[4] = res.getString(5);
                        data[5] = res.getString(6);
                        data[6] = String.valueOf(res.getDate(7));
                        data[7] = String.valueOf(res.getDate(8));
                        data[8] = res.getString(9);
                        data[9] = String.valueOf(res.getString(10));
                        data[10] = res.getString(11);
                        model.addRow(data);
                    } else break;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            removepane();

            pan2.setBounds(147, 75, 1100, 300);
            pan2.setLayout(null);
            jp.setBounds(0, 0, 1100, 300);
            //jt.getColumnModel().getColumn(10).setPreferredWidth(110);
            pan2.add(jp);
            pan1.add(pan2);
            pan1.revalidate();
        }
        if (e.getSource() == btn5)//图书售卖修改,已完成
        {

            pan3 = new JPanel();
            pan3.setBounds(147, 75, 800, 330);
            pan3.setLayout(null);
            button2 = new JButton("提交");
            pan3.add(button2);
            button2.addActionListener(this);
            button2.setBounds(360, 130, 60, 20);
            pan2.setVisible(false);
            //jp.setVisible(false);
            pan1.revalidate();
            lab2[0] = new JLabel("售卖编号");
            lab2[1] = new JLabel("售卖者账号");
            lab2[2] = new JLabel("图书名称");
            lab2[3] = new JLabel("图书类型");
            lab2[4] = new JLabel("图书出版社");
            lab2[5] = new JLabel("图书作者");
            lab2[6] = new JLabel("出版日期");
            lab2[7] = new JLabel("发布日期");
            lab2[8] = new JLabel("预期售卖价格");
            lab2[9] = new JLabel("图书信息备注");
            lab2[10] = new JLabel("售卖者联系方式");
            type.setBounds(180, 94, 100, 20);
            type.setSelectedItem(jt.getValueAt(jt.getSelectedRow(), 3));
            pan3.add(type);

            for (int i = 0; i < 11; i++) {
                text[i] = new JTextField("", 30);
                pan3.add(text[i]);
                pan3.add(lab2[i]);
            }
            int index1;//获取选中的行
            index1 = jt.getSelectedRow();
            for (int i = 0; i < 11; i++) {
                text[i].setText(jt.getValueAt(index1, i).toString());
                text[i].setBounds(180, 4 + 30 * i, 100, 20);
                lab2[i].setBounds(50, 4 + 30 * i, 100, 20);
            }
            pan1.remove(pan2);
            pan3.remove(text[3]);
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();
        }
        if (e.getSource() == button2)//修改确认按钮,已完成
        {

            DateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            java.sql.Date sqlDate1 = null, sqlDate2 = null;
            try {
                sqlDate1 = new java.sql.Date(sf.parse(text[6].getText()).getTime());
                sqlDate2 = new java.sql.Date(sf.parse(text[7].getText()).getTime());
            } catch (ParseException parseException) {
                parseException.printStackTrace();
            }
            try {
                assert sqlDate2 != null;
                administrator.updateSellMessage(Integer.parseInt(text[0].getText()), Integer.parseInt(text[1].getText()), text[2].getText(),
                        BookType.valueOf(type.getSelectedItem().toString()), text[4].getText(), text[5].getText(), sqlDate1,
                        sqlDate2, Double.parseDouble(text[8].getText()), text[9].getText(), text[10].getText());
                JOptionPane.showMessageDialog(null, "更改成功！");
                pan1.remove(pan2);
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            }
        }

        if (e.getSource() == btn6)//图书售卖删除，已完成
        {
            int a = JOptionPane.showConfirmDialog(null, "是否确认删除");
            if (a == 0)
            //是
            {
                administrator.deleteSellMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()));
            }
        }


        if (e.getSource() == btn7)//用户管理显示，已完成
        {

            pan2 = new JPanel();
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
                        data[1] = String.valueOf(res.getInt(2));
                        data[2] = res.getString(3);
                        data[3] = res.getString(4);
                        data[4] = res.getString(5);
                        model.addRow(data);
                    } else break;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            removepane();

            //pan2.setBounds(147, 70, 1100, 300);
            pan2.setBounds(147, 75, 800, 300);
            pan2.setLayout(null);
            //jp.setBounds(0, 0, 1100, 300);
            jp.setBounds(0, 0, 800, 300);
            //jt.getColumnModel().getColumn(10).setPreferredWidth(110);
            pan2.add(jp);
            pan1.add(pan2);
            pan1.revalidate();
        }

        if (e.getSource() == btn8)//用户信息修改，已完成
        {
            pan3 = new JPanel();
            pan3.setBounds(147, 75, 800, 330);
            pan3.setLayout(null);
            button3 = new JButton("提交");
            pan3.add(button3);
            button3.addActionListener(this);
            button3.setBounds(80, 130, 60, 20);
            pan2.setVisible(false);
            //jp.setVisible(false);
            pan1.revalidate();
            lab3[0] = new JLabel("用户账号");
            lab3[1] = new JLabel("用户姓名");
            lab3[2] = new JLabel("用户性别");
            lab3[3] = new JLabel("联系方式");


            for (int i = 0; i < 4; i++) {
                text2[i] = new JTextField("", 30);
                pan3.add(text2[i]);
                pan3.add(lab3[i]);
            }
            int index1 = jt.getSelectedRow();//获取选中的行
            for (int i = 0; i < 4; i++) {

                text2[i].setText(jt.getValueAt(index1, i + 1).toString());
                text2[i].setBounds(180, 4 + 30 * i, 100, 20);
                lab3[i].setBounds(50, 4 + 30 * i, 100, 20);
            }
            text2[0].setEnabled(false);
            pan1.remove(pan2);
            //pan3.remove(text2[3]);
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();
        }
        if (e.getSource() == button3)//修改确认按钮，已完成
        {
            try {
                administrator.updateUser(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()), text2[1].getText(),
                        text2[2].getText(), text2[3].getText());
                JOptionPane.showMessageDialog(null, "更改成功！");
                pan1.remove(pan2);
            } catch (NumberFormatException e1) {
                e1.printStackTrace();
            }
        }
        if (e.getSource() == btn9)//用户信息删除，已完成
        {
            int a = JOptionPane.showConfirmDialog(null, "是否确认删除");
            if (a == 0)
            //是
            {
                administrator.deleteUser(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()));
            }
        }


        if (e.getSource() == btn10)//反馈信息显示，已完成
        {
            pan2 = new JPanel();
            String[] columnName = {"反馈信息编号", "用户账号", "管理员账号", "用户反馈信息", "处理状态", "管理员回复"};
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
                        data[3] = res.getString(6);
                        data[4] = res.getString(5);
                        data[5] = res.getString(4);
                        model.addRow(data);
                    } else break;
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            removepane();

            //pan2.setBounds(147, 70, 1100, 300);
            pan2.setBounds(147, 75, 800, 300);
            pan2.setLayout(null);
            //jp.setBounds(0, 0, 1100, 300);
            jp.setBounds(0, 0, 800, 300);
            //jt.getColumnModel().getColumn(10).setPreferredWidth(110);
            pan2.add(jp);
            pan1.add(pan2);
            pan1.revalidate();
        }
        if (e.getSource() == btn11)//反馈回复，事件完成
        {
            aimId = new JLabel("反馈信息编号:");
            aimUserId = new JLabel("反馈用户账号:");
            String FeedbackId = jt.getValueAt(jt.getSelectedRow(), 0).toString();//得到反馈信息编号
            String UserId = jt.getValueAt(jt.getSelectedRow(), 1).toString();//得到用户账号
            aimUserId.setText("To" + aimUserId.getText() + UserId);
            aimId.setText("To" + aimId.getText() + FeedbackId);
            aimUserId.setFont(new Font("微软雅黑", Font.BOLD, 15));
            aimId.setFont(new Font("微软雅黑", Font.BOLD, 15));
            JLabel titlelabel = new JLabel("反馈回复：");
            button4 = new JButton("确认回复");
            button4.addActionListener(this);
            answer = new JTextArea(6, 30);
            pan3 = new JPanel();
            pan3.setBounds(147, 90, 700, 330);
            pan3.setLayout(null);
            pan2.setVisible(false);
            //jp.setVisible(false);
            pan1.revalidate();
            //lab3[0] = new JLabel("用户账号");
            //lab3[1] = new JLabel("用户姓名");
            //[2] = new JLabel("用户性别");

            //获取选中的行
            pan3.add(titlelabel);
            pan3.add(aimId);
            pan3.add(aimUserId);
            pan3.add(answer);
            pan3.add(button4);
            aimId.setBounds(25, 60, 150, 40);
            aimUserId.setBounds(25, 110, 150, 40);
            button4.setBounds(310, 280, 100, 30);
            button4.setFont(new Font("宋体", Font.PLAIN, 15));
            titlelabel.setBounds(5, 20, 150, 30);
            titlelabel.setFont(new Font("宋体", Font.BOLD, 24));
            answer.setBounds(180, 70, 400, 200);
            answer.setFont(new Font("微软雅黑", Font.PLAIN, 20));
            pan1.remove(pan2);
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();
        }
        if (e.getSource() == button4) {
            administrator.feedbackAnswer(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()), answer.getText());
            JOptionPane.showMessageDialog(null, "回复成功！");
        }
    }

    private void removepane() {
        int count = pan1.getComponentCount();
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            Object obj = pan1.getComponent(i);
            if (obj instanceof JPanel) {
                pan1.remove((JPanel) obj);
            }
        }
        pan1.repaint();
        pan1.revalidate();
    }

    static class ImagePanel extends JPanel {
        Dimension d;
        Image image;

        public ImagePanel(Dimension d, Image image) {
            super();
            this.d = d;
            this.image = image;
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, d.width, d.height, this);
            repaint();
        }
    }
}