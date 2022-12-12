package com.store.utils;

import java.text.DecimalFormat;

import org.springframework.stereotype.Component;

/**
 * @author hieun
 * 11 Aug 2022  14:04:38
 *
 * cloud.com.store.utils.FormatMoney
 */

@Component
public class FormatMoney {
	
	public String priceWithDecimal(int price) {
		
		DecimalFormat formatter = new DecimalFormat("###,###,###");
		
		return formatter.format(price);
	}
}
