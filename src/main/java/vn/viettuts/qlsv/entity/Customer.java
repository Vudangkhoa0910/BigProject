package vn.viettuts.qlsv.entity;

import com.sun.jndi.toolkit.dir.DirSearch;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "customer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int cc;
    private String name;
    private String checkin;
    private String checkout;
    private String roomType;
    private int price;
    private String search;

    public Customer() {}

    public Customer(int id, int cc, String name, String checkin, String checkout, String roomType, int price, String search) {
        this.id = id;
        this.cc = cc;
        this.name = name;
        this.checkin = checkin;
        this.checkout = checkout;
        this.roomType = roomType;
        this.price = price;
        this.search = search;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getId() {
        return id;
    }

    public int getCc() {
        return cc;
    }

    public String getName() {
        return name;
    }

    public String getCheckin() {
        return checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getPrice() {
        return price;
    }

    public String getSearch() {
        return search;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
    
}
