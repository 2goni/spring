package org.zerock.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;
import org.zerock.domain.LottoVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LottoServiceImpl implements LottoService {

	@Override
	public int[] cal(LottoVO vo) {
		LocalDate dayday = LocalDate.now();
		long num = Math.round(dayday.getDayOfYear() * vo.getDay() * vo.getMonth() * vo.getYear());
		int[] lotto = getlotto(num);
		return lotto;
	}

	@Override
	public int[] getlotto(long num) {
		int[] lotto = new int[6];
		int rd = (int) num;
		for (int i = 0; i < lotto.length; i++) {
			rd = check(rd, lotto);
			lotto[i] = rd;
		}
		return lotto;
	}

	@Override
	public int check(int num, int[] lotto) {
		int rd = (int) (num* 0.1618);
		String[] str = Integer.toString(rd).split("");
		for(String sn : str) {
			rd +=  Integer.parseInt(sn); 
		}
		
		System.out.println(rd);
		for (int i = 0; i < lotto.length; i++) {
			if (lotto[i] == rd || rd > 45) {
				check(rd, lotto);
			}
			if (rd < 1) {
				check(rd*1618, lotto);
			}

		}
		return rd;
	}

}
