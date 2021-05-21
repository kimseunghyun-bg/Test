package com.lsitc.sfc.dspsample.dummy.controller;

import com.lsitc.sfc.core.service.PropertyService;
import com.lsitc.sfc.core.util.MessageUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestDummyController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	PropertyService propertyService;

	@GetMapping("/api/test01")
	public TestData getTestData() {
		TestData testData = new TestData();
		System.out.println("testData" + testData);
		return testData;
	}

	@GetMapping("/api/message")
	public Map<String, Object> getMessage() {
		Map<String, Object> allMessage = new HashMap<>(MessageUtils.getAllMessage());
		for (String name : allMessage.keySet()) {
			log.info("{}: {}", name, allMessage.get(name));
		}
		return allMessage;
	}

	@PostMapping("/api/toMap")
	public Map<String, Object> toMap(@RequestBody Map<String, Object> request) {
		return request;
	}

}

@Getter
@Setter
@ToString
class TestData {
	private String company;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String country;
	private String postalCode;
	private String aboutMe;

	public TestData() {
		super();
		this.company = "LS ITC";
		this.username = "2021321";
		this.email = "hhlee@lsitc.com";
		this.firstName = "HunHui";
		this.lastName = "Lee";
		this.address = "세종시 변두리";
		this.city = "세종시";
		this.country = "대한민국";
		this.postalCode = "0000";
		this.aboutMe = "이훈희입니다";
	}
}