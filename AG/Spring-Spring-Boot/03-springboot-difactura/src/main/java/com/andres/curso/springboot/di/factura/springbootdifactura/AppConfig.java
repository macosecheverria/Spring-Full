package com.andres.curso.springboot.di.factura.springbootdifactura;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.andres.curso.springboot.di.factura.springbootdifactura.models.Item;
import com.andres.curso.springboot.di.factura.springbootdifactura.models.Product;

@Configuration
@PropertySource(value = "classpath:data.properties", encoding = "UTF-8")
public class AppConfig {

    @Bean("itemsCamera")
    List<Item> itemsInvoiceCamera() {

        Product product1 = new Product("Camara Sony", 800);
        Product product2 = new Product("Camara Samsung", 1200);

        return List.of(new Item(product1, 2), new Item(product2, 1));

    }

    @Bean("default")
    @Primary
    public List<Item> itemsInvoiceOffice() {
        Product product1 = new Product("Monitor Asus 24", 700);
        Product product2 = new Product("Notebook Razer", 2400);
        Product product3 = new Product("Impresora Hp", 800);
        Product product4 = new Product("Escritorio Oficina", 900);

        return List.of(new Item(product1, 2), new Item(product2, 1), new Item(product3, 4), new Item(product4, 2));

    }

}
