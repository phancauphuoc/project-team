package com.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dto.StatisticDto;
import com.store.repository.StatisticRepository;
import com.store.utils.FormatMoney;

/**
 * @author hieun
 * 11 Aug 2022  13:54:01
 *
 * cloud.com.store.service.InvoiceDetailService
 */

@Service
public class StatisticService {

	@Autowired
	private StatisticRepository statisticRepo;
	
	@Autowired
	private FormatMoney formater;
	
	public String getTotalRenevue() {
		String result = formater.priceWithDecimal(statisticRepo.getTotalRevenue());
		
		return result;
	}
	
	public Map<Integer, String> getTotalRenevueByMonth(){
		int month = statisticRepo.getMaxMonth();
		Map<Integer, String> result = new HashMap<Integer, String>();
		for(int i = 1; i <= month; i++) {
			String revenueFormat = formater.priceWithDecimal(statisticRepo.getTotalRevenueByMonth(i));
			result.put(i, revenueFormat);
		}
		
		return result;
	}
	
	public List<StatisticDto> getTop4Product(){
		List<StatisticDto> listTop4 =  statisticRepo.getTop4Seller();
		return listTop4;
	}

	
	public Map<String, List<StatisticDto>> getOneTopProductWithMonth() {
		List<StatisticDto> listTop4 =  statisticRepo.getTop4Seller();
		Map<String, List<StatisticDto>> map = new HashMap<String, List<StatisticDto>>();
		
		int proTop1 = (listTop4.get(0).getIdProduct());
		int proTop2 = (listTop4.get(1).getIdProduct());
		int proTop3 = (listTop4.get(2).getIdProduct());
		int proTop4 = (listTop4.get(3).getIdProduct());
				
		List<StatisticDto> listProTop1 = statisticRepo.getOneTopProductWithMonth(proTop1);
		List<StatisticDto> listProTop2 = statisticRepo.getOneTopProductWithMonth(proTop2);
		List<StatisticDto> listProTop3 = statisticRepo.getOneTopProductWithMonth(proTop3);
		List<StatisticDto> listProTop4 = statisticRepo.getOneTopProductWithMonth(proTop4);
	
		map.put("ProductTop1", listProTop1);
		map.put("ProductTop2", listProTop2);
		map.put("ProductTop3", listProTop3);
		map.put("ProductTop4", listProTop4);
		
		return map;
		
	}
	
	
}
