package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.User;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(ConcordionRunner.class)
public class RegisterFixture {

    List<User> users;

    @Before
    public void before() throws Exception {
        User userNew=new User("miguelepq12","1234","miguel12@gmail.com");
        users=new ArrayList<>();
        users.add(userNew);
    }
    boolean existUsername(String username){
        return users.stream().anyMatch(user -> user.getUsername().equals(username));
    }

    boolean existEmail(String email){
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    boolean isValidPass(String pass, String passRepeat){
        return pass.equals(passRepeat) && pass.length()>=4;
    }

    public Result register(String user, String pass, String passRepeat, String email) {
        if(existUsername(user)||existEmail(email)){
            return new Result("No Exitoso","El usuario o correo ya existe. Ingrese uno nuevo");
        }else if(!isValidPass(pass,passRepeat)){
            return new Result("No Exitoso","La contraseña no es valida");
        }else{
            return new Result("Exitoso","Exitoso");
        }
    }
}