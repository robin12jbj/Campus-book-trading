package entity;

import util.Jdbcs;
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
     *
     * @param userId user's id
     * @param userCode user's code
     * @param userName user's truly name
     * @param userSex user's sex
     * @param userContact the way to contact user
     */
    User(int userId,String userCode,String userName,String userSex,String userContact){
        this.userId=userId;
        this.userCode=userCode;
        this.userName=userName;
        this.userSex=userSex;
        this.userContact=userContact;
        Jdbcs d =new Jdbcs();
        //d.insert(userId,userCode,userName,userSex,userContact);
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
     * set user's Id
     * @param userId user's id
     */
    public  void setUserId(int userId){
        this.userId=userId;
    }
}
