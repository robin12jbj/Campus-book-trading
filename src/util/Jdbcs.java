package util;

import javax.swing.*;
import java.sql.*;

public class Jdbcs {

    Connection con = null;
    Statement statement = null;
    ResultSet res = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    String name = "root";
    String passwd = "123456";

    public static void main(String[] args) {
        new Jdbcs();
    }

    public Jdbcs() {

        try {
            //加载驱动程序
            Class.forName(driver);
            //连接mysql数据库
            con = DriverManager.getConnection(url, name, passwd);
            statement = con.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("对不起，找不到这个Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //对用户信息的修改实际上就是对密码的修改
    public boolean update(int AccountNumber, String password1, String newpassword) {
        boolean judge = false;
        boolean s = isUser(AccountNumber, password1);
        if (s) {
            String sql = "update user set password='" + newpassword + "' where AccountNumber=" + AccountNumber;
            try {
                int a = statement.executeUpdate(sql);
                if (a == 1) {
                    JOptionPane.showMessageDialog(null, "密码修改成功！");
                    judge = true;
                }
                con.close();
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "密码修改失败！");
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "账号密码信息不匹配，修改失败!");
        }
        return judge;
    }

    //删除用户信息

    public void delete(int AccountNumber, String password) {
        if (isUser(AccountNumber, password)) {
            String sql = "delete from user where AccountNumber=" + AccountNumber + " and password='" + password + "'";
            try {
                int a = statement.executeUpdate(sql);
                con.close();
                statement.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "删除失败!");
                e.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(null, "账号密码不匹配，删除失败!");
        }


    }

    //用户注册功能的实现，用户表中添加数据
    public void insert(int AccountNumber, String password) {
        if (AccountNumber <= 0) {
            JOptionPane.showMessageDialog(null, "注册账号非法，请重新输入！");
            return;
        }
        String sql = "insert into User(AccountNumber,AccountPassword) values('" + AccountNumber + "','" + password + "')";
        try {
            int a = statement.executeUpdate(sql);
            con.close();
            statement.close();
            if (a == 1) {
                JOptionPane.showMessageDialog(null, "注册成功！");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "对不起该账号已被占用！请重新输入！");
            e.printStackTrace();
        }
    }

    //对比用户名和密码是否匹配
    public boolean isUser(int AccountNumber, String password) {
        boolean m = false;
        String sql = "select * from User where AccountNumber=" + AccountNumber;
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(2);
                if (pa.equals(password)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "用户密码错误！请重新输入密码！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "用户不存在！请重新输入账号！");
            }
            res.close();
            con.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }

    public boolean isAdmin(int AccountNumber, String password) {
        boolean f = false;
        String sql = "select *from admin where AccountNumber=" + AccountNumber;
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(2);
                if (pa.equals(password)) {
                    f = true;
                } else {
                    JOptionPane.showMessageDialog(null, "管理员密码错误！请重新输入密码！");
                }

            } else {
                JOptionPane.showMessageDialog(null, "管理员账号不存在！请重新输入账号！");
            }
            res.close();
            con.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return f;
    }
}
 