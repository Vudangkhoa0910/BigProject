package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vn.viettuts.qlsv.dao.CustomerDao;
import vn.viettuts.qlsv.entity.Customer;
import vn.viettuts.qlsv.view.CustomerView;

public class CustomerController {
    private CustomerDao customerDao;
    private CustomerView customerView;

    public CustomerController(CustomerView view) {
        this.customerView = view;
        customerDao = new CustomerDao();

        view.addAddCustomerListener(new AddCustomerListener());
        view.addEdiCustomerListener(new EditCustomerListener());
        view.addDeleteCustomerListener(new DeleteCustomerListener());
        view.addClearListener(new ClearCustomerListener());
        view.addSortCustomerPriceListener(new SortCustomerPriceListener());
        view.addSortCustomerNameListener(new SortCustomerNameListener());
        view.addListCustomerSelectionListener(new ListCustomerSelectionListener());
        view.addSearchCustomerListener(new SearchCustomerListener());
    }

    public void showCustomerView() {
        List<Customer> customerList = customerDao.getListCustomers();
        customerView.setVisible(true);
        customerView.showListCustomers(customerList);
    }

    /**
     * Lớp AddCustomerListener 
     * chứa cài đặt cho sự kiện click button "Add"
     * 
     * @author viettuts.vn
     */
    class AddCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer customer = customerView.getCustomerInfo();
            if (customer != null) {
                customerDao.add(customer);
                customerView.showCustomer(customer);
                customerView.showListCustomers(customerDao.getListCustomers());
                customerView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditCustomerListener 
     * chứa cài đặt cho sự kiện click button "Edit"
     * 
     * @author viettuts.vn
     */
    class EditCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer customer = customerView.getCustomerInfo();
            if (customer != null) {
                customerDao.edit(customer);
                customerView.showCustomer(customer);
                customerView.showListCustomers(customerDao.getListCustomers());
                customerView.showMessage("Cập nhật thành công!");
            }
        }
    }

    /**
     * Lớp DeleteCustomerListener 
     * chứa cài đặt cho sự kiện click button "Delete"
     * 
     * @author viettuts.vn
     */
    class DeleteCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Customer customer = customerView.getCustomerInfo();
            if (customer != null) {
                customerDao.delete(customer);
                customerView.clearCustomerInfo();
                customerView.showListCustomers(customerDao.getListCustomers());
                customerView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearCustomerListener 
     * chứa cài đặt cho sự kiện click button "Clear"
     * 
     * @author viettuts.vn
     */
    class ClearCustomerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            customerView.clearCustomerInfo();
        }
    }

    /**
     * Lớp SortCustomerGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By GPA"
     * 
     * @author viettuts.vn
     */
    class SortCustomerPriceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            customerDao.sortCustomerById();
            customerView.showListCustomers(customerDao.getListCustomers());
        }
    }

    /**
     * Lớp SortCustomerGPAListener 
     * chứa cài đặt cho sự kiện click button "Sort By Name"
     * 
     * @author viettuts.vn
     */
    class SortCustomerNameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            customerDao.sortCustomerByName();
            customerView.showListCustomers(customerDao.getListCustomers());
        }
    }

    /**
     * Lớp ListCustomerSelectionListener 
     * chứa cài đặt cho sự kiện chọn customer trong bảng customer
     * 
     * @author viettuts.vn
     */
    class ListCustomerSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            customerView.fillCustomerFromSelectedRow();
        }
    }
    
    // Thêm mã xử lý cho sự kiện tìm kiếm
class SearchCustomerListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        String keyword = customerView.getSearchKeyword();
        List<Customer> result = searchCustomers(keyword);
        customerView.showListCustomers(result);
    }

    // Hàm tìm kiếm gần đúng trong danh sách khách hàng
    private List<Customer> searchCustomers(String keyword) {
        List<Customer> allCustomers = customerDao.getListCustomers();
        List<Customer> result = new ArrayList<>();

        for (Customer customer : allCustomers) {
            // Điều kiện tìm kiếm: Tên, số căn cước hoặc loại phòng chứa keyword
            if (containsKeyword(customer, keyword)) {
                result.add(customer);
            }
        }

        return result;
    }

    // Hàm kiểm tra xem thông tin của khách hàng có chứa keyword không
    private boolean containsKeyword(Customer customer, String keyword) {
    String lowerKeyword = keyword.toLowerCase();
    return customer.getName().toLowerCase().contains(lowerKeyword)
            || String.valueOf(customer.getCc()).contains(lowerKeyword)
            || customer.getRoomType().toLowerCase().contains(lowerKeyword);
    }
}
}
