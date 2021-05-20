package com.lsitc.sfc.dspsample;

import com.lsitc.sfc.core.CoreProjectBasePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {CoreProjectBasePackage.class, WebProjectBasePackage.class})
public class DspPortalWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(DspPortalWebApplication.class, args);
    }

}
