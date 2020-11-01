package com.apweif.app.inventariodolar.acceptance;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class LoginFixture {

    static User onlyUser;
    @BeforeClass
    public static void beforeClass() throws Exception {
        onlyUser=new User("miguelepq","1234");
    }

    static boolean existUser(String username, String pass){
        return onlyUser.username.equals(username)&&onlyUser.pass.equals(pass);
    }

    public Result login(String user, String pass) {
        if(existUser(user,pass)){
            return new Result("Exitoso","Exitoso");
        }else{
            return new Result("No Exitoso","Datos ingresados son invalidos");
        }
    }

    class Result {
        public Result(String estado, String mensaje) {
            this.estado = estado;
            this.mensaje = mensaje;
        }

        public String estado;
        public String mensaje;
    }

    static class User {
        public User(String username, String pass) {
            this.username = username;
            this.pass = pass;
        }

        String username;
        String pass;
    }
}