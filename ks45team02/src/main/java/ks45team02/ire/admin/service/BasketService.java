package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ks45team02.ire.admin.dto.Basket;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.mapper.BasketMapper;
import ks45team02.ire.admin.mapper.CategoryMapper;
import ks45team02.ire.admin.mapper.GoodsMapper;
import ks45team02.ire.admin.mapper.UserMapper;

@Service
@Transactional
public class BasketService {

	private static final Logger log = LoggerFactory.getLogger(DonationService.class);
	
	private final BasketMapper basketMapper;
	private final CategoryMapper categoryMapper;
	private final UserMapper userMapper;
	
	public BasketService(BasketMapper basketMapper, CategoryMapper categoryMapper, UserMapper userMapper) {
		this.basketMapper = basketMapper;
		this.categoryMapper = categoryMapper;
		this.userMapper = userMapper;
	}
	
	
	/**
	 * 결제 전인 장바구니 검색
	 * @param searchKey
	 * @param searchValue
	 * @return List<Baskset>
	 */
	public List<Basket> getBasketListBeforePayment(String searchKey, String searchValue){
	
		if(searchKey != null) {
			switch(searchKey) {
			case "basketCode"
			: searchKey = "basket_code";
			break;
			case "basketGroup"
			: searchKey = "basket_group";
			break;
			case "userId"
			: searchKey = "user_id";
			break;
			}
		}
		
		List<Basket> basketListBeforePayment = basketMapper.getBasketListBeforePayment(searchKey, searchValue);
		
		return basketListBeforePayment;
	}
	
	/**
	 * 장바구니 삭제
	 * @param basketCode
	 * @return int
	 */
	public int deleteBasket(String basketCode) {
		
		int result = 0;
		result = basketMapper.deleteBasket(basketCode);

		return result;
	}
	
	/**
	 * 장바구니 수정
	 * @param basket
	 * @return int
	 */
	public int modifyBasket(Basket basket) {
		
		int result = 0;
		
		int idCheck = userMapper.idCheck(basket.getUserId());
		int basketGroupCheck = basketMapper.checkBasketGroup(basket.getBasketGroup());
		
		if(idCheck == 0 || basketGroupCheck > 0) {
			return result;
		}
		String categoryMediumCode = categoryMapper.getCategoryMediumCodeByName(basket.getCategoryMediumName());
		basket.setCategoryMediumCode(categoryMediumCode);
		
		result = basketMapper.modifyBasket(basket);
		
		return result;
	}
	
	/**
	 * 장바구니 등록
	 * @param basket
	 * @return int
	 */
	public int addBasket(Basket basket) {
		
		int result = 0;
		int idCheck = userMapper.idCheck(basket.getUserId());
		int basketGroupCheck = basketMapper.checkBasketGroup(basket.getBasketGroup());
		
		if(idCheck == 0 || basketGroupCheck > 0) {
			return result;
		}
		String categoryMediumCode = categoryMapper.getCategoryMediumCodeByName(basket.getCategoryMediumName());
		basket.setCategoryMediumCode(categoryMediumCode);
		
		result = basketMapper.addBasket(basket);
		
		return result;
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
