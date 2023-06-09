package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vn.viettuts.qlsv.dao.BookDao;
import vn.viettuts.qlsv.entity.Book;
import vn.viettuts.qlsv.view.BookView;

public class BookController {
    private BookDao bookDao;
    private BookView bookView;

    public  BookController(BookView view) {
        this.bookView = view;
        bookDao = new BookDao();

        view.addAddBookListener(new AddBookListener());
        view.addEdiBookListener(new EditBookListener());
        view.addDeleteBookListener(new DeleteBookListener());
        view.addClearListener(new ClearBookListener());
        view.addSortBookCostListener(new SortBookCostListener());
        view.addSortBookIDListener(new SortBookIDListener());
        view.addSortBookNameListener(new SortBookNameListener());
        view.addListBookSelectionListener(new ListBookSelectionListener());
        view.addSearchBookListener(new SearchBookListener());
        view.addFilterBookListener(new FiltertBookListener());
    }

    public void showBookView() {

        bookView.setVisible(true);
        bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
    }

    /**
     * Lớp AddBookListener 
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     * @author viettuts.vn
     */
    class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Book book = bookView.getBookInfo();
            if (book != null) {
                bookDao.add(book);
                bookView.showBook(book);
                bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
                bookView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditBookListener 
     * chứa cài đặt cho sự kiện click button "Edit"
     * 
     * @author viettuts.vn
     */
    class EditBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Book book = bookView.getBookInfo();
            if (book != null) {
                bookDao.edit(book);
                bookView.showBook(book);
                bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
                bookView.showMessage("Cập nhật thành công!");
            }
        }
    }

    /**
     * Lớp DeleteBookListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     * 
     * @author viettuts.vn
     */
    class DeleteBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Book book = bookView.getBookInfo();
            if (book != null) {
                bookDao.delete(book);
                bookView.clearBookInfo();
                bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
                bookView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearBookListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     * 
     * @author viettuts.vn
     */
    class ClearBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bookView.clearBookInfo();
        }
    }
    
    
    class SearchBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bookView.Search(bookDao.getListBooks());
            
        }
    }

    class FiltertBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bookView.filter(bookDao.getListBooks());
            
        }
    }
    /**
     * Lớp SortBookCostListener 
     * chứa cài đặt cho sự kiện click button "Sort By Cost"
     * 
     * @author viettuts.vn
     */
    class SortBookCostListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bookDao.sortBookByCost();
            bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
        }
    }
    
    class SortBookIDListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bookDao.sortBookByID();
            bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
        }
    }

    /**
     * Lớp SortBookCostListener 
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     * 
     * @author viettuts.vn
     */
    class SortBookNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            bookDao.sortBookByName();
            bookView.showListBooks(bookDao.getListNovel(),bookDao.getListNewspapers());
        }
    }

    /**
     * Lớp ListBookSelectionListener 
     * chứa cài đặt cho sự kiện chọn book trong bảng book
     * 
     * @author viettuts.vn
     */
    class ListBookSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
         
//            bookView.fillBookFromSelectedRow();
            
        }
        
    }
    
    
}
