package entity;

import java.util.Date;

/**
 * @author Mike_hsj
 */
public class BookSell extends Book{
    /**
     * the number of book selling message
     */
    private int sellNo;
    /**
     * the contact of seller
     */
    private String sellContact;
    /**
     * the id of seller
     */
    private int sellerId;
    /**
     *
     * @param sellNo the number of book selling message
     * @param sellerId the id of seller
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @param bookPressTime book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice expected price
     * @param bookDetail detail
     * @param sellContact the contact of seller
     */
    BookSell(int sellNo,int sellerId,String bookName, BookType bookType, String bookPress, String bookAuthor,
             Date bookPressTime, Date messagePressTime, double expectedPrice, String bookDetail,String sellContact) {
        super(bookName, bookType, bookPress, bookAuthor, bookPressTime, messagePressTime, expectedPrice, bookDetail);
        this.sellNo=sellNo;
        this.sellerId=sellerId;
        this.sellContact=sellContact;
    }

    /**
     * get the contact of seller
     * @return sellContact
     */
    public String getSellContact() {
        return sellContact;
    }

    /**
     * set the contact of seller
     * @param sellContact the contact of seller
     */
    public void setSellContact(String sellContact) {
        this.sellContact = sellContact;
    }

    /**
     * get the number of book selling message
     * @return sellNo
     */
    public int getSellNo() {
        return sellNo;
    }

    /**
     * get the id of seller
     * @return sellerId
     */
    public int getSellerId() {
        return sellerId;
    }
}
