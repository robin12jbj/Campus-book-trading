package entity;

import com.sun.rowset.CachedRowSetImpl;
import util.Jdbcs;


import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author Mike_hsj
 */
public class Seller extends User{
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
    public Seller(int userId, String userCode, String userName, String userSex, String userContact) {
        super(userId, userCode, userName, userSex, userContact);
    }

    /**
     * check book buying message
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @return rowSet
     */
    public CachedRowSetImpl buyCheck(String bookName, BookType bookType, String bookPress, String bookAuthor){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check need list
            if (bookName!=null)
                linkDatabase.res=linkDatabase.statement.executeQuery("select * from need where bookName="+bookName);
            else if (bookType!=null)
                linkDatabase.res=linkDatabase.statement.executeQuery("select * from need where bookType="+bookType);
            else if (bookPress!=null)
                linkDatabase.res=linkDatabase.statement.executeQuery("select * from need where bookPress="+bookPress);
            else if(bookAuthor!=null)
                linkDatabase.res=linkDatabase.statement.executeQuery("select * from need where bookAuthor="+bookAuthor);
            else
            {
                JOptionPane.showMessageDialog(null,"搜索异常，不能搜索条件为空的图书求购信息");
            }
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSet;
    }

    /**
     * add new sell message
     * @param sellNo the number of book selling message
     * @param sellerNo the id of seller
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @param bookPressTime book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice expected price
     * @param bookDetail detail
     * @param sellContact the contact of seller
     * @return rowSet
     */
    public CachedRowSetImpl addSellMessage(int sellNo, int sellerNo, String bookName, BookType bookType, String bookPress, String bookAuthor,
                                           Date bookPressTime, Date messagePressTime, double expectedPrice, String bookDetail, String sellContact){
        try{
            //link database
            Jdbcs linkDatabase =new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //insert new sell message
            linkDatabase.statement.executeUpdate("insert into sale values("+sellNo+","+ sellerNo +
                    ",'"+bookName+"','"+bookType.toString()+"','"+bookPress+"','"+bookAuthor+"',"+bookPressTime+","
                    +messagePressTime+","+expectedPrice+",'"+bookDetail+"','"+sellContact+"')");
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from sale where sellerNo="+ sellerNo);
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return rowSet;
    }

    /**
     * check seller's book selling message
     * @param sellerNo seller's id
     * @return rowSet
     */
    public CachedRowSetImpl checkMySellMessage(int sellerNo){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check seller's selling message from sale list
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from sale where sellerNo="+sellerNo);
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSet;
    }

    /**
     * delete seller's selling message
     * @param sellNo the number of selling message
     * @param sellerNo the id of seller
     * @return rowSet
     */
    public CachedRowSetImpl deleteMySellMessage(int sellNo,int sellerNo){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //delete seller's selling message from sale list
            linkDatabase.statement.executeUpdate("delete from sale where sellNo="+sellNo);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from sale where sellerNo="+sellerNo);
            //full up rowSet
            rowSet.populate(linkDatabase.res);
            //link close
            linkDatabase.res.close();
            linkDatabase.statement.close();
            linkDatabase.con.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return rowSet;
    }
}
