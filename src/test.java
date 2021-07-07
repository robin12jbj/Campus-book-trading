import java.sql.*;

public class test {
    public static void main(String[] args) {
        //声明Connection对象
        Connection con;
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名test
        String url = "jdbc:mysql://localhost:3306/test";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
        //遍历查询结果集
        try {
            //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            con = DriverManager.getConnection(url, user, password);
            if (!con.isClosed())
                System.out.println("Succeeded connecting to the Database!");
            //2.创建statement类对象，用来执行SQL语句！！
            Statement statement = con.createStatement();
            //要执行的SQL语句
            String sql = "select * from User";
            //3.ResultSet类，用来存放获取的结果集！！
            ResultSet rs = statement.executeQuery(sql);
            System.out.println("--------------------------------------");
            System.out.println("执行结果如下所示:");
            System.out.println("------------------------");
            System.out.println("账号" + "\t" + "密码" + "\t" + "  姓名  " + "\t" + "性别" + "电话号码");
            System.out.println("--------------------------------------");

            String accountnumber;
            String accountpassword;
            String sex;
            String tel;
            String name;
            while (rs.next()) {
                //获取number这列数据
                accountnumber = rs.getString(1);
                //获取password这列数据
                accountpassword = rs.getString(2);
                //获取name这列数据
                name = rs.getString(3);
                //获取sex这列数据
                sex = rs.getString(4);
                //获取age这列数据
                tel = rs.getString(5);
                //输出结果
                System.out.println(accountnumber + "\t" + accountpassword + "\t" + name + "\t" + sex + "\t" + tel);
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException e) {
            //数据库驱动类异常处理
            System.out.println("Sorry,can`t find the Driver!");
            e.printStackTrace();
        } catch (SQLException e) {
            //数据库连接失败异常处理
            e.printStackTrace();
        } finally {
            System.out.println("数据库数据成功获取！！");
        }
    }

}

