package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Goods;

@Mapper
public interface GoodsMapper {
	
	//상품 코드 존재 여부 확인
	public int goodsCheck(String goodsCode);
	
	//상품 검색
	public List<Goods> searchGoods(String searchKey, String searchValue);
	
	// 상품 판매단가 및 전체 검색
	public List<Goods> searchGoodsUnitprice(String searchKey, String searchValue);
	
	// 상품 전체 조회
	public List<Goods> getListGoods();
	
	// 상품코드로 상품 및 단가 검색
	public List<Goods> getListGoodsAndUnitPrice(String goodsCode);
	
	// 상품 이름 중복 체크
	public boolean checkGoodsName(String goodsName);
	
	// 상품 등록 처리
	public int addGoods(Goods goods);
	
	// 상품 수정
	public int modifyGoods(Goods goods);
	// FirstFabric 가져오기
	public String getFirstFabic(Goods goods);
	
	// LastFabric 가져오기
	public String getLastFabic(Goods goods);
	
	// FirstRate 가져오기
	public int getFirstRate(Goods goods);
	
	// LastRate 가져오기
	public int getLastRate(Goods goods);
	
	// 레벨 등록
	public int updateEmissionLevel(double emissionLevel);
	
	// 상품 삭제
	public int deleteGoods(String goods);

}
