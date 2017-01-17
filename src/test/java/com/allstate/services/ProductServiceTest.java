package com.allstate.services;

import com.allstate.entities.Product;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class ProductServiceTest {
    @Autowired
    private ProductService productsevice;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateProduct() throws Exception{
        Product before = new Product();
        before.setProductname("Testing");
        before.setStocknumber("123");
        Product after = this.productsevice.create(before);
        assertEquals(2, after.getId());
        assertEquals(0, after.getVersion());
        assertEquals("Testing", after.getProductname());
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void  shouldNotCreateProduct() throws Exception {
        Product before = new Product();
        Product after = this.productsevice.create(before);
        assertEquals(2,after.getId());

    }

    @Test
    public void shouldReturnProductGivenId() throws Exception{
        Product p = this.productsevice.findById(1);
        assertEquals("Glass",p.getProductname());

    }

    @Test
    public void shouldNotReturnAnythingForRandomId() throws Exception{
        Product p = this.productsevice.findById(5);
        assertNull(p);
    }

    @Test
    public void shouldReturnProductByName()  throws Exception {
        Product p = this.productsevice.findByProductname("Glass");
        assertEquals("Glass" , p.getProductname());
    }

    @Test
    public void shouldReturnAllProduct() throws Exception {
        ArrayList<Product> p = (ArrayList<Product>) this.productsevice.findAll();
        assertEquals(1,p.size());
    }

    @Test
    public void shouldDeleteProductById() throws Exception {
        this.productsevice.delete(1);
        Product p = this.productsevice.findById(1);
        assertNull(p);
    }

    @Test(expected = org.springframework.dao.EmptyResultDataAccessException.class)
    public void shouldNotDeleteProductByFakeId() throws Exception {
        this.productsevice.delete(10);
        ArrayList<Product>  p = (ArrayList<Product>)this.productsevice.findAll();
        assertEquals(0,p.size());
    }

    @Test
    public void shouldUpdateProductByName() throws Exception{
        Product before = new Product();
        before.setProductname("Testing");
        before.setStocknumber("123");
        Product after = this.productsevice.create(before);

        Product toUpdate = this.productsevice.findByProductname("Testing");
        Product updateproduct = this.productsevice.update(toUpdate,"Testing123");
        assertEquals("Testing123",updateproduct.getProductname());
    }


    @Test(expected =  java.lang.NullPointerException.class)
    public void shouldNotUpdateProductByFakeName() throws Exception{
        Product before = new Product();
        before.setProductname("Testing");
        before.setStocknumber("123");
        Product after = this.productsevice.create(before);

        Product toUpdate = this.productsevice.findByProductname("Testing125522");
        Product updateproduct = this.productsevice.update(toUpdate,"Testing123");
        assertNull(updateproduct);
    }

    @Test
    public void shouldReturnAverageRateOfProduct() throws Exception {
        ArrayList<Product> p = (ArrayList<Product>) this.productsevice.findAll();
        System.out.println("Here"+p.get(0).getRating());

    }
}