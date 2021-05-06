package com.lsitc.sfc.dspsample.common.login.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lsitc.sfc.dspsample.common.login.vo.LoginVO;

@RestController
@RequestMapping("/api")
public class LoginController {
	
	@PostMapping(value = "/login")
	public Map<String, Object> login(@RequestBody LoginVO loginVO) throws Exception {
		
		System.out.println(loginVO.getUsername());
		System.out.println(loginVO.getPassword());
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		loginVO.setAccessToken("11111");
		
		map.put("accessToken", loginVO.getAccessToken());
		
		return map;
		
	}

}
