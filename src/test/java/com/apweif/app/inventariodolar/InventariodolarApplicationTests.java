package com.apweif.app.inventariodolar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InventariodolarApplicationTests {

    @Test
    void contextLoads() {
        InventariodolarApplication.main(new String[]{""});
        Assertions.assertTrue(true);
    }

}
