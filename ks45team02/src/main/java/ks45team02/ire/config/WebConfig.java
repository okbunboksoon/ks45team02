package ks45team02.ire.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	/*파일 외부 경로 설정*/
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/imagess/**")
				.addResourceLocations("file:///home/springboot/teamproject/resources/imagess/");
		registry.addResourceHandler("/files/**")
				.addResourceLocations("file:///home/springboot/teamproject/resources/files/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
}
