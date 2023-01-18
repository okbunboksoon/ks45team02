package ks45team02.ire.admin.mapper;

import ks45team02.ire.admin.dto.Quality;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface QualityMapper {
    List<Quality> getQualityGeneralLevelList();

    void addQualityGeneralLevel(Quality quality);

    List<Quality> getQualityHazadousSubstanceLevelList();

    List<Quality> getQualityInspectionStandardList();

    void addQualityHazadousSubstanceLevel(Quality quality);

    Quality qualityGeneralLevelInfo(String generalQualityLevel);

    int modifyQualityGeneralLevel(Quality quality);

    Quality qualityHazadousSubstanceLevelInfo(String hazadousQualityLevel);

    int modifyQualityHazadousSubstanceLevel(Quality quality);

    Quality deleteQualityGeneralLevelInfo(String generalQualityLevel);

    int deleteQualityGeneralLevel(Quality quality);

    Quality deleteQualityHazadousSubstanceLevelInfo(String hazadousQualityLevel);

    int deleteQualityHazadousSubstanceLevel(Quality quality);

    List<Quality> qualityInspectionRequestList();

    void addRequestQualityInspection(Quality quality);

    List<Map<String, Object>> qualityInspectionRequestInfo();

    Quality InspectionStandardInfo();

    void addInspectionStandard(Quality quality);
}
