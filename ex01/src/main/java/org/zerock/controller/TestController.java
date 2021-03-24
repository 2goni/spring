package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/ex05")
	public void ex_05() {
		// ex05.jsp �������� ������.
	}

	@RequestMapping("/test2")
	public String test_2() {
		return "redirect:/result"; // ���ο� result ��û
	}

	@RequestMapping("/result")
	public String result_test() {
		return "result"; // ���ϰ��� .jsp ������.
	}

	// view �����͸� �����ؾ� �ϴ°��(Model �̿�)
	@RequestMapping("/test3")
	public String test3(Model model) {
		ProductVO product = new ProductVO();
		product.setName("sample");
		product.setNumber(27);
		model.addAttribute(product);
		// ������ �̸� ������ ��ü�� �ش��ϴ� Ŭ������ �̸����� ����(�Ǿռҹ��ڷ�)
		// model.addAttribute("productVO",product );
		return "productDetail"; // productDetail.jsp
	}

	@RequestMapping("/ex01")
	public void ex01(ProductVO pvo, int page) {
		System.out.println("page:" + pvo.getName());
		System.out.println(pvo.getNumber());
		System.out.println(page);
	}

	@RequestMapping("/quiz1")
	public void quiz1() {

	}

	@RequestMapping("/answer1")
	public String answer1(Model model,int num1, int num2) {
		int sum;
		sum = num1 + num2;
		model.addAttribute("num1",num1);
		model.addAttribute("num2",num2);
		model.addAttribute("sum",sum);
		return "abc";
	}
	
	@RequestMapping("/quiz2")
	public String quiz2() {
		return "quiz3";
	}
	
	@RequestMapping("/answer2")
	public String answer2(Model model, int num) {
		int sum;
		sum = num * 17;
		model.addAttribute("num",num);
		model.addAttribute("sum",sum);
		return "answer2";
	}
	
	@RequestMapping("/eltest")
	public void el() {
	}
	
	@RequestMapping("/quiz5")
	public String quiz5() {
		return "quiz6";
	}
	
	@RequestMapping("/quiz7")
	public String answer2(Model model, int num1, int num2) {
		int sum=0;
		int n1 = num1;
		int n2 = num2;		
		model.addAttribute("num1",num1);
		model.addAttribute("num2",num2);
		if(num1>num2) {
			int max = n1;
			n1 = n2;
			n2 = max;
		}
		for(int i=n1; i<=n2; i++) {
			sum += i;
		}
		model.addAttribute("sum",sum);
			
		return "result10";
	}
	@RequestMapping("/quiz20")
	public void quiz20() {
	}
	
	@RequestMapping("/input20")
	public void input20() {
	}
	
	@RequestMapping("/result20")
	public void result20(Model model, int num1, int num2, int num3) {
		int max = 0;
		max = num1 > num2 ? Math.max(num1,num3) : Math.max(num2, num3);
		model.addAttribute("max",max);
	}
	
	
}
