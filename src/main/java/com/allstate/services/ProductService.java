package com.allstate.services;

import com.allstate.entities.Product;
import com.allstate.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ProductService {
    @Autowired
    private IProductRepository repository;

    public Product create(Product p) {
        return this.repository.save(p);
    }
    public Product findById(int id){
        return this.repository.findOne(id);
    }
    public Product findByProductname(String name){
        return this.repository.findByProductname(name);
    }
//    public ArrayList<Product> findAll(){
//        return (ArrayList<Product>)this.repository.findAll();
//    }

    public Iterable<Product>findAll(){
        return this.repository.findAll();
    }

    public void  delete(int id){
        this.repository.delete(id);
    }

    public Product update(Product p, String Name) {
        String productname = p.getProductname();
        String stocknumber = p.getStocknumber();
        p.setProductname(Name);
       return this.repository.save(p);
    }
}
