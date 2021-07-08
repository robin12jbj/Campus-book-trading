package entity;

import java.util.Date;

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
     *
     * @param sellNo the number of book selling message
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
    BookSell(int sellNo,String bookName, BookType bookType, String bookPress, String bookAuthor,
             Date bookPressTime, Date messagePressTime, double expectedPrice, String bookDetail,String sellContact) {
        super(bookName, bookType, bookPress, bookAuthor, bookPressTime, messagePressTime, expectedPrice, bookDetail);
        this.sellNo=sellNo;
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
}
