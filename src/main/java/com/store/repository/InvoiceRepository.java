package com.store.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.dto.InforCusInvoiceDto;
import com.store.dto.InforProInvoiceDetailDto;
import com.store.dto.InvoiceDetailDto;
import com.store.model.Invoice;

/**
 * @author hieun
 * 14 Aug 2022  11:21:04
 *
 * cloud.com.store.repository.InvoiceRepository
 */

@Repository
public class InvoiceRepository {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	public List<Invoice> getAllInvoices(){
		SqlSession session = sqlFactory.openSession();	
		List<Invoice> listInvoices = session.selectList("invoice.selectAllInvoices");
		session.close();
		
		return listInvoices;
	}
	
	public List<Invoice> getAllOrders(){
		SqlSession session = sqlFactory.openSession();	
		List<Invoice> listOrders = session.selectList("invoice.selectAllOrders");
		session.close();
		
		return listOrders;
	}

	/**
	 * @param id
	 * @return
	 */
	public Invoice getOneOrder(int id) {
		SqlSession session = sqlFactory.openSession();	
		Invoice oneOrder = session.selectOne("invoice.selectOneOrder", id);
		session.close();
		
		return oneOrder;
	}

	/**
	 * @param order
	 * 
	 * SQL update, insert, delete ==> session.commit() 
	 */
	public int updateOrder(int id, int state) {
		SqlSession session = sqlFactory.openSession();	
		Map<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("id", id);
		map.put("state", state);
		int result  = session.update("invoice.updateOrder", map);
		session.commit();
		session.close();
		
		return result;
		
	}
	
	public List<InvoiceDetailDto> getInvoiceDetail(int id){
		SqlSession session = sqlFactory.openSession();	
		List<InvoiceDetailDto> invoiceDetailDto = session.selectList("invoice.selectInvoiceDetail", id);
		session.close();
		System.out.println("repo" + invoiceDetailDto.size());
		
		return invoiceDetailDto;
	}
	
	public InforCusInvoiceDto getInforCusInvoice(int id){
		SqlSession session = sqlFactory.openSession();	
		InforCusInvoiceDto result = session.selectOne("invoice.selectInforCusInVoice", id);
		session.close();
		
		return result;
	}
	
	public List<InforProInvoiceDetailDto> getInforProInvoiceDetail(int id){
		SqlSession session = sqlFactory.openSession();	
		List<InforProInvoiceDetailDto> result = session.selectList("invoice.selectProInvoiceDetail", id);
		session.close();
		System.out.println("repo" + result.size());
		
		return result;
	}
}
