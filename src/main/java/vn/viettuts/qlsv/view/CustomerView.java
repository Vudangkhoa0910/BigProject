package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.entity.Customer;

public class CustomerView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addCustomerBtn;
    private JButton editCustomerBtn;
    private JButton deleteCustomerBtn;
    private JButton clearBtn;
    private JButton sortCustomerIDBtn;
    private JButton sortCustomerNameBtn;
    private JScrollPane jScrollPaneCustomerTable;
    private JTable CustomerTable;
    private JButton searchBtn;
    private JButton payBtn;
    
    private JLabel idLabel;
    private JLabel ccLabel;
    private JLabel nameLabel;
    private JLabel checkinLabel;
    private JLabel checkoutLabel;
    private JLabel roomTypeLabel;
    private JLabel priceLabel;
    private JLabel searchLabel;
    private JLabel checkinHourLabel;
    private JLabel checkinMinuteLabel;
    private JLabel checkoutHourLabel;
    private JLabel checkoutMinuteLabel;
    
    private JTextField idField;
    private JTextField ccField;
    private JTextField nameField;
    //private JTextField bookingDateField;
    private JComboBox<String> roomTypeField;
    private JComboBox<String> checkinHourField;
    private JComboBox<String> checkinMinuteField;
    private JComboBox<String> checkoutHourField;
    private JComboBox<String> checkoutMinuteField;
    private JTextField priceField;
    private JTextField searchField;
    
    // định nghĩa các cột của bảng student
    private String [] columnNames = new String [] {
            "NumOder", "CCCD", "Name", "Checkin", "Checkout", "RoomType", "Price", "Payment"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object [][] {};
    
    public CustomerView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addCustomerBtn = new JButton("Add");
        editCustomerBtn = new JButton("Edit");
        deleteCustomerBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        searchBtn = new JButton("Search");
        payBtn = new JButton("Pay");
        sortCustomerIDBtn = new JButton("Sort By NumOrder");
        sortCustomerNameBtn = new JButton("Sort By Name");

        // khởi tạo bảng student
        jScrollPaneCustomerTable = new JScrollPane();
        CustomerTable = new JTable();
        
        // khởi tạo các label
        idLabel = new JLabel("NumOrder");
        ccLabel = new JLabel("CCCD");
        nameLabel = new JLabel("Name");
        checkinLabel = new JLabel("Checkin");
        checkinHourLabel = new JLabel("Hour");
        checkinMinuteLabel = new JLabel("Minute");
        checkoutLabel = new JLabel("Checkout");
        checkoutHourLabel = new JLabel("Hour");
        checkoutMinuteLabel = new JLabel("Minute");
        roomTypeLabel = new JLabel("RoomType");
        priceLabel = new JLabel("Price");
        searchLabel = new JLabel("Search");
        
        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(5);
        idField.setEditable(true);
        ccField = new JTextField(15);
        nameField = new JTextField(15);
        //bookingDateField = new JTextField(15);
        roomTypeField = new JComboBox<>(new String[]{"Phòng Đơn", "Phòng Đôi", "Phòng VIP"});
        String[] hours = new String[25];
        for (int i = 0; i < 24; i++) {
            hours[i] = String.format("%02d", i);
        }
        checkinHourField = new JComboBox<>(hours);
        checkoutHourField = new JComboBox<>(hours);
        String[] minute = new String[61];
        for (int i = 0; i < 60; i++) {
            minute[i] = String.format("%02d", i);
        }
        checkinMinuteField = new JComboBox<>(minute);
        checkoutMinuteField = new JComboBox<>(minute);
        priceField = new JTextField(15);
        searchField = new JTextField(15);
        
        // cài đặt các cột và data cho bảng student
        CustomerTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneCustomerTable.setViewportView(CustomerTable);
        jScrollPaneCustomerTable.setPreferredSize(new Dimension (480, 300));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Customer
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneCustomerTable);
        
        panel.add(addCustomerBtn);
        panel.add(editCustomerBtn);
        panel.add(deleteCustomerBtn);
        panel.add(clearBtn);
        panel.add(sortCustomerIDBtn);
        panel.add(sortCustomerNameBtn);
        panel.add(searchBtn);
        panel.add(payBtn);
        
        panel.add(idLabel);
        panel.add(ccLabel);
        panel.add(nameLabel);
        panel.add(checkinLabel);
        panel.add(checkinHourLabel);
        panel.add(checkinMinuteLabel);
        panel.add(checkoutLabel);
        panel.add(checkoutHourLabel);
        panel.add(checkoutMinuteLabel);
        panel.add(roomTypeLabel);
        panel.add(priceLabel);
        panel.add(searchLabel);
        
        panel.add(idField);
        panel.add(ccField);
        panel.add(nameField);
        //panel.add(bookingDateField);
        panel.add(checkinHourField);
        panel.add(checkinMinuteField);
        panel.add(checkoutHourField);
        panel.add(checkoutMinuteField);
        panel.add(roomTypeField);
        panel.add(priceField);
        panel.add(searchField);
        
        // cài đặt vị trí các thành phần trên màn hình login
        //Chữ
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ccLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ccLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkinLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkinLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkinHourLabel, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkinHourLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkinMinuteLabel, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkinMinuteLabel, 100, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, checkoutLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkoutLabel, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkoutHourLabel, 80, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkoutHourLabel, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkoutMinuteLabel, 170, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkoutMinuteLabel, 130, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, roomTypeLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, roomTypeLabel, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, priceLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, priceLabel, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchLabel, 230, SpringLayout.NORTH, panel);

        //Ô nhập
        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, ccField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, ccField, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameField, 70, SpringLayout.NORTH, panel);
        //layout.putConstraint(SpringLayout.WEST, bookingDateField, 100, SpringLayout.WEST, panel);
        //layout.putConstraint(SpringLayout.NORTH, bookingDateField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkinHourField, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkinHourField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkinMinuteField, 220, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkinMinuteField, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkoutHourField, 120, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkoutHourField, 130, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, checkoutMinuteField, 220, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, checkoutMinuteField, 130, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, roomTypeField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, roomTypeField, 160, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, priceField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, priceField, 190, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, searchField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchField, 230, SpringLayout.NORTH, panel);
        
        // Bảng HTTT Center
        layout.putConstraint(SpringLayout.WEST, jScrollPaneCustomerTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneCustomerTable, 10, SpringLayout.NORTH, panel);
        
        //Công cụ
        layout.putConstraint(SpringLayout.WEST, addCustomerBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addCustomerBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editCustomerBtn, 65, SpringLayout.WEST, addCustomerBtn);
        layout.putConstraint(SpringLayout.NORTH, editCustomerBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteCustomerBtn, 65, SpringLayout.WEST, editCustomerBtn);
        layout.putConstraint(SpringLayout.WEST, searchBtn, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, searchBtn, 220, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 75, SpringLayout.WEST, deleteCustomerBtn);
        layout.putConstraint(SpringLayout.WEST, payBtn, 110, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, payBtn, 300, SpringLayout.NORTH, panel);
        
        //Sort
        layout.putConstraint(SpringLayout.NORTH, deleteCustomerBtn, 260, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortCustomerIDBtn, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, sortCustomerIDBtn, 330, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, sortCustomerNameBtn, 280, SpringLayout.WEST, sortCustomerIDBtn);
        layout.putConstraint(SpringLayout.NORTH, sortCustomerNameBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Customer Information");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(true);
        deleteCustomerBtn.setEnabled(true);
        // enable Add button
        addCustomerBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    /**
     * hiển thị list student vào bảng CustomerTable
     * 
     * @param list
     */
    public void showListCustomers(List<Customer> list) {
        int size = list.size();
        // với bảng CustomerTable có 5 cột, 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        // số cột: là 5
        Object [][] customers = new Object[size][8];
        for (int i = 0; i < size; i++) {
            customers[i][0] = list.get(i).getId();
            customers[i][1] = list.get(i).getCc();
            customers[i][2] = list.get(i).getName();
            customers[i][3] = list.get(i).getCheckin();
            customers[i][4] = list.get(i).getCheckout();
            customers[i][5] = list.get(i).getRoomType();
            customers[i][6] = list.get(i).getPrice();
            customers[i][7] = list.get(i).getSearch();
        }
        CustomerTable.setModel(new DefaultTableModel(customers, columnNames));
    }
    
    /**
     * điền thông tin của hàng được chọn từ bảng student 
     * vào các trường tương ứng của student.
     */
    public void fillCustomerFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = CustomerTable.getSelectedRow();
        if (row >= 0) {
            idField.setText(CustomerTable.getModel().getValueAt(row, 0).toString());
            ccField.setText(CustomerTable.getModel().getValueAt(row, 1).toString());
            nameField.setText(CustomerTable.getModel().getValueAt(row, 2).toString());
            
            String bookingTimein = CustomerTable.getModel().getValueAt(row, 3).toString();
            checkinHourField.setSelectedItem(bookingTimein.split(":")[0]);
            checkinMinuteField.setSelectedItem(bookingTimein.split(":")[1]);

            String bookingTimeout = CustomerTable.getModel().getValueAt(row, 4).toString();
            checkoutHourField.setSelectedItem(bookingTimeout.split(":")[0]);
            checkoutMinuteField.setSelectedItem(bookingTimeout.split(":")[1]);

            roomTypeField.setSelectedItem(CustomerTable.getModel().getValueAt(row, 5).toString());
            priceField.setText(CustomerTable.getModel().getValueAt(row, 6).toString());
            searchField.setText(CustomerTable.getModel().getValueAt(row, 7).toString());
            // enable Edit and Delete buttons
            editCustomerBtn.setEnabled(true);
            deleteCustomerBtn.setEnabled(true);
            // disable Add button
            addCustomerBtn.setEnabled(false); 
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearCustomerInfo() {
        idField.setText("");
        ccField.setText("");
        nameField.setText("");
        checkinHourField.setSelectedIndex(0);
        checkinMinuteField.setSelectedIndex(0);
        checkoutHourField.setSelectedIndex(0);
        checkoutMinuteField.setSelectedIndex(0);
        roomTypeField.setSelectedIndex(0);
        priceField.setText("");
        searchField.setText("");
        // disable Edit and Delete buttons
        editCustomerBtn.setEnabled(false);
        deleteCustomerBtn.setEnabled(false);
        // enable Add button
        addCustomerBtn.setEnabled(true);
    }
    
    /**
     * hiện thị thông tin student
     * 
     * @param customer
     */
    public void showCustomer(Customer customer) {
        idField.setText("" + customer.getId());
        ccField.setText("" + customer.getId());
        nameField.setText(customer.getName());
        String checkin = customer.getCheckin();
        if (checkin != null && checkin.length() == 5) {
            checkinHourField.setSelectedItem(checkin.substring(0, 2));
            checkinMinuteField.setSelectedItem(checkin.substring(3, 5));
        } else {
            // Nếu bookingDate không hợp lệ, đặt giờ và phút về giá trị mặc định
            checkinHourField.setSelectedIndex(0);
            checkinMinuteField.setSelectedIndex(0);
        }
        String checkout = customer.getCheckin();
        if (checkout != null && checkout.length() == 5) {
            checkinHourField.setSelectedItem(checkout.substring(0, 2));
            checkinMinuteField.setSelectedItem(checkout.substring(3, 5));
        } else {
            // Nếu bookingDate không hợp lệ, đặt giờ và phút về giá trị mặc định
            checkinHourField.setSelectedIndex(0);
            checkinMinuteField.setSelectedIndex(0);
        }
        priceField.setText("" + customer.getPrice());
        // enable Edit and Delete buttons
        editCustomerBtn.setEnabled(true);
        deleteCustomerBtn.setEnabled(true);
        // disable Add button
        addCustomerBtn.setEnabled(false);
    }
    
    /**
     * lấy thông tin student
     * 
     * @return
     */
public Customer getCustomerInfo() {
    // validate customer
    if (!validateCCCD() || !validateName() || !validateCheckin()|| !validateCheckout()|| !validateRoomType() || !validatePrice()) {
        return null;
    }
    try {
        Customer customer = new Customer();
        if (idField.getText() != null && !"".equals(idField.getText())) {
            customer.setId(Integer.parseInt(idField.getText()));
        }
        customer.setCc(Integer.parseInt(ccField.getText().trim()));
        customer.setName(nameField.getText().trim());
        customer.setCheckin(checkinHourField.getSelectedItem() + ":" + checkinMinuteField.getSelectedItem());
        customer.setCheckout(checkoutHourField.getSelectedItem() + ":" + checkoutMinuteField.getSelectedItem());
        customer.setRoomType((String) roomTypeField.getSelectedItem());
        customer.setPrice(Integer.parseInt(priceField.getText().trim()));
        return customer;
    } catch (Exception e) {
        showMessage(e.getMessage());
    }
    return null;
}

    
    private boolean validateCCCD() {
        try {
            int CC = Integer.parseInt(ccField.getText().trim());
            if (CC < 0) {
                ccField.requestFocus();
                showMessage("Price không hợp lệ.");
                return false;
            }
        } catch (Exception e) {
            ccField.requestFocus();
            showMessage("Price không hợp lệ!");
            return false;
        }
        return true;
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
    
    private boolean validateRoomType() {
        String roomType = (String) roomTypeField.getSelectedItem();
        if (roomType == null || "".equals(roomType.trim())) {
            roomTypeField.requestFocus();
            showMessage("RoomType không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateCheckin() {        
        String selectedHour = (String) checkinHourField.getSelectedItem();
        String selectedMinute = (String) checkinMinuteField.getSelectedItem();

        if (selectedHour == null || selectedMinute == null || selectedHour.isEmpty() || selectedMinute.isEmpty()) {
            showMessage("Checkin time không hợp lệ.");
            return false;
        }

        return true;
    }

    private boolean validateCheckout() {        
        String selectedHour = (String) checkoutHourField.getSelectedItem();
        String selectedMinute = (String) checkoutMinuteField.getSelectedItem();

        if (selectedHour == null || selectedMinute == null || selectedHour.isEmpty() || selectedMinute.isEmpty()) {
            showMessage("Checkout time không hợp lệ.");
            return false;
        }

        return true;
    }
    
    private boolean validatePrice() {
        try {
            int Price = Integer.parseInt(priceField.getText().trim());
            if (Price < 0) {
                priceField.requestFocus();
                showMessage("Price không hợp lệ.");
                return false;
            }
        } catch (Exception e) {
            priceField.requestFocus();
            showMessage("Price không hợp lệ!");
            return false;
        }
        return true;
    }
    
    // Thêm hàm này vào CustomerView để xử lý sự kiện tìm kiếm
public void addSearchCustomerListener(ActionListener listener) {
    searchBtn.addActionListener(listener);
}

// Thêm hàm này để lấy giá trị từ ô tìm kiếm
public String getSearchKeyword() {
    return searchField.getText().trim();
}

    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddCustomerListener(ActionListener listener) {
        addCustomerBtn.addActionListener(listener);
    }
    
    public void addEdiCustomerListener(ActionListener listener) {
        editCustomerBtn.addActionListener(listener);
    }
    
    public void addDeleteCustomerListener(ActionListener listener) {
        deleteCustomerBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortCustomerPriceListener(ActionListener listener) {
        sortCustomerIDBtn.addActionListener(listener);
    }
    
    public void addSortCustomerNameListener(ActionListener listener) {
        sortCustomerNameBtn.addActionListener(listener);
    }
    
    public void addListCustomerSelectionListener(ListSelectionListener listener) {
        CustomerTable.getSelectionModel().addListSelectionListener(listener);
    }
}
