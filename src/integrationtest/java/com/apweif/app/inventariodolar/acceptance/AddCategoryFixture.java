package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.Category;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.time.LocalDateTime;

@RunWith(ConcordionRunner.class)
public class AddCategoryFixture {

    public Result addCategory(String name, String description, String color){
        if(name.equals("")|| color.equals("")){
            return new Result("No Exitoso", "Ingrese los datos requeridos");
        }else{
            Category category =new Category(0,name,description,color, LocalDateTime.now());
            return new Result("Exitoso", "Categoría agregada con exito");
        }
    }
}
