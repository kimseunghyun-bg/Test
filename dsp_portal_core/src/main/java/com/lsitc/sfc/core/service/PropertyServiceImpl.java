package com.lsitc.sfc.core.service;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final Environment environment;

    public PropertyServiceImpl(Environment environment) {
        this.environment = environment;
    }

    @Override
    public String getString(String name) {
        return environment.getProperty(name);
    }

    @Override
    public String getString(String name, String defaultValue) {
        return environment.getProperty(name, defaultValue);
    }
}

