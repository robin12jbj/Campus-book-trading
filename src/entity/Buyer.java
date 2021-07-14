package entity;

import com.sun.rowset.CachedRowSetImpl;
import util.Jdbcs;

import javax.swing.*;
import java.sql.SQLException;

/**
 * @author Mike_hsj
 */
public class Buyer extends User {
    /**
     * deposit resultSet
     */
    private CachedRowSetImpl rowSet;

    /**
     * @param userId      user's id
     * @param userCode    user's code
     * @param userName    user's truly name
     * @param userSex     user's sex
     * @param userContact the way to contact user
     */
    public Buyer(int userId, String userCode, String userName, String userSex, String userContact) {
        super(userId, userCode, userName, userSex, userContact);
    }

    public Buyer(int userId, String userCode) {
        super(userId, userCode);
    }

    /**
     * check book selling message
     *
     * @param bookName   book name
     * @param bookType   book type
     * @param bookPress  book publishing house
     * @param bookAuthor book author
     * @return rowSet
     */
    //买家查询售卖表
    public CachedRowSetImpl sellCheck(String bookName, String bookType, String bookPress, String bookAuthor) {
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet = new CachedRowSetImpl();
            //check need list
            if (bookName != null)
                linkDatabase.res = linkDatabase.statement.executeQuery("select * from sale where bookName='" + bookName + "'");
            else if (bookType != null)
                linkDatabase.res = linkDatabase.statement.executeQuery("select * from sale where bookType='" + bookType + "'");
            else if (bookPress != null)
                linkDatabase.res = linkDatabase.statement.executeQuery("select * from sale where bookPress='" + bookPress + "'");
            else if (bookAuthor != null)
                linkDatabase.res = linkDatabase.statement.executeQuery("select * from sale where bookAuthor='" + bookAuthor + "'");
            else {
                JOptionPane.showMessageDialog(null, "搜索异常，不能搜索条件为空的图书求购信息");
            }
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSet;
    }

    /**
     * add the book buying message
     *
     * @param buyerNo          the id of buyer
     * @param bookName         book name
     * @param bookType         book type
     * @param bookPress        book publishing house
     * @param bookAuthor       book author
     * @param bookPressTime    book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice    expected price
     * @param bookDetail       detail
     * @param buyContact       the contact of buyer
     * @return rowSet
     */
    //买家发布个人求购信息
    public boolean addBuyMessage(int buyerNo, String bookName, String bookType, String bookPress, String bookAuthor,
                                 String bookPressTime, String messagePressTime, double expectedPrice, String bookDetail, String buyContact) {
        boolean f = false;
        try {


            Jdbcs linkDatabase = new Jdbcs();

            linkDatabase.statement.executeUpdate("insert into need values(" + null + "," + buyerNo +
                    ",'" + bookName + "','" + bookType + "','" + bookPress + "','" + bookAuthor + "','" + bookPressTime + "','"
                    + messagePressTime + "'," + expectedPrice + ",'" + bookDetail + "','" + buyContact + "')");
            f = true;
            linkDatabase.statement.close();
            linkDatabase.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;

    }


    //买家查看个人的求购记录表
    public CachedRowSetImpl checkMyBuyMessage(int buyerNo) {
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet = new CachedRowSetImpl();
            //check seller's selling message from sale list
            linkDatabase.res = linkDatabase.statement.executeQuery("select * from need where buyerNo=" + buyerNo);
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSet;
    }

    /**
     * delete buyer's buying message
     *
     * @param buyNo   the number of selling message
     * @param buyerNo the id of buyer
     * @return rowSet
     */
    //买家删除个人求购信息
    public CachedRowSetImpl deleteMySellMessage(int buyNo, int buyerNo) {
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet = new CachedRowSetImpl();
            //check seller's selling message from sale list
            linkDatabase.statement.executeUpdate("delete from need where buyNo=" + buyNo);
            linkDatabase.res = linkDatabase.statement.executeQuery("select * from need where buyerNo=" + buyerNo);
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSet;
    }
}
