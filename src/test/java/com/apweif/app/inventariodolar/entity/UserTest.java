package com.apweif.app.inventariodolar.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {
    @Test
    public void testInitClass() {
        User user=new User();
        user.setUsername("Miguel");
        user.setPass("12");
        Assertions.assertEquals("Miguel",user.getUsername());
        Assertions.assertEquals("12",user.getPass());

        User userConst=new User("Miguel","Pina");
        Assertions.assertEquals("Miguel",userConst.getUsername());
        Assertions.assertEquals("Pina",userConst.getPass());
    }
}
