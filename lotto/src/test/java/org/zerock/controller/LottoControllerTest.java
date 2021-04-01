package org.zerock.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class LottoControllerTest {

	@Autowired
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {  //��Ʈ�ѷ��� /board/list ���۵Ǵ��� �׽�Ʈ
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/lotto/main"))
		.andReturn().getModelAndView().getModelMap());
	}
	
	@Test
	public void testRegister() throws Exception { //board/register
		log.info(mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "�׽�Ʈ2")
				.param("content","�׽�Ʈ2 ����")
				.param("writer", "�ۼ���")
				).andReturn().getModelAndView().getViewName());
		
	}
	
	@Test
	public void testGet() throws Exception { //board/get
		log.info("�����!!!!"+mockMvc.perform(MockMvcRequestBuilders.get("/board/read")
				.param("bno", "2")).andReturn()
				.getModelAndView().getModelMap());
	}
}









