package com.rahul.ReactJavaWebApp.controller;

import com.rahul.ReactJavaWebApp.model.Product;
import com.rahul.ReactJavaWebApp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
//fetching data from the service:=>
    @Autowired
 ProductService myService;

//    @RequestMapping("/products")
    @GetMapping("/products")
    public List<Product> getProducts(){
        return myService.getProducts();
    }
//    @RequestMapping("/products/{prodId}")
    @GetMapping("/products/{prodId}")
    public Product getProductById(@PathVariable int prodId){ //as I dont want the whole product Object List but single a single product
        return myService.getProductById(prodId);
    }

    @PostMapping("/products")
    public void addProduct(@RequestBody Product prod){
        System.out.println(prod);
    myService.addProduct(prod);
    }
@PutMapping("/products")
    public void updateProduct(@RequestBody Product prod){
        myService.updateProduct(prod);
    }
@DeleteMapping("/products/{prodId}")
    public void deleteProduct(@PathVariable int prodId){
        myService.deleteProduct(prodId);
    }

}
