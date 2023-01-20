package ks45team02.ire.admin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsDay;
import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsMonth;
import ks45team02.ire.admin.dto.RawMaterialsEmissionStatisticsYear;

@Mapper
public interface EmissionStatisticsMapper {
	
	/**
	 * 기부받은 의류별 CO2 일별 전체 조회
	 */
	public List<RawMaterialsEmissionStatisticsDay>  rawMaterialsDaySearch();
	
	/**
	 * 기부받은 의류별 CO2 일별 전체 조회
	 */
	public List<RawMaterialsEmissionStatisticsMonth>  rawMaterialsMonthSearch();
	
	/**
	 * 기부받은 의류별 CO2 일별 전체 조회
	 */
	public List<RawMaterialsEmissionStatisticsYear>  rawMaterialsYearhSearch();
	
	/**
	 * 기부받은 의류별 CO2 등록날짜
	 */
	public String getRawMaterialsIncomingDate(String rawMaterialsCode);
	
	/**
	 * 기부받은 의류별 CO2 일별 통계 추가
	 */
	public int rawMaterialsDayAdd (RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay);
	
	/**
	 * CO2 통계 입고 그룹코드 존재 여부 확인
	 */
	public int rawMaterialsDayCheck (String rawMaterialsDaygroup);
	
	/**
	 * co2 통계 월별 그룹코드 존재확인
	 */
	public int rawMaterialsMonthCheck (String monthCode);
	/**
	 * 기부받은 의류별 CO2 일별 일반 상품별 이산화탄소 배출량 조회
	 */
	public int rawMaterialsDaySumSelect (String rawMaterialsDaygroup);
	
	/**
	 * 기부받은 의류별 CO2 일별 등록날짜 생성
	 */
	public String addYearAndMonth(String rawMaterialsIncomingDate);
	
	/**
	 * 기부받은 의류별 CO2 일별 통계 업데이트
	 */
	public int rawMaterialsDayUpdate(RawMaterialsEmissionStatisticsDay rawMaterialsEmissionStatisticsDay);

	/**
	 * 월별 등록 이산화탄소 합계
	 */
	public int getMonthEmissionSum(String monthCode);
	
	/**
	 * 월별 등록
	 */
	public int addrawMaterialsMonth(RawMaterialsEmissionStatisticsMonth rawMaterialsEmissionStatisticsMonth);
	
	/**
	 * 월별 업데이트
	 */
	public int updaterawMaterialsMonth(RawMaterialsEmissionStatisticsMonth rawMaterialsEmissionStatisticsMonth);

	/**
	 * 년별 존재 확인
	 */
	public int rawMaterialsYearCheck(String yearCode);
	
	/**
	 * 년별 year 추출
	 */
	public String getYear(String yearCode);
	
	/**
	 * 년별 month 추출
	 */
	public String getMonth(String yearCode);
	
	/**
	 * 년별 등록
	 */
	public int addrawMaterialsYear(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 년별 월 코드 합계 추출
	 */
	public int getEmissionSum(String yearCode);
	
	/**
	 * 1월 업데이트
	 */
	public int updateJan(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 2월 업데이트
	 */
	public int updateFeb(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 3월 업데이트
	 */
	public int updateMar(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 4월 업데이트
	 */
	public int updateApr(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 5월 업데이트
	 */
	public int updateMay(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 6월 업데이트
	 */
	public int updateJun(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 7월 업데이트
	 */
	public int updateJul(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 8월 업데이트
	 */
	public int updateAug(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 9월 업데이트
	 */
	public int updateSept(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 10월 업데이트
	 */
	public int updateOct(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 11월 업데이트
	 */
	public int updateNov(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
	
	/**
	 * 12월 업데이트
	 */
	public int updateDec(RawMaterialsEmissionStatisticsYear rawMaterialsEmissionStatisticsYear);
}
