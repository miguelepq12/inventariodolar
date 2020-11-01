package com.apweif.app.inventariodolar.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultTest {
    @Test
    void testInitResult() {
        Result rC=new Result("e","msj");
        Assertions.assertEquals("e",rC.getEstado());
        Assertions.assertEquals("msj",rC.getMensaje());
    }
}
