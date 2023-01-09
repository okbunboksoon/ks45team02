package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Buynow;
import ks45team02.ire.admin.mapper.BuynowMapper;

@Service
@Transactional
public class BuynowService {

	private static final Logger log = LoggerFactory.getLogger(BuynowService.class);

	private final BuynowMapper buynowMapper;
	
	public BuynowService(BuynowMapper buynowMapper) {
		this.buynowMapper = buynowMapper;
	}
	
	/**
	 * 즉시구매 조회
	 * @return List<Buynow>
	 */
	public List<Buynow> getBuynowList(){
		
		List<Buynow> buynowList = buynowMapper.getBuynowList();
		 
		return buynowList;
	}
	
}
