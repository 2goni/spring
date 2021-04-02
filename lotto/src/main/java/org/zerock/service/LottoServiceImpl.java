package org.zerock.service;

import java.time.LocalDate;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.zerock.domain.LottoVO;
import org.zerock.domain.ManualVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LottoServiceImpl implements LottoService {

	@Override
	public int[] cal(LottoVO vo, ManualVO mo) {
		LocalDate dayday = LocalDate.now();
		long num = Math.round(dayday.getDayOfYear() * vo.getDay() * vo.getMonth() * vo.getYear()*1.618);
		int[] lotto = getLotto(num);
		for(int i=0; i<6; i++) {
			int[] ins = mo.getall();
			if(ins[i] != 0) {
				lotto[i] = check(ins[i],lotto);
			}
		}
		return lotto;
	}
	
	@Override
	public int[] getLotto(long num) {
		int[] lotto = new int[6];
		int rd = 0;
		for (int i = 0; i < lotto.length; i++) {
			rd = check(getRandom(num),lotto);
			lotto[i] = rd;
		}
		return lotto;
	}
	
	@Override
	public int getRandom(long num) {
		Random random = new Random(num);
		int rd = random.nextInt(45)+1;
		return rd;
	}
	
	
	@Override
	public int check(int num, int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			if (lotto[i] == num) {
				num = getRandom(Math.round(num*1.618));
				check(num,lotto);
			}
		}
		return num;
	}

}
