package ks45team02.ire.admin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.Vat;
import ks45team02.ire.admin.mapper.VatMapper;

@Service
public class VatService {
	
	private VatMapper vatMapper;
	
	public VatService(VatMapper vatMapper) {
		this.vatMapper = vatMapper;
	}

	
	
	private static final Logger log = LoggerFactory.getLogger(VatService.class);

	
	/**
	 * 부가세 계산 조회
	 */
	public List<Vat> getListVat(){
		List<Vat> vatList = vatMapper.getListVat();
		
		return vatList;
	}
}
