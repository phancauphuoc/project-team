 package com.store.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.store.dto.StatisticDto;


/**
 * 
 * @author hieun
 *
 */

@Repository
public class StatisticRepository {
	
	@Autowired
	private SqlSessionFactory sqlFactory;
	
	public int getTotalRevenue(){
		SqlSession session = sqlFactory.openSession();	
		int totalRevenue = session.selectOne("statistic.selectTotalRevenue");
		session.close();
		
		return totalRevenue;
	}
	
	public int getTotalRevenueByMonth(int month){
		SqlSession session = sqlFactory.openSession();	
		Object revenueByMonth = session.selectOne("statistic.selectTotalRevenueByMonth", month);
		if(revenueByMonth == null) {
			session.close();
			return 0;
		}else {
			int rersult = (int) revenueByMonth;
			session.close();
			return rersult;
		}
	}
	
	public int getMaxMonth() {
		SqlSession session = sqlFactory.openSession();	
		int maxMonth = session.selectOne("statistic.selectMaxMonth");
		session.close();
		
		return maxMonth;
	}
	
	
	public List<StatisticDto> getTop4Seller() {
		SqlSession session = sqlFactory.openSession();	
		List<StatisticDto> top4List = session.selectList("statistic.selectTop4Seller");
		session.close();
		
		return top4List;
	}
	
	public List<StatisticDto> getOneTopProductWithMonth(int idProduct) {
		SqlSession session = sqlFactory.openSession();
		List<StatisticDto> oneProByMonth = session.selectList("statistic.selectOneTopProductWithMonth", idProduct);
		session.close();
		
		return oneProByMonth;
	}
	

}
