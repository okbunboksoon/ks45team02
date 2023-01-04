package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.mapper.BasketMapper;
import ks45team02.ire.admin.mapper.GoodsMapper;

@Service
@Transactional
public class BasketService {

	private static final Logger log = LoggerFactory.getLogger(DonationService.class);
	
	private final BasketMapper basketMapper;
	private final GoodsMapper goodsMapper;
	
	public BasketService(BasketMapper basketMapper, GoodsMapper goodsMapper) {
		this.basketMapper = basketMapper;
		this.goodsMapper = goodsMapper;
	}
	
	/**
	 * 상품 검색
	 * @param searchKey
	 * @param searchValue
	 * @return List<Goods>
	 */
	public List<Goods> searchGoods(String searchKey, String searchValue){
		
		if(searchKey != null && searchValue != null) {
			switch(searchKey) {
			case "goodsCode"
			: searchKey = "goods_code";
			break;
			case "goodsName"
			: searchKey = "goods_name";
			break;
			}
		}
		
		List<Goods> goodsList = goodsMapper.searchGoods(searchKey, searchValue);
		
		return goodsList;
	}
	
	/**
	 * 장바구니 조회
	 * @return List<Basket>
	 */
	public List<Basket> getBasketList() {
		
		List<Basket> BasketList = basketMapper.getBasketList();
		
		return BasketList;
	}
}
