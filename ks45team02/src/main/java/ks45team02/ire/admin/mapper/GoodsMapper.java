package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsMapper {
	
	//상품 코드 존재 여부 확인
	public int goodsCheck(String goodsCode);
	
	//상품 검색
	public List<Goods> searchGoods(String searchKey, String searchValue);
	
	public List<Goods> getListGoods();
	//전체 업사이클링 상품별 이산화탄소 총배출량(kg)계산용
	public Goods getIncomingEmissionLevel(String goodsCode);

}
