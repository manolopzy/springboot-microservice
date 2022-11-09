package com.worldexplorer.shoppingservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.worldexplorer.shoppingservice.entity.Invoice;
import com.worldexplorer.shoppingservice.entity.InvoiceItem;
import com.worldexplorer.shoppingservice.model.Customer;
import com.worldexplorer.shoppingservice.model.Product;
import com.worldexplorer.shoppingservice.msclient.CustomerServiceClient;
import com.worldexplorer.shoppingservice.msclient.ProductServiceClient;
import com.worldexplorer.shoppingservice.repository.InvoiceItemsRepository;
import com.worldexplorer.shoppingservice.repository.InvoiceRepository;

@Service
public class InvoiceServiceImpl implements InvoiceService {

	@Autowired
	InvoiceRepository invoiceRepository;

	@Autowired
	InvoiceItemsRepository invoiceItemsRepository;
	
	@Autowired
	CustomerServiceClient customerClient;

	@Autowired
	ProductServiceClient productClient;

	@Override
	public List<Invoice> findInvoiceAll() {
		return invoiceRepository.findAll();
	}

	@Override
	public Invoice createInvoice(Invoice invoice) {
		Invoice invoiceDB = invoiceRepository.findByInvoiceNumber(invoice.getInvoiceNumber());
		if (invoiceDB != null) {
			return invoiceDB;
		}
		invoice.setState("CREATED");
		invoiceDB = invoiceRepository.save(invoice);
		//update a list at the same time instead of one by one
		invoiceDB.getItems().forEach(invoiceItem -> {
			productClient.updateStock(invoiceItem.getProductId(), invoiceItem.getQuantity() * -1);
		});

		return invoiceDB;
	}

	@Override
	public Invoice updateInvoice(Invoice invoice) {
		Invoice invoiceDB = getInvoice(invoice.getId());
		if (invoiceDB == null) {
			return null;
		}
		invoiceDB.setCustomerId(invoice.getCustomerId());
		invoiceDB.setDescription(invoice.getDescription());
		invoiceDB.setInvoiceNumber(invoice.getInvoiceNumber());
		invoiceDB.getItems().clear();
		invoiceDB.setItems(invoice.getItems());
		return invoiceRepository.save(invoiceDB);
	}

	@Override
	public Invoice deleteInvoice(Invoice invoice) {
		Invoice invoiceDB = getInvoice(invoice.getId());
		if (invoiceDB == null) {
			return null;
		}
		invoiceDB.setState("DELETED");
		return invoiceRepository.save(invoiceDB);
	}

	@Override
	public Invoice getInvoice(Long id) {

		Invoice invoice = invoiceRepository.findById(id).orElse(null);
		if (null != invoice) {
			Customer customer = customerClient.getCustomer(invoice.getCustomerId()).getBody();
			invoice.setCustomer(customer);
			List<InvoiceItem> listItem = invoice.getItems().stream().map(invoiceItem -> {
				Product product = productClient.getProduct(invoiceItem.getProductId()).getBody();
				invoiceItem.setProduct(product);
				return invoiceItem;
			}).collect(Collectors.toList());
			invoice.setItems(listItem);
		}
		return invoice;
	}
}
