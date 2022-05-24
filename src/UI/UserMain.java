package UI;

import entity.Buyer;
import entity.Seller;
import entity.User;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMain extends JFrame implements ActionListener {


    private final Font font;
    //买家信息，查询售卖，发布求购，
    //买家信息->个人求购信息表展示，选择行，删除求购
    //查询售卖->输入书名，书种类，出版社，作者
    //发布求购->书名，书种类，出版社，作者，预期价格，备注，发布时间，书籍出版时间，求购者联系方式


    //卖家信息，查询求购，发布售卖，删除售卖
    //卖家信息->个人售卖信息表展示，选择行，删除售卖
    //查询求购-输入书名，书种类，出版社，作者，展示相对应的求购信息表
    //发布售卖->书名，书种类，出版社，作者，预期价格，备注，发布时间，书籍出版时间，售卖者联系方式
    JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10;
    //反馈信息，用户反馈
    //用户反馈->输入反馈意见，并提交
    JButton button1, button2, button3, button4, button5;
    //过程中注册监听者
    //button1:查询售卖界面的确认按钮
    //button2:发布求购界面的确认按钮，
    //button3:查询求购界面的确认按钮
    //button4:发布售卖界面的确认按钮，
    //button5:用户反馈界面的确认按钮
    //btn1-10代表左侧10个按钮
    ButtonGroup buttonGroup;
    JRadioButton j1, j2, j3, j4;
    User user;
    Buyer buyer;
    Seller seller;
    ResultSet res;
    JTextField[] text = new JTextField[11];//用来放置读取的Jtable内容
    JTextField[] text2 = new JTextField[3];//text2为买家、卖家查询界面的3个输入文本框+type选择
    JTextField[] text3 = new JTextField[12];//text3为买家、卖家发布求购、售卖信息界面的12个文本框
    JLabel[] lab15 = new JLabel[15];//15个标签对应12个上图文本框+type选择+年月日+年月日：9+6
    //9个标签分别对应顺序：书籍种类，图书名称，出版社，图书作者，出版日期，发布日期，预期价格，图书备注，联系方式
    //6个标签对应"年","月","日"
    //15个标签，12个文本框，1个选择框
    JTextArea answer;//answer为用户反馈界面文本区域
    //JLabel[] lab = new JLabel[11];//
    //JLabel[] lab2 = new JLabel[4];
    //11个标签代表求购、售卖修改界面左侧标签,lab3->用户管理界面中，修改标签，
    JComboBox type;
    private JPanel pan2, pan3;
    private ImagePanel pan1;
    private JTable jt;
    private JScrollPane jp;


    public UserMain(int UserId, String UserCode) {
        font = new Font("宋体", Font.PLAIN, 15);
        setResizable(false);
        setSize(1300, 500);
        this.setLocationRelativeTo(null);
        user = new User(UserId, UserCode);
        buyer = new Buyer(user.getUserId(), user.getUserCode());
        seller = new Seller(user.getUserId(), user.getUserCode());

        //pan2.setFont(font);
        //pan3.setFont(font);
        this.setVisible(true);
        this.setIconImage(new ImageIcon("./images/book.png").getImage());
        type = new JComboBox();
        type.setModel(new DefaultComboBoxModel(new String[]{"ECO", "POL", "PHI", "PHY", "CHE", "BIO", "HIS", "GEO", "ENT"}));

        setTitle("校园图书二手交易客户端");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pan1 = new ImagePanel(new Dimension(this.getWidth(), this.getHeight()), new ImageIcon("./images/Main.png").getImage());
        pan1.setBorder(new EmptyBorder(5, 5, 5, 5));
        pan1.setFont(font);
        setContentPane(pan1);
        pan1.setLayout(null);
        lab15[0] = new JLabel("书籍种类");
        lab15[1] = new JLabel("图书名称");
        lab15[2] = new JLabel("出版社");
        lab15[3] = new JLabel("图书作者");
        lab15[4] = new JLabel("出版日期");
        lab15[5] = new JLabel("发布日期");
        lab15[6] = new JLabel("预期价格");
        lab15[7] = new JLabel("图书备注");
        lab15[8] = new JLabel("联系方式");
        lab15[9] = new JLabel("年");
        lab15[10] = new JLabel("月");
        lab15[11] = new JLabel("日");
        lab15[12] = new JLabel("年");
        lab15[13] = new JLabel("月");
        lab15[14] = new JLabel("日");
        //实例化15个标签
        for (int i = 0; i < 12; i++) {
            text3[i] = new JTextField("", 30);//实例化12个文本框
        }

        btn1 = new JButton("买家信息");
        btn1.setBackground(Color.LIGHT_GRAY);
        btn1.setBounds(26, 75, 93, 30);
        pan1.add(btn1);
        btn1.addActionListener(this);

        btn2 = new JButton("查询售卖");
        btn2.setBackground(Color.WHITE);
        btn2.setBounds(26, 105, 93, 30);
        pan1.add(btn2);
        btn2.addActionListener(this);

        btn3 = new JButton("发布求购");
        btn3.setBackground(Color.WHITE);
        btn3.setBounds(26, 135, 93, 30);
        pan1.add(btn3);
        btn3.addActionListener(this);
        //按钮组上下间隔10 按钮高30
        btn4 = new JButton("删除求购");
        btn4.setBackground(Color.WHITE);
        btn4.setBounds(26, 165, 93, 30);
        pan1.add(btn4);
        btn4.addActionListener(this);

        btn5 = new JButton("卖家信息");
        btn5.setBackground(Color.LIGHT_GRAY);
        btn5.setBounds(26, 205, 93, 30);
        pan1.add(btn5);
        btn5.addActionListener(this);

        btn6 = new JButton("查询求购");
        btn6.setBackground(Color.WHITE);
        btn6.setBounds(26, 235, 93, 30);
        pan1.add(btn6);
        btn6.addActionListener(this);

        btn7 = new JButton("发布售卖");
        btn7.setBackground(Color.WHITE);
        btn7.setBounds(26, 265, 93, 30);
        pan1.add(btn7);
        btn7.addActionListener(this);

        btn8 = new JButton("删除售卖");
        btn8.setBackground(Color.WHITE);
        btn8.setBounds(26, 295, 93, 30);
        pan1.add(btn8);
        btn8.addActionListener(this);

        btn9 = new JButton("反馈信息");
        btn9.setBackground(Color.LIGHT_GRAY);
        btn9.setBounds(26, 335, 93, 30);
        pan1.add(btn9);
        btn9.addActionListener(this);

        btn10 = new JButton("用户反馈");
        btn10.setBackground(Color.WHITE);
        btn10.setBounds(26, 365, 93, 30);
        pan1.add(btn10);
        btn10.addActionListener(this);

        /*btn11 = new JButton("反馈处理");
        btn11.setBackground(Color.WHITE);
        btn11.setBounds(26, 405, 93, 30);
        pan1.add(btn11);
        btn11.addActionListener(this);*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn1)//用户的买家信息,个人求购表,已完成
        {
            //j1:书名按钮;j2:类型按钮
            //j3:出版社按钮;j4:作者按钮
            //初始化JTable
            pan2 = new JPanel();
            String[] columnName = {"求购编号", "求购者账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "求购信息发布日期", "预期价格", "备注", "求购者联系方式"};
            Object[][] cellData = {};
            DefaultTableModel model = new DefaultTableModel(cellData, columnName);
            jt = new JTable(model);
            jp = new JScrollPane(jt);
            String[] data = new String[11];
            res = buyer.checkMyBuyMessage(buyer.getUserId());
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
                        data[9] = res.getString(10);
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
        if (e.getSource() == btn2)//查询售卖，新增界面，已完成
        {
            removepane();
            pan3 = new JPanel();
            pan3.setBounds(400, 75, 500, 330);
            pan3.setLayout(null);
            button1 = new JButton("查询");
            pan3.add(button1);
            button1.addActionListener(this);
            button1.setBounds(360, 130, 60, 20);
            pan1.revalidate();
            type.setBounds(150, 170, 120, 30);
            pan3.add(type);
            buttonGroup = new ButtonGroup();
            j1 = new JRadioButton("以书名搜索");
            j2 = new JRadioButton("以类型搜索");
            j3 = new JRadioButton("以出版社搜索");
            j4 = new JRadioButton("以作者搜索");
            buttonGroup.add(j1);
            buttonGroup.add(j2);
            buttonGroup.add(j3);
            buttonGroup.add(j4);
            pan3.add(j1);
            pan3.add(j2);
            pan3.add(j3);
            pan3.add(j4);
            j1.setBounds(20, 50, 120, 30);
            j4.setBounds(20, 90, 120, 30);
            j3.setBounds(20, 130, 120, 30);
            j2.setBounds(20, 170, 120, 30);
            for (int i = 0; i < 3; i++) {
                text2[i] = new JTextField("", 30);
                pan3.add(text2[i]);
                text2[i].setBounds(150, 50 + i * 40, 120, 30);
            }

            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();


        }
        if (e.getSource() == button1)//查询售卖的确认按钮,已完成
        {
            pan2 = new JPanel();
            String[] columnName = {"售卖编号", "售卖者账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "售卖信息发布日期", "预期价格", "备注", "售卖者联系方式"};
            Object[][] cellData = {};
            DefaultTableModel model = new DefaultTableModel(cellData, columnName);
            jt = new JTable(model);
            jp = new JScrollPane(jt);
            String[] data = new String[11];

            if (j1.isSelected()) {//以书名搜索
                res = buyer.sellCheck(text2[0].getText(), null, null, null);
            } else if (j2.isSelected()) {//以类型搜索
                res = buyer.sellCheck(null, type.getSelectedItem().toString(), null, null);
            } else if (j3.isSelected()) {//以出版社搜索
                res = buyer.sellCheck(null, null, text2[2].getText(), null);
            } else if (j4.isSelected()) {//以作者搜索
                res = buyer.sellCheck(null, null, null, text2[1].getText());
            }

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
                        data[9] = res.getString(10);
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

        if (e.getSource() == btn3)//发布求购
        {
            removepane();
            pan3 = new JPanel();
            pan3.setBounds(147, 75, 800, 330);
            pan3.setLayout(null);
            for (int i = 0; i < 9; i++) {
                pan3.add(lab15[i]);
                lab15[i].setBounds(150, 20 + i * 30, 120, 20);//绘制左侧9个标签内容
                lab15[i].setFont(new Font("宋体", Font.BOLD, 15));
            }
            for (int i = 0; i < 12; i++) {
                text3[i].setText("");//删除文本框内的记录数据
            }
            type.setBounds(280, 20, 160, 20);
            //绘制右侧文本框位置
            text3[0].setBounds(280, 50, 160, 20);//图书名称
            text3[1].setBounds(280, 80, 160, 20);//出版社
            text3[2].setBounds(280, 110, 160, 20);//图书作者


            text3[3].setBounds(280, 140, 60, 20);//年 出版日期
            text3[4].setBounds(350, 140, 40, 20);//月
            text3[5].setBounds(400, 140, 40, 20);//日
            text3[6].setBounds(280, 170, 60, 20);//年 信息发布日期
            text3[7].setBounds(350, 170, 40, 20);//月
            text3[8].setBounds(400, 170, 40, 20);//日

            text3[9].setBounds(280, 200, 160, 20);//预期价格
            text3[10].setBounds(280, 230, 160, 20);//图书备注
            text3[11].setBounds(280, 260, 160, 20);//联系方式

            lab15[9].setBounds(340, 140, 50, 20);
            lab15[10].setBounds(390, 140, 50, 20);
            lab15[11].setBounds(440, 140, 50, 20);

            lab15[12].setBounds(340, 170, 50, 20);
            lab15[13].setBounds(390, 170, 50, 20);
            lab15[14].setBounds(440, 170, 50, 20);
            button2 = new JButton("确认发布");
            button2.setBounds(500, 170, 100, 50);
            pan3.add(button2);
            button2.addActionListener(this);
            for (int i = 9; i <= 14; i++) {
                pan3.add(lab15[i]);
            }
            for (int i = 0; i < 12; i++) {
                pan3.add(text3[i]);

            }

            pan3.add(type);

           /* for(int i=4;i<8;i++){
                text3[i]=new JTextField("",30);
                pan3.add(text3[i]);
                text3[i].setBounds(290,10+(i-4)*40,120,30);
            }*/
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();

        }
        if (e.getSource() == button2)//发布求购确认按钮，已完成
        {
            String bookPressTime = text3[3].getText() + "-" + text3[4].getText() + "-" + text3[5].getText();
            String messagePressTime = text3[6].getText() + "-" + text3[7].getText() + "-" + text3[8].getText();
            boolean f = buyer.addBuyMessage(buyer.getUserId(), text3[0].getText(), type.getSelectedItem().toString(), text3[1].getText(),
                    text3[2].getText(), bookPressTime, messagePressTime, Float.parseFloat(text3[9].getText()),
                    text3[10].getText(), text3[11].getText());
            if (f) {
                JOptionPane.showMessageDialog(null, "发布求购成功！");

            }

        }

        if (e.getSource() == btn4)//删除求购,已完成
        {
            int a = JOptionPane.showConfirmDialog(null, "是否确认删除");
            if (a == 0)
                //是
                //buyer.deleteBuyMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()));
                buyer.deleteMySellMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()), buyer.getUserId());

        }


        if (e.getSource() == btn5)//用户的卖家信息，返回一张该用户发布的售卖信息记录，已实现
        {
            //初始化JTable
            pan2 = new JPanel();
            String[] columnName = {"售卖编号", "售卖者账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "售卖信息发布日期", "预期价格", "备注", "售卖者联系方式"};
            Object[][] cellData = {};
            DefaultTableModel model = new DefaultTableModel(cellData, columnName);
            jt = new JTable(model);
            jp = new JScrollPane(jt);
            String[] data = new String[11];
            res = seller.checkMySellMessage(seller.getUserId());
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
                        data[9] = res.getString(10);
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
        if (e.getSource() == btn6)//用户卖家，查询求购,已完成
        {
            removepane();
            pan3 = new JPanel();
            pan3.setBounds(400, 75, 500, 330);
            pan3.setLayout(null);
            button3 = new JButton("查询");
            pan3.add(button3);
            button3.addActionListener(this);
            button3.setBounds(360, 130, 60, 20);
            pan1.revalidate();
            type.setBounds(150, 170, 120, 30);
            pan3.add(type);
            buttonGroup = new ButtonGroup();
            j1 = new JRadioButton("以书名搜索");
            j2 = new JRadioButton("以类型搜索");
            j3 = new JRadioButton("以出版社搜索");
            j4 = new JRadioButton("以作者搜索");
            buttonGroup.add(j1);
            buttonGroup.add(j2);
            buttonGroup.add(j3);
            buttonGroup.add(j4);
            pan3.add(j1);
            pan3.add(j2);
            pan3.add(j3);
            pan3.add(j4);
            j1.setBounds(20, 50, 120, 30);
            j4.setBounds(20, 90, 120, 30);
            j3.setBounds(20, 130, 120, 30);
            j2.setBounds(20, 170, 120, 30);
            for (int i = 0; i < 3; i++) {
                text2[i] = new JTextField("", 30);
                pan3.add(text2[i]);
                text2[i].setBounds(150, 50 + i * 40, 120, 30);
            }

            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();
        }
        if (e.getSource() == button3)//卖家查询求购确认按钮,已完成
        {
            pan2 = new JPanel();
            String[] columnName = {"求购编号", "求购账号", "图书名称", "图书类型", "图书出版社", "图书作者", "图书出版日期", "求购发布日期", "预期价格", "备注", "求购联系方式"};
            Object[][] cellData = {};
            DefaultTableModel model = new DefaultTableModel(cellData, columnName);
            jt = new JTable(model);
            jp = new JScrollPane(jt);
            String[] data = new String[11];

            if (j1.isSelected()) {//以书名搜索
                res = seller.buyCheck(text2[0].getText(), null, null, null);
            } else if (j2.isSelected()) {//以类型搜索
                res = seller.buyCheck(null, type.getSelectedItem().toString(), null, null);
            } else if (j3.isSelected()) {//以出版社搜索
                res = seller.buyCheck(null, null, text2[2].getText(), null);
            } else if (j4.isSelected()) {//以作者搜索
                res = seller.buyCheck(null, null, null, text2[1].getText());
            }

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
                        data[9] = res.getString(10);
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


        if (e.getSource() == btn7)//卖家发布售卖信息，已完成
        {
            removepane();
            pan3 = new JPanel();
            pan3.setBounds(147, 75, 800, 330);
            pan3.setLayout(null);
            for (int i = 0; i < 9; i++) {
                pan3.add(lab15[i]);
                lab15[i].setBounds(150, 20 + i * 30, 120, 20);//绘制左侧9个标签内容
                lab15[i].setFont(new Font("宋体", Font.BOLD, 15));
            }
            for (int i = 0; i < 12; i++) {
                text3[i].setText("");//删除文本框内的记录数据
            }
            type.setBounds(280, 20, 160, 20);
            //绘制右侧文本框位置
            text3[0].setBounds(280, 50, 160, 20);
            text3[1].setBounds(280, 80, 160, 20);
            text3[2].setBounds(280, 110, 160, 20);


            text3[3].setBounds(280, 140, 60, 20);//年
            text3[4].setBounds(350, 140, 40, 20);//月
            text3[5].setBounds(400, 140, 40, 20);//日
            text3[6].setBounds(280, 170, 60, 20);
            text3[7].setBounds(350, 170, 40, 20);
            text3[8].setBounds(400, 170, 40, 20);

            text3[9].setBounds(280, 200, 160, 20);
            text3[10].setBounds(280, 230, 160, 20);
            text3[11].setBounds(280, 260, 160, 20);

            lab15[9].setBounds(340, 140, 50, 20);
            lab15[10].setBounds(390, 140, 50, 20);
            lab15[11].setBounds(440, 140, 50, 20);

            lab15[12].setBounds(340, 170, 50, 20);
            lab15[13].setBounds(390, 170, 50, 20);
            lab15[14].setBounds(440, 170, 50, 20);
            button4 = new JButton("确认发布");
            button4.setBounds(500, 170, 100, 50);
            pan3.add(button4);
            button4.addActionListener(this);
            for (int i = 9; i <= 14; i++) {
                pan3.add(lab15[i]);
            }
            for (int i = 0; i < 12; i++) {
                pan3.add(text3[i]);

            }

            pan3.add(type);

           /* for(int i=4;i<8;i++){
                text3[i]=new JTextField("",30);
                pan3.add(text3[i]);
                text3[i].setBounds(290,10+(i-4)*40,120,30);
            }*/
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();
        }
        if (e.getSource() == button4)//发布售卖确认按钮，已完成
        {
            String bookPressTime = text3[3].getText() + "-" + text3[4].getText() + "-" + text3[5].getText();
            String messagePressTime = text3[6].getText() + "-" + text3[7].getText() + "-" + text3[8].getText();
            boolean f = seller.addSellMessage(buyer.getUserId(), text3[0].getText(), type.getSelectedItem().toString(), text3[1].getText(),
                    text3[0].getText(), bookPressTime, messagePressTime, Float.parseFloat(text3[9].getText()),
                    text3[10].getText(), text3[11].getText());
            if (f) {
                JOptionPane.showMessageDialog(null, "发布售卖成功！");

            }
        }

        if (e.getSource() == btn8)//卖家删除售卖，已完成
        {
            int a = JOptionPane.showConfirmDialog(null, "是否确认删除");
            if (a == 0)
                //是
                //buyer.deleteBuyMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()));
                //buyer.deleteMySellMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()),buyer.getUserId());
                seller.deleteMySellMessage(Integer.parseInt(jt.getValueAt(jt.getSelectedRow(), 0).toString()), buyer.getUserId());
            //卖家删除个人的售卖信息
        }

        if (e.getSource() == btn9)//反馈信息，返回与用户有关的feedback表信息，已完成
        {


            //初始化JTable
            pan2 = new JPanel();
            String[] columnName = {"反馈序号", "用户账号", "管理员账号", "管理员回复", "反馈状态", "用户反馈信息"};
            Object[][] cellData = {};
            DefaultTableModel model = new DefaultTableModel(cellData, columnName);
            jt = new JTable(model);
            jp = new JScrollPane(jt);
            String[] data = new String[6];
            res = user.checkFeedBack(user.getUserId());
            while (true) {
                try {
                    if (res.next()) {
                        data[0] = String.valueOf(res.getInt(1));
                        data[1] = String.valueOf(res.getInt(2));
                        data[2] = String.valueOf(res.getInt(3));
                        data[3] = res.getString(4);
                        data[4] = res.getString(5);
                        data[5] = res.getString(6);
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
        if (e.getSource() == btn10)//用户反馈信息填写界面,已完成
        {
            pan3 = new JPanel();
            JLabel title = new JLabel("反馈信息填写：");
            title.setBounds(50, 0, 150, 50);
            title.setFont(new Font("微软雅黑", Font.BOLD, 20));
            pan3.add(title);
            pan3.setBounds(147, 75, 800, 330);
            pan3.setLayout(null);
            button5 = new JButton("提交反馈");
            pan3.add(button5);
            button5.addActionListener(this);
            button5.setBounds(80, 260, 100, 20);
            answer = new JTextArea(6, 30);
            answer.setBounds(10, 50, 400, 200);
            answer.setFont(new Font("宋体", Font.PLAIN, 15));
            pan3.add(answer);
            //jp.setVisible(false);
            pan1.revalidate();
            removepane();
            pan1.add(pan3);
            pan3.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.blue));
            pan3.repaint();
            pan3.revalidate();
            pan1.revalidate();
        }

        //用户反馈界面提交按钮确定，已完成
        if (e.getSource() == button5) {
            try {
                user.addFeedBack(user.getUserId(), answer.getText(), false);
                JOptionPane.showMessageDialog(null, "反馈意见提交成功！");
            } catch (Exception e1) {
                JOptionPane.showMessageDialog(null, "反馈意见提交失败");
            }

            //执行数据库更改语句，插入反馈信息


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

    class ImagePanel extends JPanel {
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