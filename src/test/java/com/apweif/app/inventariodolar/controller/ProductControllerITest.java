package com.apweif.app.inventariodolar.controller;

import com.apweif.app.inventariodolar.InventariodolarApplication;
import com.apweif.app.inventariodolar.dto.Result;
import com.apweif.app.inventariodolar.entity.Product;
import com.apweif.app.inventariodolar.entity.ProductPrice;
import com.apweif.app.inventariodolar.service.ProductPriceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = InventariodolarApplication.class)
@ComponentScan("com.apweif.app.inventariodolar")
@SpringBootTest
public class ProductControllerITest {

    private MockMvc mockMvc;

    @MockBean
    ProductPriceService service;

    @Autowired
    ProductController productController=new ProductController();

    @Autowired
    private ObjectMapper objectMapper;


    List<Product> products;
    List<ProductPrice> productPrices;

    @BeforeEach
    public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController)
                .addPlaceholderValue("server.servlet.context-path", "example").build();

        products = new ArrayList<>();
        productPrices = new ArrayList<>();

        products.add(new Product("1", "Harina", "Comida", 2));
        products.add(new Product("2", "Coca cola", "Bebidas", 4));
        products.add(new Product("3", "Harina de trigo", "Otros", 3));

        productPrices.add(new ProductPrice(products.get(0), 12));
        productPrices.add(new ProductPrice(products.get(1), 232323));
        productPrices.add(new ProductPrice(products.get(2), 3232312));

    }

    @Test
    public void addProductTest() throws Exception {
        Product productNew = new Product("1", "Harina", "Comida", 2);
        Mockito.when(service.addProduct(ArgumentMatchers.any(Product.class))).thenReturn(productNew);
        Result expectedResponseBody = new Result("Exitoso", "Producto guardado");

        MvcResult mvcResult = mockMvc.perform(post("/product")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(productNew)))
                .andExpect(status().isOk()).andReturn();

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(expectedResponseBody));
    }

    @Test
    public void getProductsTest() throws Exception {

        Page<ProductPrice> pageProductPrice = new PageImpl<>(productPrices);

        Mockito.when(service.getProductsPrice("", ""))
                .thenReturn(pageProductPrice);

        MvcResult mvcResult = mockMvc.perform(get("/products")
                .contentType("application/json")
                .param("name", "")
                .param("category", "")
                .param("page", "1"))
                .andExpect(status().isOk()).andReturn();
        ;

        String actualResponseBody = mvcResult.getResponse().getContentAsString();
        assertThat(actualResponseBody).isEqualToIgnoringWhitespace(
                objectMapper.writeValueAsString(pageProductPrice));

    }


}
