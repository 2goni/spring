package com.mit.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTest {
	@Autowired
	private Restaurant restaurant;
	
	@Test
	public void testExist() {
		assertNotNull(restaurant);
		//입력한 객체가 null이 아니라면 성공 
		log.info("로그 테스트중");
		log.info(restaurant);
		
	}
	
	@Test
	public void javatest() {
		Chef aaa = new Chef();
		log.info(aaa);
	}
	
	@Test
	public void javatest1() {
		log.info(restaurant);
	}
}