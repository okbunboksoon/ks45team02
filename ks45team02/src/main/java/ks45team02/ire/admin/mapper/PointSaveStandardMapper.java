package ks45team02.ire.admin.mapper;


import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PointSaveStandardMapper {

	//포인트 적립금 조회
	public int getPointSave(String pointSaveStandardCode);
	
}
