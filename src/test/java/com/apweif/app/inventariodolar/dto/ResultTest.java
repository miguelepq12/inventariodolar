package com.apweif.app.inventariodolar.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {
    @Test
    public void testInitResult() {
        Result r=new Result();
        r.setEstado("e");
        r.setMensaje("msj");
        Assertions.assertEquals("e",r.getEstado());
        Assertions.assertEquals("msj",r.getMensaje());

        Result rC=new Result("e","msj");
        Assertions.assertEquals("e",rC.getEstado());
        Assertions.assertEquals("msj",rC.getMensaje());
    }
}
