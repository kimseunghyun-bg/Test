package com.lsitc.sfc.dspsample;

import com.lsitc.sfc.core.CoreProjectBasePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackageClasses = {CoreProjectBasePackage.class, WebProjectBasePackage.class})
@ServletComponentScan(basePackageClasses = {CoreProjectBasePackage.class, WebProjectBasePackage.class})
public class DspPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DspPortalWebApplication.class, args);
    }

}
