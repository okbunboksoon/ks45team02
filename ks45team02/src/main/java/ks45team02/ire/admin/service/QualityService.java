package ks45team02.ire.admin.service;

import ks45team02.ire.admin.dto.Quality;
import ks45team02.ire.admin.mapper.QualityMapper;
import org.springframework.stereotype.Service;

@Service
public class QualityService {

    private final QualityMapper qualityMapper;

    public QualityService(QualityMapper qualityMapper) {
        this.qualityMapper = qualityMapper;
    }


    public void addQualityGeneralLevel(Quality quality) {

        qualityMapper.addQualityGeneralLevel(quality);
    }

    public void addQualityHazadousSubstanceLevel(Quality quality) {
        qualityMapper.addQualityHazadousSubstanceLevel(quality);
    }

    public Quality qualityGeneralLevelInfo(String generalQualityLevel) {
        Quality qualityGeneralLevelInfo = qualityMapper.qualityGeneralLevelInfo(generalQualityLevel);
        return qualityGeneralLevelInfo;
    }

    public int modifyQualityGeneralLevel(Quality quality) {
        int result = qualityMapper.modifyQualityGeneralLevel(quality);
        return result;

    }

    public Quality qualityHazadousSubstanceLevelInfo(String hazadousQualityLevel) {
        Quality qualityHazadousSubstanceLevelInfo = qualityMapper.qualityHazadousSubstanceLevelInfo(hazadousQualityLevel);
        return qualityHazadousSubstanceLevelInfo;
    }

    public int modifyQualityHazadousSubstanceLevel(Quality quality) {
        int result = qualityMapper.modifyQualityHazadousSubstanceLevel(quality);
        return result;
    }

    public Quality deleteQualityGeneralLevelInfo(String generalQualityLevel) {
        Quality deleteQualityGeneralLevelInfo = qualityMapper.deleteQualityGeneralLevelInfo(generalQualityLevel);
        return deleteQualityGeneralLevelInfo;
    }

    public int deleteQualityGeneralLevel(Quality quality) {
        int result = qualityMapper.deleteQualityGeneralLevel(quality);
        return result;
    }

    public Quality deleteQualityHazadousSubstanceLevelInfo(String hazadousQualityLevel) {
        Quality deleteQualityHazadousSubstanceLevelInfo = qualityMapper.deleteQualityHazadousSubstanceLevelInfo(hazadousQualityLevel);
        return deleteQualityHazadousSubstanceLevelInfo;
    }

    public int deleteQualityHazadousSubstanceLevel(Quality quality) {
        int result = qualityMapper.deleteQualityHazadousSubstanceLevel(quality);
        return result;
    }

    public void addRequestQualityInspection(Quality quality) {
        qualityMapper.addRequestQualityInspection(quality);
    }

    public void addInspectionStandard(Quality quality) {
        qualityMapper.addInspectionStandard(quality);
    }
}
