package com.apweif.app.inventariodolar.acceptance;

import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.User;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

@RunWith(ConcordionRunner.class)
public class LogoutFixture {

    List<User> users;


    public Result logout(){
        return new Result("Exitoso","");
    }
}