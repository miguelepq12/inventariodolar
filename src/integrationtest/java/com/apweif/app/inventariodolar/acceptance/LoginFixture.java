package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.User;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class LoginFixture {

    User onlyUser;

    boolean existUser(String username, String pass){
        onlyUser=new User("miguelepq","1234");
        return onlyUser.getUsername().equals(username)&&onlyUser.getPass().equals(pass);
    }

    public Result login(String user, String pass) {
        if(existUser(user,pass)){
            return new Result("Exitoso","Exitoso");
        }else{
            return new Result("No Exitoso","Datos ingresados son invalidos");
        }
    }
}