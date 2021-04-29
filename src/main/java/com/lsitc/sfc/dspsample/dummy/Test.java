package com.lsitc.sfc.dspsample.dummy;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {
	
	@GetMapping("/test01")
    public TestData getTestData() {
		TestData testData = new TestData(0, "String", 0L, Arrays.asList("Str1", "Str2"));
        return testData;
    }

}

class TestData {
    private int intData;
    private String strData;
    private long longData;
    private List<String> listData;
 
    public TestData() {
    }

	public TestData(int intData, String strData, long longData, List<String> listData) {
		super();
		this.intData = intData;
		this.strData = strData;
		this.longData = longData;
		this.listData = listData;
	}

	public int getIntData() {
		return intData;
	}

	public void setIntData(int intData) {
		this.intData = intData;
	}

	public String getStrData() {
		return strData;
	}

	public void setStrData(String strData) {
		this.strData = strData;
	}

	public long getLongData() {
		return longData;
	}

	public void setLongData(long longData) {
		this.longData = longData;
	}

	public List<String> getListData() {
		return listData;
	}

	public void setListData(List<String> listData) {
		this.listData = listData;
	}
}