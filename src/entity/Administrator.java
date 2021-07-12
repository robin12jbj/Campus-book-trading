package entity;

import com.sun.rowset.CachedRowSetImpl;
import util.Jdbcs;

import java.sql.SQLException;
import java.util.Date;

/**
 * @author Mike_hsj
 */
public class Administrator {
    /**
     * the id of Administrator
     */
    private int administratorId;
    /**
     * the code of Administrator
     */
    private String administratorCode;
    /**
     * deposit resultSet
     */
    private CachedRowSetImpl rowSet;
    /**
     *
     * @param administratorId the id of Administrator
     * @param administratorCode the code of Administrator
     */
    public Administrator(int administratorId,String administratorCode){
        this.administratorId=administratorId;
        this.administratorCode=administratorCode;
    }

    /**
     * check user's message
     * @return rowSet
     */
    public CachedRowSetImpl checkUser(){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check user list
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from user");
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
     * check selling message
     * @return rowSet
     */
    public CachedRowSetImpl checkSell(){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check user list
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from sale");
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
     * check buying message
     * @return rowSet
     */
    public CachedRowSetImpl checkBuy(){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check user list
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from need");
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
     * update user's message
     * @param userId user's id
     * @param userName user's name
     * @param userSex user's sex
     * @param userContact the contact of user
     * @return rowSet
     */
    public CachedRowSetImpl updateUser(int userId,String userName,String userSex,String userContact){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //update user list
            linkDatabase.statement.executeUpdate("update user set userName='"+userName+"',userSex='"
                    +userSex+"',userContact='"+userContact+"'where userId="+userId);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from user");
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
     * delete the user message
     * @param userId user's id
     * @return rowSet
     */
    public CachedRowSetImpl deleteUser(int userId){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //delete user's message from user list
            linkDatabase.statement.executeUpdate("delete from user where userId="+userId);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from user");
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
     * update buying message
     * @param buyNo the number of buying message
     * @param buyerNo buyer's id
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @param bookPressTime book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice expected price
     * @param bookDetail detail
     * @param buyContact the contact of buyer
     * @return rowSet
     */
    public CachedRowSetImpl updateBuyMessage(int buyNo, int buyerNo, String bookName, BookType bookType, String bookPress,
                                             String bookAuthor, Date bookPressTime, Date messagePressTime, double expectedPrice,
                                             String bookDetail, String buyContact){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //update buying message
            linkDatabase.statement.executeUpdate("update need set buyerNo="+buyerNo+",bookName='"
                    +bookName+"',bookType='"+bookType.toString()+"',bookPress='"+bookPress+"',bookAuthor='"+bookAuthor+"',bookPressTime='"
                    +bookPressTime.toString()+"',messagePressTime='"+messagePressTime.toString()+"',expectedPrice="+expectedPrice+",bookDetail='"
                    +bookDetail+"',buyContact='"+buyContact+"' where buyNo="+buyNo);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from need");
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
     * delete buying message
     * @param buyNo the number of selling message
     * @return rowSet
     */
    public CachedRowSetImpl deleteBuyMessage(int buyNo){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check seller's selling message from sale list
            linkDatabase.statement.executeUpdate("delete from need where buyNo="+buyNo);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from need");
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
     * update selling message
     * @param sellNo the number of buying message
     * @param sellerNo buyer's id
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @param bookPressTime book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice expected price
     * @param bookDetail detail
     * @param sellContact the contact of buyer
     * @return rowSet
     */
    public CachedRowSetImpl updateSellMessage(int sellNo, int sellerNo, String bookName, BookType bookType, String bookPress,
                                             String bookAuthor, Date bookPressTime, Date messagePressTime, double expectedPrice,
                                             String bookDetail, String sellContact){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //update buying message
            linkDatabase.statement.executeUpdate("update sale set sellerNo="+sellerNo+",bookName='"
                    +bookName+"',bookType='"+bookType.toString()+"',bookPress='"+bookPress+"',bookAuthor='"+bookAuthor+"',bookPressTime='"
                    +bookPressTime.toString()+"',messagePressTime='"+messagePressTime.toString()+"',expectedPrice="+expectedPrice+",bookDetail='"+bookDetail+
                    "',sellContact='"+sellContact+"' where sellNo="+sellNo);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from sale");
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
     * delete selling message
     * @param sellNo the number of selling message
     * @return rowSet
     */
    public CachedRowSetImpl deleteSellMessage(int sellNo){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check seller's selling message from sale list
            linkDatabase.res=linkDatabase.statement.executeQuery("delete from sale where sellNo="+sellNo);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from sale");
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
     * check user's feedback message
     * @return rowSet
     */
    public CachedRowSetImpl checkFeedBack(){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check user's feedback message from feedback list
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from feedback");
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
     * answer user's feedback message
     * @param feedbackId feedback message's Id
     * @param answer administrator's answer
     * @return rowSet
     */
    public CachedRowSetImpl feedbackAnswer(int feedbackId,String answer){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //answer user's feedback message
            linkDatabase.statement.executeUpdate("update feedback set Reply='"+answer+"' , state=true where FeedbackId="+feedbackId);
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from feedback");
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
     * get the id of administrator
     * @return administratorId
     */
    public int getAdministratorId() {
        return administratorId;
    }

    /**
     * get the code of administrator
     * @return administratorCode
     */
    public String getAdministratorCode() {
        return administratorCode;
    }

    /**
     * set the code of administrator
     * @param administratorCode the code of administrator
     */
    public void setAdministratorCode(String administratorCode) {
        this.administratorCode = administratorCode;
    }
}
