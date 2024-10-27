package com.rahul.ReactJavaWebApp.service;

import com.rahul.ReactJavaWebApp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Service //object will be created with the spring container for this @Service annotation and can & will be sent to Controller via autowired
public class ProductService {


    //dummy data-data fetched from DB is being fed though model and will be ready for controller and controller get it by invoking getProducts():=>
    List<Product> myProducts = new ArrayList<>(Arrays.asList(
            new Product(10, "Phone", 45000),
            new Product(45, "Charger", 1500),
            new Product(89, "Tampered Glass", 500)
    ));
    public List<Product> getProducts(){
        return myProducts;
    }

    public Product getProductById(int prodId){
        //to fetch product based on id I'll use stream API:
        return myProducts.stream()
                .filter(element -> element.getProdId() == prodId)
                .findFirst()//using findFirst as I have unique id otherwise spring will continue to find
                .get();
    }

    public void addProduct(Product prod){
        myProducts.add(prod);
    }

    public void updateProduct(Product prod){
        int index = -1;
        for(int i =0;i<myProducts.size();i++)
        {
            if(myProducts.get(i).getProdId() == prod.getProdId())
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            System.out.println("Product can't be found");
        }
        else{
            myProducts.set(index, prod);
        }
    }

    public void deleteProduct(int prodId){
        int index = -1;
        for(int i =0;i<myProducts.size();i++)
        {
            if(myProducts.get(i).getProdId() == prodId)
            {
                index = i;
                break;
            }
        }
        if(index == -1)
        {
            System.out.println("Product can't be found");
        }
        else{
            myProducts.remove(index);
        }

    }
}
