package com.worldexplorer.shoppingservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldexplorer.shoppingservice.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    public List<Invoice> findByCustomerId(Long customerId );
    public Invoice findByInvoiceNumber(String invoiceNumber);
}
