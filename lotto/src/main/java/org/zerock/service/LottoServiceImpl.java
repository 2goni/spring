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
		long num = Math.round(dayday.getYear() * dayday.lengthOfMonth() * dayday.getDayOfYear() * vo.getDay() * vo.getMonth() * vo.getYear() * 1.618);
		int[] auto = getLotto(num);
		int[] lotto = mo.getall();
		for (int i = 0; i < 6; i++) {
			if (lotto[i] == 0) {
				lotto[i] = check(auto[i], lotto);
			}
		}
		return sort(lotto);
	}

	@Override
	public int[] getLotto(long num) {
		int[] lotto = new int[6];
		long rd = num;
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = check(getRandom(rd), lotto);
			rd = (long) (rd*1.618);
		}
		return lotto;
	}

	@Override
	public int getRandom(long num) {
		Random random = new Random(num);
		int rd = random.nextInt(45) + 1;
		return rd;
	}

	@Override
	public int check(int num, int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			if (lotto[i] == num) {
				num = getRandom(Math.round(num * 1.618));
				check(num, lotto);
			}
		}
		return num;
	}

	@Override
	public int[] sort(int[] lotto) {
		for (int i = 0; i < lotto.length; i++) {
			for (int j = i; j < lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int tmp = lotto[i];
					lotto[i] = lotto[j]; 
					lotto[j] = tmp; 
				}
			}
		}
		return lotto;
	}

}
