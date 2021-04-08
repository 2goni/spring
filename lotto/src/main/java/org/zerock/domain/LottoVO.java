package org.zerock.domain;


import lombok.Data;

@Data
public class LottoVO {
	private String name;
	private int year;
	private int month;
	private int day;
	
	
	public int getName() {
		int numName = 0;
		for(int i = 0; i < name.length(); i++) {
			numName += (int) (name.toCharArray()[i]);
		}
		return numName;
	}
}
