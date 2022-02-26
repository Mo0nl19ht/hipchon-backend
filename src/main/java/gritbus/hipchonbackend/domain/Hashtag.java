package gritbus.hipchonbackend.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

@Entity
@Getter
public class Hashtag {
	@Id @GeneratedValue
	private Long id;

	private String name;

	@OneToMany(mappedBy = "hashtag", cascade = CascadeType.ALL)
	private List<PlaceHashtag> placeHashtagList = new ArrayList<>();

}
