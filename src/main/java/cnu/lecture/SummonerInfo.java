package cnu.lecture;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tchi on 2016. 4. 25..
 */
public class SummonerInfo {

	private String id;
	public boolean setId(String id){
		this.id = id;
		return true;
	}
	public String getId() {
		return this.id;
	}

	@Getter
	@Setter
	private String name;
}
