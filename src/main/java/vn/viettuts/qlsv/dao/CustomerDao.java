package vn.viettuts.qlsv.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JComboBox;

import vn.viettuts.qlsv.entity.Customer;
import vn.viettuts.qlsv.entity.CustomerXML;
import vn.viettuts.qlsv.utils.FileUtils;

/**
 * CustomerDao class
 * 
 * @author viettuts.vn
 */
public final class CustomerDao {
    private static final String CUSTOMER_FILE_NAME = "customer.xml";
    private List<Customer> listCustomer;

    public CustomerDao() {
        this.listCustomer = readListCustomers();
        if (listCustomer == null) {
            listCustomer = new ArrayList<Customer>();
        }
    }

    /**
     * Lưu các đối tượng student vào file customer.xml
     * 
     * @param customer
     */
    public void writeListCustomers(List<Customer> customers) {
        CustomerXML customerXML = new CustomerXML();
        customerXML.setCustomer(customers);
        FileUtils.writeXMLtoFile(CUSTOMER_FILE_NAME, customerXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list customer
     */
    public List<Customer> readListCustomers() {
        List<Customer> list = new ArrayList<Customer>();
        CustomerXML customerXML = (CustomerXML) FileUtils.readXMLFile(CUSTOMER_FILE_NAME, CustomerXML.class);
        if (customerXML != null) {
            list = customerXML.getCustomer();
        }
        return list;
    }
    

    /**
     * thêm student vào listCustomer và lưu listCustomer vào file
     * 
     * @param customer
     */
    public void add(Customer customer) {
        int id = 1;
        if (listCustomer != null && !listCustomer.isEmpty()) {
            id = listCustomer.size() + 1;
        }
        customer.setId(id);
        listCustomer.add(customer);
        writeListCustomers(listCustomer);
    }

    /**
     * cập nhật student vào listCustomer và lưu listCustomer vào file
     * 
     * @param customer
     */
 public void edit(Customer customer) {
    int size = listCustomer.size();
    for (int i = 0; i < size; i++) {
        if (listCustomer.get(i).getId() == customer.getId()) {
            listCustomer.get(i).setCc(customer.getCc());
            listCustomer.get(i).setName(customer.getName());
            listCustomer.get(i).setCheckin(customer.getCheckin());
            listCustomer.get(i).setCheckout(customer.getCheckout());
            listCustomer.get(i).setRoomType(customer.getRoomType());
            listCustomer.get(i).setPrice(customer.getPrice());
            listCustomer.get(i).setSearch(customer.getSearch());
            writeListCustomers(listCustomer);
            break;
        }
    }
}


    /**
     * xóa student từ listCustomer và lưu listCustomer vào file
     * 
     * @param customer
     * @return 
     */
    public boolean delete(Customer customer) {
        boolean isFound = false;
        int size = listCustomer.size();
        for (int i = 0; i < size; i++) {
            if (listCustomer.get(i).getCc()== customer.getCc()) {
                customer = listCustomer.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listCustomer.remove(customer);
            writeListCustomers(listCustomer);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortCustomerByName() {
        Collections.sort(listCustomer, new Comparator<Customer>() {
            public int compare(Customer customer1, Customer customer2) {
                return customer1.getName().compareTo(customer2.getName());
            }
        });
    }

    /**
     * sắp xếp danh sách student theo GPA theo tứ tự tăng dần
     */
    public void sortCustomerById() {
        Collections.sort(listCustomer, new Comparator<Customer>() {
            public int compare(Customer customer1, Customer customer2) {
                if (customer1.getId()> customer2.getId()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    public List<Customer> getListCustomers() {
        return listCustomer;
    }

    public void setListCustomers(List<Customer> listCustomer) {
        this.listCustomer = listCustomer;
    }
}