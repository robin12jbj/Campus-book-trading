package LoginAndSign;

import util.Jdbcs;

import javax.swing.*;
import java.sql.SQLException;

public class AdministratorLoginAndSign extends Jdbcs {
    public AdministratorLoginAndSign() {
        super();
    }

    /**
     * @param AccountNumber 管理员账号
     * @param Password      管理员密码
     * @param Key           正确激活码为KQF2H284RW
     * @return 返回是否成功注册
     */
    public boolean Sign(int AccountNumber, String Password, String Key){
        boolean f=false;
        String sql="insert into admin values("+AccountNumber+",'"+Password+"')";
        try {
            int a=statement.executeUpdate(sql);
            if(a==1){
                JOptionPane.showMessageDialog(null,"管理员注册成功！");
                f=true;
            }
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"管理员账号存在，请重新输入账号！");
            e.printStackTrace();
        }
        try {
            statement.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "数据库关闭出现异常！");
        }
        return  f;
    }

    public boolean Login(int AccountNumber, String Password) {
        boolean f = false;
        String sql = "select *from admin where AccountNumber=" + AccountNumber;
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(2);
                if (pa.equals(Password)) {
                    f = true;
                    JOptionPane.showMessageDialog(null, "管理员登录成功！");
                } else {
                    JOptionPane.showMessageDialog(null, "管理员密码错误！请重新输入密码！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "管理员不存在！请重新输入账号！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //不管执行成功与否，都进行关闭数据库连接操作
        try {
            res.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "数据库关闭出现异常！");
        }
        return f;
    }
}
