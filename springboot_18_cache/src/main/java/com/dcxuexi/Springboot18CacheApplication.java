package com.dcxuexi;

import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@NacosPropertySource(dataId = "ssmp_nacos_yml",autoRefreshed = true,type = ConfigType.YAML)
// 开启缓存功能
@EnableCaching
public class Springboot18CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot18CacheApplication.class, args);
	}

}
