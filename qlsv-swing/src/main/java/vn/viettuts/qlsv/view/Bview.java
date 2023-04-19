package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.entity.Book;

public class Bview extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addBookBtn;
    private JButton editBookBtn;
    private JButton deleteBookBtn;
    private JButton clearBtn;
    private JButton sortBookCostBtn;
    private JButton sortBookNameBtn;
    private JScrollPane jScrollPaneBookTable;
    private JScrollPane jScrollPaneYear;
    private JTable bookTable;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel authorLabel;
    private JLabel yearLabel;
    private JLabel costLabel;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField authorField;
    private JTextArea yearField;
    private JTextField costField;
    
    // định nghĩa các cột của bảng book
    private String [] columnNames = new String [] {
            "ID", "Name", "Author", "Year", "Cost"};
    // định nghĩa dữ liệu mặc định của bẳng book là rỗng
    private Object data = new Object [][] {};
    
    public Bview() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addBookBtn = new JButton("Add");
        editBookBtn = new JButton("Edit");
        deleteBookBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortBookCostBtn = new JButton("Sort By Cost");
        sortBookNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng book
        jScrollPaneBookTable = new JScrollPane();
        bookTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        authorLabel = new JLabel("Author");
        yearLabel = new JLabel("Year");
        costLabel = new JLabel("Cost");
        
        // khởi tạo các trường nhập dữ liệu cho book
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        authorField = new JTextField(6);
        yearField = new JTextArea();
        yearField.setColumns(15);
        yearField.setRows(5);
        jScrollPaneYear = new JScrollPane();
        jScrollPaneYear.setViewportView(yearField);
        costField = new JTextField(6);
        
        // cài đặt các cột và data cho bảng book
        bookTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneBookTable.setViewportView(bookTable);
        jScrollPaneBookTable.setPreferredSize(new Dimension (480, 300));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Book
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneBookTable);
        
        panel.add(addBookBtn);
        panel.add(editBookBtn);
        panel.add(deleteBookBtn);
        panel.add(clearBtn);
        panel.add(sortBookCostBtn);
        panel.add(sortBookNameBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(authorLabel);
        panel.add(yearLabel);
        panel.add(costLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(authorField);
        panel.add(jScrollPaneYear);
        panel.add(costField);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, authorLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, authorLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, yearLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, yearLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, costLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, costLabel, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, authorField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, authorField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneYear, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneYear, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, costField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, costField, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneBookTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneBookTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addBookBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addBookBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editBookBtn, 60, SpringLayout.WEST, addBookBtn);
        layout.putConstraint(SpringLayout.NORTH, editBookBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteBookBtn, 60, SpringLayout.WEST, editBookBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteBookBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteBookBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortBookCostBtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortBookCostBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortBookNameBtn, 115, SpringLayout.WEST, sortBookCostBtn);
        layout.putConstraint(SpringLayout.NORTH, sortBookNameBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Book Information");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editBookBtn.setEnabled(false);
        deleteBookBtn.setEnabled(false);
        // enable Add button
        addBookBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * hiển thị list book vào bảng bookTable
     * 
     * @param list
     */
    public void showListBooks(List<Book> list) {
        int size = list.size();
        // với bảng bookTable có 5 cột, 
        // khởi tạo mảng 2 chiều books, trong đó:
        // số hàng: là kích thước của list book 
        // số cột: là 5
        Object [][] books = new Object[size][5];
        for (int i = 0; i < size; i++) {
            books[i][0] = list.get(i).getId();
            books[i][1] = list.get(i).getName();
            books[i][2] = list.get(i).getAuthor();
            books[i][3] = list.get(i).getYear();
            books[i][4] = list.get(i).getCost();
        }
        bookTable.setModel(new DefaultTableModel(books, columnNames));
    }
    
    /**
     * điền thông tin của hàng được chọn từ bảng book 
     * vào các trường tương ứng của book.
     */
    public void fillBookFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = bookTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(bookTable.getModel().getValueAt(row, 0).toString());
            nameField.setText(bookTable.getModel().getValueAt(row, 1).toString());
            authorField.setText(bookTable.getModel().getValueAt(row, 2).toString());
            yearField.setText(bookTable.getModel().getValueAt(row, 3).toString());
            costField.setText(bookTable.getModel().getValueAt(row, 4).toString());
            // enable Edit and Delete buttons
            editBookBtn.setEnabled(true);
            deleteBookBtn.setEnabled(true);
            // disable Add button
            addBookBtn.setEnabled(false);
        }
    }

    /**
     * xóa thông tin book
     */
    public void clearBookInfo() {
        idField.setText("");
        nameField.setText("");
        authorField.setText("");
        yearField.setText("");
        costField.setText("");
        // disable Edit and Delete buttons
        editBookBtn.setEnabled(false);
        deleteBookBtn.setEnabled(false);
        // enable Add button
        addBookBtn.setEnabled(true);
    }
    
    /**
     * hiện thị thông tin book
     * 
     * @param book
     */
    public void showBook(Book book) {
        idField.setText("" + book.getId());
        nameField.setText(book.getName());
        authorField.setText("" + book.getAuthor());
        yearField.setText(""+book.getYear());
        costField.setText("" + book.getCost());
        // enable Edit and Delete buttons
        editBookBtn.setEnabled(true);
        deleteBookBtn.setEnabled(true);
        // disable Add button
        addBookBtn.setEnabled(false);
    }
    
    /**
     * lấy thông tin book
     * 
     * @return
     */
    public Book getBookInfo() {
        // validate book
        if (!validateName() || !validateAuthor() || !validateYear() || !validateCost()) {
            return null;
        }
        try {
            Book book = new Book();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                book.setId(Integer.parseInt(idField.getText()));
            }
            book.setName(nameField.getText().trim());
            book.setAuthor(authorField.getText().trim());
            book.setYear(Integer.parseInt(yearField.getText().trim()));
            book.setCost(Float.parseFloat(costField.getText().trim()));
            return book;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    
    private boolean validateName() {
        String name = nameField.getText();
        if (name == null || "".equals(name.trim())) {
            nameField.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateYear() {
        String year = yearField.getText();
        if (year == null || "".equals(year.trim())) {
            yearField.requestFocus();
            showMessage("Year không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateAuthor() {
        try {
            Byte author = Byte.parseByte(authorField.getText().trim());
            if (author < 0 || author > 100) {
                authorField.requestFocus();
                showMessage("Author không hợp lệ, author nên trong khoảng 0 đến 100.");
                return false;
            }
        } catch (Exception e) {
            authorField.requestFocus();
            showMessage("Author không hợp lệ!");
            return false;
        }
        return true;
    }
    
    private boolean validateCost() {
        try {
            Float cost = Float.parseFloat(costField.getText().trim());
            if (cost < 0 || cost > 10) {
                costField.requestFocus();
                showMessage("Cost không hợp lệ, cost nên trong khoảng 0 đến 10.");
                return false;
            }
        } catch (Exception e) {
            costField.requestFocus();
            showMessage("Cost không hợp lệ!");
            return false;
        }
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddBookListener(ActionListener listener) {
        addBookBtn.addActionListener(listener);
    }
    
    public void addEdiBookListener(ActionListener listener) {
        editBookBtn.addActionListener(listener);
    }
    
    public void addDeleteBookListener(ActionListener listener) {
        deleteBookBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortBookCostListener(ActionListener listener) {
        sortBookCostBtn.addActionListener(listener);
    }
    
    public void addSortBookNameListener(ActionListener listener) {
        sortBookNameBtn.addActionListener(listener);
    }
    
    public void addListBookSelectionListener(ListSelectionListener listener) {
        bookTable.getSelectionModel().addListSelectionListener(listener);
    }
}
