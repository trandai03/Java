package vn.viettuts.qlsv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import vn.viettuts.qlsv.entity.Book;
import vn.viettuts.qlsv.entity.BookXML;
import vn.viettuts.qlsv.utils.FileUtils;

/**
 * BookDao class
 * 
 * @author viettuts.vn
 */
public class BookDao {
    private static final String STUDENT_FILE_NAME = "book.xml";
    private List<Book> listBooks;

    public BookDao() {
        this.listBooks = readListBooks();
        if (listBooks == null) {
            listBooks = new ArrayList<Book>();
        }
    }

    /**
     * Lưu các đối tượng book vào file book.xml
     * 
     * @param books
     */
    public void writeListBooks(List<Book> books) {
        BookXML bookXML = new BookXML();
        bookXML.setBook(books);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, bookXML);
    }

    /**
     * Đọc các đối tượng book từ file book.xml
     * 
     * @return list book
     */
    public List<Book> readListBooks() {
        List<Book> list = new ArrayList<Book>();
        BookXML bookXML = (BookXML) FileUtils.readXMLFile(STUDENT_FILE_NAME, BookXML.class);
        if (bookXML != null) {
            list = bookXML.getBook();
        }
        return list;
    }
    

    /**
     * thêm book vào listBooks và lưu listBooks vào file
     * 
     * @param book
     */
    public void add(Book book) {
        int id = 1;
        if (listBooks != null && listBooks.size() > 0) {
            id = listBooks.size() + 1;
        }
        book.setId(id);
        listBooks.add(book);
        writeListBooks(listBooks);
    }

    /**
     * cập nhật book vào listBooks và lưu listBooks vào file
     * 
     * @param book
     */
    public void edit(Book book) {
        int size = listBooks.size();
        for (int i = 0; i < size; i++) {
            if (listBooks.get(i).getId() == book.getId()) {
                listBooks.get(i).setName(book.getName());
                listBooks.get(i).setAuthor(book.getAuthor());
                listBooks.get(i).setAddress(book.getAddress());
                listBooks.get(i).setGpa(book.getGpa());
                writeListBooks(listBooks);
                break;
            }
        }
    }

    /**
     * xóa book từ listBooks và lưu listBooks vào file
     * 
     * @param book
     */
    public boolean delete(Book book) {
        boolean isFound = false;
        int size = listBooks.size();
        for (int i = 0; i < size; i++) {
            if (listBooks.get(i).getId() == book.getId()) {
                book = listBooks.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listBooks.remove(book);
            writeListBooks(listBooks);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách book theo name theo tứ tự tăng dần
     */
    public void sortBookByName() {
        Collections.sort(listBooks, new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                return book1.getName().compareTo(book2.getName());
            }
        });
    }

    /**
     * sắp xếp danh sách book theo GPA theo tứ tự tăng dần
     */
    public void sortBookByGPA() {
        Collections.sort(listBooks, new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                if (book1.getGpa() > book2.getGpa()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Book> getListBooks() {
        return listBooks;
    }

    public void setListBooks(List<Book> listBooks) {
        this.listBooks = listBooks;
    }
}