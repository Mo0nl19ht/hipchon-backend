package gritbus.hipchonbackend.Dto;

import gritbus.hipchonbackend.Domain.Hashtag;
import gritbus.hipchonbackend.Domain.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BestPostDto {
	private Long postId;
	private String title;
	private Long hashtagId;
	private String hashtagName;
	private String hashtagImage;

	public static BestPostDto of(Post p) {
		Hashtag hashtag = p.getPlace().getPlaceHashtagList().get(0).getHashtag();

		return new BestPostDto(
			p.getId(),
			p.getTitle(),
			hashtag.getId(),
			hashtag.getName(),
			hashtag.getImage()
		);
	}

}
