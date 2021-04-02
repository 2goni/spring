package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.LottoVO;
import org.zerock.domain.ManualVO;
import org.zerock.service.LottoService;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/lotto/*")
@AllArgsConstructor
public class LottoController {

	private LottoService service;
	
	@RequestMapping("/main")
	public void show() {  
	}
	//main.jsp 호출
	
	@PostMapping("/cal")
	public void cal(Model model, LottoVO vo , ManualVO mo) {
		model.addAttribute("lotto", service.cal(vo, mo));
	}
	//service.cal()메소드 사용후 model에 lotto 이름으로 담아 cal.jsp 호출
	
}











