package entity;

import java.util.Date;

/**
 * @author Mike_hsj
 */
public class Book {
    /**
     * book name
     */
    private String bookName;
    /**
     * book type
     */
    private BookType bookType;
    /**
     * book publishing house
     */
    private String bookPress;
    /**
     * book author
     */
    private String bookAuthor;
    /**
     * book publishing time
     */
    private Date bookPressTime;
    /**
     * message press time
     */
    private Date messagePressTime;
    /**
     * expected price
     */
    private double expectedPrice;
    /**
     * detail
     */
    private String bookDetail;

    /**
     *
     * @param bookName book name
     * @param bookType book type
     * @param bookPress book publishing house
     * @param bookAuthor book author
     * @param bookPressTime book publishing time
     * @param messagePressTime message press time
     * @param expectedPrice expected price
     * @param bookDetail detail
     */
    public Book(String bookName,BookType bookType,String bookPress,String bookAuthor,
         Date bookPressTime, Date messagePressTime,double expectedPrice,String bookDetail){
        this.bookName=bookName;
        this.bookType=bookType;
        this.bookPress=bookPress;
        this.bookAuthor=bookAuthor;
        this.bookPressTime=bookPressTime;
        this.messagePressTime=messagePressTime;
        this.expectedPrice=expectedPrice;
        this.bookDetail=bookDetail;
    }

    /**
     * get book's name
     * @return bookName
     */
    public String getBookName() {
        return bookName;
    }

    /**
     *set book's name
     * @param bookName book's name
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * get book's type
     * @return bookType
     */
    public BookType getBookType() {
        return bookType;
    }

    /**
     * set book's type
     * @param bookType book's type
     */
    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    /**
     * get book publishing house
     * @return bookPress
     */
    public String getBookPress() {
        return bookPress;
    }

    /**
     * set book publishing house
     * @param bookPress book publishing house
     */
    public void setBookPress(String bookPress) {
        this.bookPress = bookPress;
    }

    /**
     * get book's author
     * @return bookAuthor
     */
    public String getBookAuthor() {
        return bookAuthor;
    }

    /**
     * set book's author
     * @param bookAuthor book's author
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    /**
     * get book publishing time
     * @return bookPressTime
     */
    public Date getBookPressTime() {
        return bookPressTime;
    }

    /**
     * set book publishing time
     * @param bookPressTime book publishing time
     */
    public void setBookPressTime(Date bookPressTime) {
        this.bookPressTime = bookPressTime;
    }

    /**
     * get message press time
     * @return messagePressTime
     */
    public Date getMessagePressTime() {
        return messagePressTime;
    }

    /**
     * set message press time
     * @param messagePressTime message press time
     */
    public void setMessagePressTime(Date messagePressTime) {
        this.messagePressTime = messagePressTime;
    }

    /**
     * get expected price
     * @return expectedPrice
     */
    public double getExpectedPrice() {
        return expectedPrice;
    }

    /**
     * set expected price
     * @param expectedPrice expected price
     */
    public void setExpectedPrice(double expectedPrice) {
        this.expectedPrice = expectedPrice;
    }
}
