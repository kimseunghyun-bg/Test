package com.lsitc.sfc.dspsample.dummy.controller;

import com.lsitc.sfc.core.service.PropertyService;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
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
	public void getMessage(Locale locale) {
		String key = "title";
		String message = messageSource.getMessage(key, null, Locale.ENGLISH);
		System.out.println(message);
		System.out.println(propertyService.getString("test"));
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