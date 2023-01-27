package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.Vat;

@Mapper
public interface VatMapper {

	
	/**
	 * 부가세 조회
	 */
	public List<Vat> getListVat();
}
