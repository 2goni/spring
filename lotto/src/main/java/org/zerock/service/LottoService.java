package org.zerock.service;


import org.zerock.domain.LottoVO;

public interface LottoService {
	//�� ��Ϻ���
	public int[] cal(LottoVO vo);
	
	public int check(int num, int[] lotto);
	
	int getRandom(long num);

	int[] getLotto(long num);
	
}
