package org.zerock.domain;

import java.util.Date;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class UserVO {
	private String id;
	private String email;
	private int lnum1;
	private int lnum2;
	private int lnum3;
	private int lnum4;
	private int lnum5;
	private int lnum6;
	private Date userUpdate;
	private String ip;
	private String browser;
	private String device;
	private String useragent;

	public void setNum(int[] lotto) {
		this.lnum1 = lotto[0];
		this.lnum2 = lotto[1];
		this.lnum3 = lotto[2];
		this.lnum4 = lotto[3];
		this.lnum5 = lotto[4];
		this.lnum6 = lotto[5];
	}

	public int getIdMail() {
		int num = 0;
		for (int i = 0; i < id.length(); i++) {
			num += (int) (id.toCharArray()[i]);
		}
		for (int i = 0; i < email.length(); i++) {
			num += (int) (email.toCharArray()[i]);
		}
		return num;
	}
}
