package com.lsitc.sfc.core.service;

public interface PropertyService {

    /**
     * String 타입의 프로퍼티 값 얻기
     *
     * @param name 프로퍼티키
     * @return String 타입의 값
     */
    String getString(String name);

    /**
     * String 타입의 프로퍼티 값 얻기
     *
     * @param name         프로퍼티키
     * @param defaultValue 디폴트 값
     * @return String 타입의 값
     */
    String getString(String name, String defaultValue);
}
