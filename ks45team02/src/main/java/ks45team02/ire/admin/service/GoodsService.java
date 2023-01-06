package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.Goods;
import ks45team02.ire.admin.mapper.GoodsMapper;

@Service
public class GoodsService {
	
	private final GoodsMapper goodsMapper;
	
	public GoodsService(GoodsMapper goodsMapper) {
		
		this.goodsMapper = goodsMapper;
		
	}
	
	public List<Goods> getListGoods(){
		
		List<Goods> listGoods = goodsMapper.getListGoods();
		
		return listGoods;
	}
	
}
