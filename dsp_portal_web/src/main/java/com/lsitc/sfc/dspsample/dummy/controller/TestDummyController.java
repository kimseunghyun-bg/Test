package com.lsitc.sfc.dspsample.dummy.controller;

import com.lsitc.sfc.core.service.PropertyService;
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
	

}