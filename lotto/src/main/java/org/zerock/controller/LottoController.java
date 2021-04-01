package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.LottoVO;
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
	
	@PostMapping("/cal")
	public void cal(Model model, LottoVO vo) {
		model.addAttribute("lotto", service.cal(vo));
	}

	
}











