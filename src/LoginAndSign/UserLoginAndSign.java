package LoginAndSign;

import util.Jdbcs;

import javax.swing.*;
import java.sql.SQLException;

public class UserLoginAndSign extends Jdbcs{
    public UserLoginAndSign(){
    super();

    }
    public boolean Sign(int AccountNumber,String Password,String Name,String Sex,String Tel ){
        boolean f=false;
    String sql="insert into user values("+AccountNumber+",'"+Password+"','"+Name+"','"+Sex+"','"+Tel+"')";
        try {
            int a = statement.executeUpdate(sql);
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "注册成功！");
                f=true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "对不起该用户账号已被占用！请重新输入！");
            e.printStackTrace();
        }
        //不管执行成功与否，都进行关闭数据库连接操作
        try{

            statement.close();
            con.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "关闭数据库出现异常！");
        }
        return  f;
    }
    public boolean Login(int AccountNumber,String Password){
    boolean f=false;
        String sql = "select * from user where AccountNumber=" + AccountNumber;
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(2);
                if (pa.equals(Password)) {
                    f = true;
                    JOptionPane.showMessageDialog(null, "用户登录成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "用户密码错误！请重新输入密码！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户不存在！请重新输入账号！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try{
            res.close();
            statement.close();
            con.close();

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "关闭数据库出现异常！");
        }


        return f;
    }
}