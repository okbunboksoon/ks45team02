package ks45team02.ire.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ks45team02.ire.admin.dto.Emission;
import ks45team02.ire.admin.mapper.EmissionMapper;

@Service
public class EmissionService {
	
	private final EmissionMapper emissionMapper;
	
	public EmissionService(EmissionMapper emissionMapper) {
		
		this.emissionMapper = emissionMapper;
	}
	
	
	
	public List<Emission> EmissionList(){
		
		List<Emission> EmissionList = emissionMapper.EmissionList();
		return EmissionList;
	}
}
