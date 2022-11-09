package com.worldexplorer.shoppingservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.worldexplorer.shoppingservice.entity.InvoiceItem;

public interface InvoiceItemsRepository extends JpaRepository<InvoiceItem,Long> {
}
