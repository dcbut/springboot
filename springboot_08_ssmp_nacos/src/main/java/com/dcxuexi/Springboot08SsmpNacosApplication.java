package com.dcxuexi;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "ssmp_nacos_yml", autoRefreshed = true, type = ConfigType.YAML )
public class Springboot08SsmpNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot08SsmpNacosApplication.class, args);
	}

}
