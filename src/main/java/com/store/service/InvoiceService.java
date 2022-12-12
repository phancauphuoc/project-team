package com.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.InforCusInvoiceDto;
import com.store.dto.InforProInvoiceDetailDto;
import com.store.dto.InvoiceDetailDto;
import com.store.model.Invoice;
import com.store.repository.InvoiceRepository;

/**
 * @author hieun
 * 14 Aug 2022  11:16:35
 *
 * cloud.com.store.service.InvoiceService
 */

@Service
public class InvoiceService {
	
	@Autowired
	private InvoiceRepository invoiceRepo;


	/**
	 * @return
	 */
	public List<Invoice> getAllInvoices() {
	 	List<Invoice> result =  invoiceRepo.getAllInvoices();
		return result;
	}
	
	public List<Invoice> getAllOrders() {
	 	List<Invoice> result =  invoiceRepo.getAllOrders();
		return result;
	}

	/**
	 * @param id
	 * @return
	 */
	public Invoice getOneOrder(int id) {
		Invoice oneOrder = invoiceRepo.getOneOrder(id);
		return oneOrder;
	}

	public int updateOrder(int id, int  state) {
		return invoiceRepo.updateOrder(id, state);		
	}
	
	public List<InvoiceDetailDto> getInvoiceDetail(int id) {
		System.out.println("Service" + invoiceRepo.getInvoiceDetail(id).size());
		return invoiceRepo.getInvoiceDetail(id);
	}
	
	public InforCusInvoiceDto getInforCusInvoice(int id) {
		return invoiceRepo.getInforCusInvoice(id);
	}
	
	public List<InforProInvoiceDetailDto> getInforProInvoiceDetail(int id) {
		return invoiceRepo.getInforProInvoiceDetail(id);
	}

}
