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

public class BookView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addBookBtn;
    private JButton editBookBtn;
    private JButton deleteBookBtn;
    private JButton clearBtn;
    private JButton sortBookGPABtn;
    private JButton sortBookNameBtn;
    private JScrollPane jScrollPaneBookTable;
    private JScrollPane jScrollPaneAddress;
    private JTable bookTable;
    
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel authorLabel;
    private JLabel addressLabel;
    private JLabel gpaLabel;
    
    private JTextField idField;
    private JTextField nameField;
    private JTextField authorField;
    private JTextArea addressTA;
    private JTextField gpaField;
    
    // định nghĩa các cột của bảng book
    private String [] columnNames = new String [] {
            "ID", "Name", "Author", "Address", "GPA"};
    // định nghĩa dữ liệu mặc định của bẳng book là rỗng
    private Object data = new Object [][] {};
    
    public BookView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addBookBtn = new JButton("Add");
        editBookBtn = new JButton("Edit");
        deleteBookBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortBookGPABtn = new JButton("Sort By GPA");
        sortBookNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng book
        jScrollPaneBookTable = new JScrollPane();
        bookTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("Id");
        nameLabel = new JLabel("Name");
        authorLabel = new JLabel("Author");
        addressLabel = new JLabel("Address");
        gpaLabel = new JLabel("GPA");
        
        // khởi tạo các trường nhập dữ liệu cho book
        idField = new JTextField(6);
        idField.setEditable(false);
        nameField = new JTextField(15);
        authorField = new JTextField(6);
        addressTA = new JTextArea();
        addressTA.setColumns(15);
        addressTA.setRows(5);
        jScrollPaneAddress = new JScrollPane();
        jScrollPaneAddress.setViewportView(addressTA);
        gpaField = new JTextField(6);
        
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
        panel.add(sortBookGPABtn);
        panel.add(sortBookNameBtn);
        
        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(authorLabel);
        panel.add(addressLabel);
        panel.add(gpaLabel);
        
        panel.add(idField);
        panel.add(nameField);
        panel.add(authorField);
        panel.add(jScrollPaneAddress);
        panel.add(gpaField);
        
        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, authorLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, authorLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, addressLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addressLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaLabel, 200, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, authorField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, authorField, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, jScrollPaneAddress, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneAddress, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, gpaField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, gpaField, 200, SpringLayout.NORTH, panel);
        
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
        layout.putConstraint(SpringLayout.WEST, sortBookGPABtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortBookGPABtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortBookNameBtn, 115, SpringLayout.WEST, sortBookGPABtn);
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
            books[i][3] = list.get(i).getAddress();
            books[i][4] = list.get(i).getGpa();
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
            addressTA.setText(bookTable.getModel().getValueAt(row, 3).toString());
            gpaField.setText(bookTable.getModel().getValueAt(row, 4).toString());
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
        addressTA.setText("");
        gpaField.setText("");
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
        addressTA.setText(book.getAddress());
        gpaField.setText("" + book.getGpa());
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
        if (!validateName() || !validateAuthor() || !validateAddress() || !validateGPA()) {
            return null;
        }
        try {
            Book book = new Book();
            if (idField.getText() != null && !"".equals(idField.getText())) {
                book.setId(Integer.parseInt(idField.getText()));
            }
            book.setName(nameField.getText().trim());
            book.setAuthor(Byte.parseByte(authorField.getText().trim()));
            book.setAddress(addressTA.getText().trim());
            book.setGpa(Float.parseFloat(gpaField.getText().trim()));
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
    
    private boolean validateAddress() {
        String address = addressTA.getText();
        if (address == null || "".equals(address.trim())) {
            addressTA.requestFocus();
            showMessage("Address không được trống.");
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
    
    private boolean validateGPA() {
        try {
            Float gpa = Float.parseFloat(gpaField.getText().trim());
            if (gpa < 0 || gpa > 10) {
                gpaField.requestFocus();
                showMessage("GPA không hợp lệ, gpa nên trong khoảng 0 đến 10.");
                return false;
            }
        } catch (Exception e) {
            gpaField.requestFocus();
            showMessage("GPA không hợp lệ!");
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
    
    public void addSortBookGPAListener(ActionListener listener) {
        sortBookGPABtn.addActionListener(listener);
    }
    
    public void addSortBookNameListener(ActionListener listener) {
        sortBookNameBtn.addActionListener(listener);
    }
    
    public void addListBookSelectionListener(ListSelectionListener listener) {
        bookTable.getSelectionModel().addListSelectionListener(listener);
    }
}
