package gritbus.hipchonbackend;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import gritbus.hipchonbackend.Dto.KeywordDto;
import gritbus.hipchonbackend.Repository.KeywordReviewRepository;


@SpringBootTest
@Transactional(readOnly = true)
public class KeywordTest {

	@Autowired
	KeywordReviewRepository keywordReviewRepository;

	@Test
	@DisplayName("get top 3 keyword")
	public void getTop3() throws Exception{

		//given
		Long placeId=1L;

		//when
		List<KeywordDto> top3 = keywordReviewRepository.getTop3(placeId);
		for (KeywordDto keywordDto : top3) {
			System.out.print("keyword = " + keywordDto.getKeyword());
			System.out.println("  postCnt = " + keywordDto.getPostCnt());
		}
		//then
		assertThat(top3.size())
			.isEqualTo(3);

	}
}