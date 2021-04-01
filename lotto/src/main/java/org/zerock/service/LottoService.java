package org.zerock.service;


import org.zerock.domain.LottoVO;

public interface LottoService {
	//�� ��Ϻ���
	public int[] cal(LottoVO vo);
	
	public int[] getlotto(long num);
	
	public int check(int num, int[] lotto);
}
