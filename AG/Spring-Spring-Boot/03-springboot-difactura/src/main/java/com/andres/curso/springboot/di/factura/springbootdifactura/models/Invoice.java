package com.andres.curso.springboot.di.factura.springbootdifactura.models;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
// import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
// @RequestScope
@SessionScope
@JsonIgnoreProperties({"targetSource", "advisors"})
public class Invoice {

    @Autowired
    private Client client;

    @Value("${invoice.description.office}")
    private String description;

    @Autowired
    @Qualifier("default")
    private List<Item> items;

    public Invoice() {
        System.out.println("Creando El componente de la factura");
        System.out.println(client);
        System.out.println(description);
    }

    @PostConstruct
    public void init() {
        System.out.println("Creando El componente de la factura");
        client.setName(client.getName().concat(" Antonio"));
        description = description.concat(" del  cliente ").concat(client.getName()).concat(" "  + client.getLastname());
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Destruyendo el componente o bean invoice");
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public int getTotal() {
        int total = items.stream().map(item -> item.getAmount()).reduce(0, (sum, amout) -> sum + amout);

        return total;

        // for (var item : items) {
        // total += item.getAmount();
        // }
        // return total;

    }

}
