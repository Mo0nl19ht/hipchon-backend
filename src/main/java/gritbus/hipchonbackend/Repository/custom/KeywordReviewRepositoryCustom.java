package gritbus.hipchonbackend.Repository.custom;

import java.util.List;


import gritbus.hipchonbackend.Dto.KeywordDto;

public interface KeywordReviewRepositoryCustom {
	List<KeywordDto> getTop3(Long placeId);
}