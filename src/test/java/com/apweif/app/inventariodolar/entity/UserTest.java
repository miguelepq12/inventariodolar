package com.apweif.app.inventariodolar.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testInitClass() {
        User userConst=new User("Miguel","Pina");
        Assertions.assertEquals("Miguel",userConst.getUsername());
        Assertions.assertEquals("Pina",userConst.getPass());
    }
}
