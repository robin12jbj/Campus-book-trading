package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMain extends JFrame  implements ActionListener {
    JPanel pan,p1,p2,p3,p4,p5,p6,p7;
    JTextField t1,t2,t3,t5,t7;
    JLabel name,namelab,passlab,doublepasslab,sex,information;
    JRadioButton boy,girl;
    JButton confirm,cancel;



    UserMain(){
        this.setTitle("用户主界面");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setSize(new Dimension(600,600));
        Font font = new Font("宋体", Font.BOLD, 15);
        JLabel title=new JLabel("用户主界面",SwingConstants.CENTER);
        title.setOpaque(true);
        //设置标签不透明
        title.setBackground(Color.red);

        this.getContentPane().setLayout(null);
        this.getContentPane().add(title);
        title.setBounds(200,0,200,40);
        this.setResizable(false);//大小固定
        setLocationRelativeTo(null);//界面居中


    }

    /**
     * Invoked when an action occurs.
     *
     * @param e 事件
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static  void main(String args[]){
        new UserMain();
    }
}
