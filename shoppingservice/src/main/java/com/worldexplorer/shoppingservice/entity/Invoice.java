package com.worldexplorer.shoppingservice.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.worldexplorer.shoppingservice.model.Customer;

import lombok.Data;

@Data
@Entity
@Table(name = "tlb_invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceNumber;

    private String description;

    private Long customerId;

    @Temporal(TemporalType.DATE)
    private Date createAt;


    @Valid
	/**
	 * Annotation that can be used to either suppress serialization of properties
	 * (during serialization), or ignore processing of JSON properties read (during
	 * deserialization).
	 */
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    /**
     * alter table tbl_invoce_items add constraint FKf1v7wxl08bfhjqlshp3wo1xvb 
     * foreign key (invoice_id) references tlb_invoices (id)
     * 
     * Hibernate will create a foreign key on table InvoiceItem 
     * by adding a new column called "invoice_id" on it
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "invoice_id")
    private List<InvoiceItem> items;

    private String state;

    @Transient
    private Customer customer;

    public Invoice(){
        items = new ArrayList<>();
    }

    @PrePersist
    public void prePersist() {
        this.createAt = new Date();
    }

}
