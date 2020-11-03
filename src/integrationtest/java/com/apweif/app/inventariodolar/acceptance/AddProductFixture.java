package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.Category;
import com.apweif.app.inventariodolar.entity.Product;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(ConcordionRunner.class)
public class AddProductFixture {


    public Result addProduct(String name,String description,String category,int price){
        if(name.equals("")|| category.equals("")){
            return new Result("No Exitoso", "Ingrese los datos requeridos");
        }else{
            Product p =new Product(0,name,description,new Category(0l,category,"","",LocalDateTime.now()),
                    price, LocalDateTime.now());
            return new Result("Exitoso", "Producto agregado con exito");
        }
    }
}