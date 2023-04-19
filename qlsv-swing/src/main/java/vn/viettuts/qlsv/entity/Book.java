package vn.viettuts.qlsv.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private byte author;
    private String address;
    /* điểm trung bình của sinh viên */
    private float gpa;

    public Book() {
    }

    public Book(int id, String name, byte author, String address, float gpa) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.address = address;
        this.gpa = gpa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAuthor() {
        return author;
    }

    public void setAuthor(byte author) {
        this.author = author;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }
}
