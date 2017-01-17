package com.allstate.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="product",uniqueConstraints = {@UniqueConstraint(columnNames = {"productname", "stocknumber"})})
@Data
public class Product {

    private int id;
    private int version;
    private String productname;
    private String stocknumber;
    private String description;
    private double rating;
    private int reviews;
    private int listprice;
    private int discountpercentage;
    private int discountedamount;
    private int quantity;
    private int agerestrict;
    private Date createddate;
    private Date modifieddate;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(nullable = false)
    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    @Column(nullable = false)
    public String getStocknumber() {
        return stocknumber;
    }

    public void setStocknumber(String stocknumber) {
        this.stocknumber = stocknumber;
    }

    @CreationTimestamp
    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    @UpdateTimestamp
    public Date getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Date modifieddate) {
        this.modifieddate = modifieddate;
    }
}
