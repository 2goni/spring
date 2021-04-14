package org.zerock.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.LottoDTO;
import org.zerock.domain.UserVO;
import org.zerock.service.LottoServiceImpl;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AjaxController {
	LottoServiceImpl service;

	@CrossOrigin("*")
	@PostMapping(value = "/mit/lottolist")
	public List<LottoDTO> getlist(@RequestBody UserVO vo) {
		List<LottoDTO> list = new ArrayList<LottoDTO>();
		List<UserVO> uvo = service.getList(vo);
		for (UserVO user : uvo) {
			list.add(LottoDTO.builder().lnum1(user.getLnum1()).lnum2(user.getLnum2()).lnum3(user.getLnum3())
					.lnum4(user.getLnum4()).lnum5(user.getLnum5()).lnum6(user.getLnum6()).build());
		}
		return list;
	}

	@CrossOrigin("*")
	@PostMapping(value = "/mit/lotto", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public LottoDTO getlotto(@RequestBody UserVO vo, HttpServletRequest request) {
		vo.setIp(getIp(request));
		vo.setBrowser(getBrowser(request));
		vo.setDevice(getDevice(request));
		vo.setUseragent(request.getHeader("user-agent"));
		UserVO uvo = service.getUserLotto(vo);
		return LottoDTO.builder().lnum1(uvo.getLnum1()).lnum2(uvo.getLnum2()).lnum3(uvo.getLnum3())
				.lnum4(uvo.getLnum4()).lnum5(uvo.getLnum5()).lnum6(uvo.getLnum6()).build();

	}

	public String getIp(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null) {
			ip = request.getHeader("WL-Proxy-Client-IP"); // 웹로직
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	public String getBrowser(HttpServletRequest request) {
		String user_agent = request.getHeader("user-agent");
		String webKind = "";
		if (user_agent.toUpperCase().indexOf("GECKO") != -1) {
			if (user_agent.toUpperCase().indexOf("NESCAPE") != -1) {
				webKind = "Netscape (Gecko/Netscape)";
			} else if (user_agent.toUpperCase().indexOf("FIREFOX") != -1) {
				webKind = "Mozilla Firefox (Gecko/Firefox)";
			} else {
				webKind = "Mozilla (Gecko/Mozilla)";
			}
		} else if (user_agent.toUpperCase().indexOf("MSIE") != -1) {
			if (user_agent.toUpperCase().indexOf("OPERA") != -1) {
				webKind = "Opera (MSIE/Opera/Compatible)";
			} else {
				webKind = "Internet Explorer (MSIE/Compatible)";
			}
		} else if (user_agent.toUpperCase().indexOf("SAFARI") != -1) {
			if (user_agent.toUpperCase().indexOf("CHROME") != -1) {
				webKind = "Google Chrome";
			} else {
				webKind = "Safari";
			}
		} else if (user_agent.toUpperCase().indexOf("THUNDERBIRD") != -1) {
			webKind = "Thunderbird";
		} else {
			webKind = "Other Web Browsers";
		}
		return webKind;
	}

	public static String getDevice(HttpServletRequest request) {
        Device device = DeviceUtils.getCurrentDevice(request);        
        if (device.isNormal()) {
            return "PC";
        } else if (device.isMobile()) {
        	return "mobile";
        } else if (device.isTablet()) {
        	return "tablet";
        }
        return "UNKNOWN";
	}
}
