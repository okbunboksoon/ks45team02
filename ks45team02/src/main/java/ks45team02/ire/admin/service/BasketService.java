package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.mapper.BasketMapper;

@Service
@Transactional
public class BasketService {

	private static final Logger log = LoggerFactory.getLogger(DonationService.class);
	
	private final BasketMapper basketMapper;
	
	public BasketService(BasketMapper basketMapper) {
		this.basketMapper = basketMapper;
	}
	
	public List<Basket> getBasketList() {
		
		List<Basket> BasketList = basketMapper.getBasketList();
		
		return BasketList;
	}
}
