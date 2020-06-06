package com.mt.common.configrutaion;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/home/mt/resource/mt-application.properties")
public class ReadLocalConf {
}
