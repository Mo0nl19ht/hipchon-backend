package gritbus.hipchonbackend.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class City {
	@Id @GeneratedValue
	@Column(name = "city_id")
	private Long id;

	private String name;

	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
	private List<Place> placeList = new ArrayList<>();

}
