package org.zerock.service;


import org.zerock.domain.LottoVO;
import org.zerock.domain.ManualVO;

public interface LottoService {
	
	public int[] cal(LottoVO vo, ManualVO mo); // 입력된 값으로 로또 만들기
	
	public int check(int num, int[] lotto); // 로또 중복 체크
	
	int getRandom(long num); // 랜덤 로또값 만들기

	int[] getLotto(long num); // 중복된 값없는 랜덤 로또값 주기
	
}
