package org.zerock.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LottoDTO {
	private int lnum1;
	private int lnum2;
	private int lnum3;
	private int lnum4;
	private int lnum5;
	private int lnum6;
}
