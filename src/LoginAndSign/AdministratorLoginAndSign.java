package LoginAndSign;

import util.Jdbcs;

import javax.swing.*;
import java.sql.SQLException;

public class AdministratorLoginAndSign extends Jdbcs {
    public AdministratorLoginAndSign(){
    super();
    }

    /**
     *
     * @param AccountNumber 管理员账号
     * @param Password 管理员密码
     * @param Key 正确激活码为KQF2H284RW
     * @return 返回是否成功注册
     */
    public boolean Sign(int AccountNumber,String Password,String Key ){
        boolean f=false;
        if(Key.equals("KQF2H284RW")){
            String sql="insert into admin values("+AccountNumber+",'"+Password+"','"+Key+"')";
            try {
                int a = statement.executeUpdate(sql);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "管理员注册成功！");
                    f=true;
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "该管理员账号已存在，请重新输入！");
                e.printStackTrace();
            }

        }else{
            JOptionPane.showMessageDialog(null, "密钥错误，请重新输入！");
        }
        return f;
    }
    public boolean Login(int AccountNumber,String Password){
        boolean f=false;
    String sql="select *from admin where AccountNumber="+AccountNumber;
    try{
        res=statement.executeQuery(sql);
        if (res.next()) {
            String pa = res.getString(2);
            if (pa.equals(Password)) {
                f = true;
                JOptionPane.showMessageDialog(null, "管理员登录成功！");
            } else {
                JOptionPane.showMessageDialog(null, "管理员密码错误！请重新输入密码！");
            }
        }else {
            JOptionPane.showMessageDialog(null, "用户不存在！请重新输入账号！");
        }
    }catch (SQLException e){
        e.printStackTrace();
    }
    return f;
    }
}
