package com.lsitc.sfc.core.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PropertyServiceImpl implements PropertyService {

    private Environment environment;

    @Override
    public String getString(String name) {
        return environment.getProperty(name);
    }

    @Override
    public String getString(String name, String defaultValue) {
        return environment.getProperty(name, defaultValue);
    }
}

