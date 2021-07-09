package entity;

import java.util.Date;

/**
 * @author Mike_hsj
 */
public class BookBuy extends Book{
    /**
     * the number of book buying message
     */
    private int buyNo;
    /**
     * the contact of buyer
     */
    private String buyContact;
    /**
     * the id of buyer
     */
    private int buyerId;
    /**
     *
     * @param buyNo the number of book buying message
     * @param buyerId the id of buyer
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @param bookPressTime book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice expected price
     * @param bookDetail detail
     * @param buyContact the contact of buyer
     */
    BookBuy(int buyNo,int buyerId,String bookName, BookType bookType, String bookPress, String bookAuthor,
            Date bookPressTime, Date messagePressTime, double expectedPrice, String bookDetail,String buyContact) {
        super(bookName, bookType, bookPress, bookAuthor, bookPressTime, messagePressTime, expectedPrice, bookDetail);
        this.buyNo=buyNo;
        this.buyerId=buyerId;
        this.buyContact=buyContact;
    }

    /**
     * get the number of book buying message
     * @return buyNo
     */
    public int getBuyNo() {
        return buyNo;
    }

    /**
     * get the contact of buyer
     * @return buyContact
     */
    public String getBuyContact() {
        return buyContact;
    }

    /**
     * set the contact of buyer
     * @param buyContact the contact of buyer
     */
    public void setBuyContact(String buyContact) {
        this.buyContact = buyContact;
    }

    /**
     * get the id of buyer
     * @return buyerId
     */
    public int getBuyerId() {
        return buyerId;
    }
}
