package vn.viettuts.qlsv.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String type;
    private int id;
    private String name;
    private String author;
    private int year;
    /* điểm trung bình của sinh viên */
    private float cost;

    public Book() {
    }

    public Book(int id, String name, String author, int year, float cost,String type) {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.cost = cost;
        this.type=type;
    }
    
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type=type;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
