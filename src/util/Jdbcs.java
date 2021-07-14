package util;

import java.sql.*;

public class Jdbcs {
    public Connection con = null;
    public Statement statement = null;
    public ResultSet res = null;
    String driver = "com.mysql.cj.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    String name = "root";
    String passwd = "123456";


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


}
 