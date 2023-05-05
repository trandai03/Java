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
    private static final String BOOK_FILE_NAME = "book.xml";
    private List<Book> listBooks;
    private List<Book> listNewspapers;
    public List<Book> ls =listBooks;
    private List<Book> listNovels;
    public BookDao() {
        this.listBooks = readListBooks();
        if (listBooks == null) {
            listBooks = new ArrayList<Book>();
        }
        
        //this.listNewspapers = readListBooks();
        if (listNewspapers == null) {
            listNewspapers = new ArrayList<Book>();
        }
        
        if (listNovels == null) {
            listNovels = new ArrayList<Book>();
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
        FileUtils.writeXMLtoFile(BOOK_FILE_NAME, bookXML);
    }

    /**
     * Đọc các đối tượng book từ file book.xml
     * 
     * @return list book
     */
    public List<Book> readListBooks() {
        List<Book> list = new ArrayList<Book>();
        BookXML bookXML = (BookXML) FileUtils.readXMLFile(BOOK_FILE_NAME, BookXML.class);
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
    
    public List<Book> getListNovel(){
        List<Book>temp =new ArrayList<Book>();
        for(Book a : listBooks){
            if(a.getType().equals("Novel")){
                temp.add(a);
            }
        }
        return temp;
    }
    public List<Book> getListNewspapers() {
        List<Book>temp =new ArrayList<Book>();
        for(Book a : listBooks){
            if(a.getType().equals("Newspaper")){
                temp.add(a);
            }
        }
        
        return temp;
    }
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
        if(book.getType().equalsIgnoreCase("Novel")){
        for (int i = 0; i < size; i++) {
            if (listBooks.get(i).getId() == book.getId()) {
                listBooks.get(i).setName(book.getName());
                listBooks.get(i).setAuthor(book.getAuthor());
                listBooks.get(i).setYear(book.getYear());
                listBooks.get(i).setCost(book.getCost());
                writeListBooks(listBooks);
                break;
            }
        }
        }else{
            for (int i = 0; i < size; i++) {
                if (listBooks.get(i).getId() == book.getId()) {
                    listBooks.get(i).setName(book.getName());
                    listBooks.get(i).setPublisher(book.getPublisher());
                    listBooks.get(i).setYear(book.getYear());
                    listBooks.get(i).setCost(book.getCost());
                    listBooks.get(i).setNumber(book.getNumber());
                    writeListBooks(listBooks);
                    break;
        
                }
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
     * sắp xếp danh sách book theo Cost theo tứ tự tăng dần
     */
    public void sortBookByCost() {
        Collections.sort(listBooks, new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                if (book1.getCost() > book2.getCost()) {
                    return 1;
                }
                return -1;
            }
        });
    }
    
    public void sortBookByID() {
        Collections.sort(listBooks, new Comparator<Book>() {
            public int compare(Book book1, Book book2) {
                if (book1.getId() > book2.getId()) {
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
    
    

    public void setListNewspapers(List<Book> listNewspapers) {
        this.listNewspapers = listNewspapers;
    }
}