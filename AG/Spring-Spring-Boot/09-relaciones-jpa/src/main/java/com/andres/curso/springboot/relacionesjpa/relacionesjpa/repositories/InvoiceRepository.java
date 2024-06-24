package com.andres.curso.springboot.relacionesjpa.relacionesjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.andres.curso.springboot.relacionesjpa.relacionesjpa.entities.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
