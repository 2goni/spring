package org.zerock.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.LottoVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class LottoServiceTest {

	@Autowired
	private LottoService service;
	
	@Test
	public void cal() {
		LottoVO board = new LottoVO();
		board.setDay(5);
		board.setMonth(12);
		board.setYear(1995);
		service.cal(board);
	}
}






