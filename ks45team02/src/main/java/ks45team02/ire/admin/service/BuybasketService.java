package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buybasket;
import ks45team02.ire.admin.mapper.BuybasketMapper;

@Service
@Transactional
public class BuybasketService {

	
	private static final Logger log = LoggerFactory.getLogger(BuybasketService.class);

	
	private final BuybasketMapper buybasketMapper;
	
	public BuybasketService(BuybasketMapper buybasketMapper) {
		this.buybasketMapper = buybasketMapper;
	}
	
	/**
	 * 장바구니 구매 조회
	 * @return List<Buybasket>
	 */
	public List<Buybasket> getBuybasketList(){
		
		List<Buybasket> buybasketList = buybasketMapper.getBuybasketList();
		
		return buybasketList;
	}
	
}
