package ks45team02.ire.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.controller.GoodsController;
import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.mapper.GoodsMapper;
import ks45team02.ire.admin.mapper.UnitPriceMapper;

@Service
public class GoodsService {
	
	private static final Logger log = LoggerFactory.getLogger(GoodsController.class);
	
	private final EmissionService emissionService;
	private final GoodsMapper goodsMapper;
	private final UnitPriceService unitPriceService;
	private final UnitPriceMapper unitPriceMapper;
	
	
	public GoodsService(GoodsMapper goodsMapper,
						EmissionService emissionService,
						UnitPriceService unitPriceService,
						UnitPriceMapper unitPriceMapper) {
		
		this.unitPriceService = unitPriceService;
		this.goodsMapper = goodsMapper;
		this.emissionService = emissionService;
		this.unitPriceMapper = unitPriceMapper;
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
	 * 상품 전체 조회
	 * @return listGoods
	 */
	public List<Goods> getListGoods(){
		
		List<Goods> listGoods = goodsMapper.getListGoods();
		
		return listGoods;
	}
	
	/**
	 * 상품코드로 상품 및 단가 검색
	 * @param goodsCode
	 * @return listGodosUnitPrice
	 */
	public List<Goods> getListGoodsAndUnitPrice(String goodsCode){
		
		List<Goods> listGodosUnitPrice =  goodsMapper.getListGoodsAndUnitPrice(goodsCode);
		
		return listGodosUnitPrice;
	}
	
	/**
	 * 상품등록
	 * @param goods
	 * @return result
	 */
	public int addGoods(Goods goods) {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		int result = goodsMapper.addGoods(goods);
		
		if(result == 1) {
			String firstFabric = goodsMapper.getFirstFabic(goods);
			String lastFabric = goodsMapper.getLastFabic(goods);
			
			int firstRate = goodsMapper.getFirstRate(goods);	
			int lastRate = goodsMapper.getLastRate(goods);
			
			paramMap.put("firstFabric", firstFabric);
			paramMap.put("lastFabric", lastFabric);
			emissionService.getGoodsEmissionLevel(paramMap);
			
			double FirstFabric = (double) paramMap.get("FirstFabric");
			double LastFabric = (double) paramMap.get("LastFabric");
			double emissionLevel = (double) ((double) (firstRate * FirstFabric)+(lastRate * LastFabric)); 
			
			goodsMapper.updateEmissionLevel(emissionLevel);
			
			unitPriceService.addUnitPrice(goods);
		}

		return result;
	}
	
	public int modifyGoods(Goods goods) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String goodsCode = goods.getGoodsCode();
		int result = 0;
		int codeCheck = goodsMapper.goodsCheck(goodsCode);
		
		if(codeCheck != 0) {
			result += goodsMapper.modifyGoods(goods);
			result += unitPriceService.modifyUnitPrice(goods);
		}else {
			result = 10;
		}
		if(result != 0) {
			String firstFabric = goodsMapper.getFirstFabic(goods);
			String lastFabric = goodsMapper.getLastFabic(goods);
			
			int firstRate = goodsMapper.getFirstRate(goods);	
			int lastRate = goodsMapper.getLastRate(goods);
			
			paramMap.put("firstFabric", firstFabric);
			paramMap.put("lastFabric", lastFabric);
			emissionService.getGoodsEmissionLevel(paramMap);
			
			double FirstFabric = (double) paramMap.get("FirstFabric");
			double LastFabric = (double) paramMap.get("LastFabric");
			double emissionLevel = (double) ((double) (firstRate * FirstFabric)+(lastRate * LastFabric)); 
			
			goodsMapper.updateEmissionLevel(emissionLevel);
		}
		return result;
	}
	
	/**
	 * 상품삭제
	 * @param goodsCode
	 * @return result
	 */
	public int deletegoods(String goodsCode) {
		
		int result = 0;
			result += unitPriceMapper.deleteUnitPrice(goodsCode);
			result += goodsMapper.deleteGoods(goodsCode);
		
		return result;
	}
}
