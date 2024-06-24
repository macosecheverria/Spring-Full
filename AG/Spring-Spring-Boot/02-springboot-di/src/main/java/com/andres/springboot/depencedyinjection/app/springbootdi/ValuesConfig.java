package com.andres.springboot.depencedyinjection.app.springbootdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.io.Resource;

import com.andres.springboot.depencedyinjection.app.springbootdi.repositories.IProductRepository;
import com.andres.springboot.depencedyinjection.app.springbootdi.repositories.ProductRepositoryJson;

@Configuration
@PropertySources({
    @PropertySource(value = "classpath:config.properties", encoding = "UTF-8")
})
public class ValuesConfig {

    @Value("classpath:json/product.json")
    private Resource resource;

    @Bean("productJson")
    public IProductRepository iProductRepositoryJson(){
        return  new ProductRepositoryJson(resource);
    }


}
