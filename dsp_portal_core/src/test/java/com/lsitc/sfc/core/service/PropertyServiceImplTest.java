package com.lsitc.sfc.core.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = PropertyServiceImpl.class)
@TestPropertySource("classpath:properties/PropertyServiceImplTest.properties")
class PropertyServiceImplTest {

    @Autowired
    private PropertyService propertyService;

    @Test
    void getString_ExistProperty_ReturnString() {
        assertThat(propertyService.getString("city")).isEqualTo("seoul");
    }

    @Test
    void getString_NotExistProperty_ReturnDefaultValue() {
        assertThat(propertyService.getString("emptyName", "DefVal")).isEqualTo("DefVal");
    }
}

