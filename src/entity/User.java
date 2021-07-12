package entity;

import com.sun.rowset.CachedRowSetImpl;
import util.Jdbcs;

import java.sql.SQLException;

/**
 * @author Mike_hsj
 */
public class User {
    /**
     * user's id
     */
    private int userId;
    /**
     * user's code
     */
    private String userCode;
    /**
     * user's truly name
     */
    private String userName;
    /**
     * user's sex
     */
    private String userSex;
    /**
     * the way to contact user
     */
    private String userContact;
    /**
     * deposit resultSet
     */
    private CachedRowSetImpl rowSet;
    /**
     *
     * @param userId user's id
     * @param userCode user's code
     * @param userName user's truly name
     * @param userSex user's sex
     * @param userContact the way to contact user
     */
    public User(int userId,String userCode,String userName,String userSex,String userContact){
        this.userId=userId;
        this.userCode=userCode;
        this.userName=userName;
        this.userSex=userSex;
        this.userContact=userContact;
    }
    public CachedRowSetImpl addFeedBack(int UserNumber,int AdministratorNumber,String feedbackInfo,boolean state){
        try {
            //link database
            Jdbcs linkDatabase = new Jdbcs();
            rowSet=new CachedRowSetImpl();
            //check seller's selling message from sale list
            linkDatabase.statement.executeUpdate("insert into Feedback values("+UserNumber+","+AdministratorNumber+
                    ",'"+feedbackInfo+"',"+null+","+state+","+null+")");
            linkDatabase.res=linkDatabase.statement.executeQuery("select * from Feedback where userId="+UserNumber);
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
     * get user's Id
     * @return userId
     */
    public int getUserId(){
        return userId;
    }

    /**
     * get user's code
     * @return userCode
     */
    public String getUserCode(){
        return userCode;
    }

    /**
     * get user's name
     * @return userName
     */
    public String getUserName(){
        return userName;
    }

    /**
     * get user's sex
     * @return userSex
     */
    public String getUserSex(){
        return  userSex;
    }

    /**
     * get user's contact
     * @return userContact
     */
    public String getUserContact(){
        return  userContact;
    }

    /**
     * set user's Code
     * @param userCode user's code
     */
    public void setUserCode(String userCode){
        this.userCode=userCode;
    }

    /**
     * set user's name
     * @param userName user's name
     */
    public void setUserName(String userName){
        this.userName=userName;
    }

    /**
     * set user's sex
     * @param userSex user's sex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * set user's contact
     * @param userContact user's contact
     */
    public void setUserContact(String userContact){
        this.userContact=userContact;
    }
}
