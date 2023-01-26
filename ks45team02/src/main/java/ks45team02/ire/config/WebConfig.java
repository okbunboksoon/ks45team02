package ks45team02.ire.config;

import ks45team02.ire.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	private final LoginInterceptor loginInterceptor;

	public WebConfig(LoginInterceptor loginInterceptor){
		this.loginInterceptor = loginInterceptor;
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/addUser")
				.excludePathPatterns("/loginUser")
				.excludePathPatterns("/error")
				.excludePathPatterns("/admin/build/**")
				.excludePathPatterns("/admin/images/**")
				.excludePathPatterns("/admin/vendors/**")
				.excludePathPatterns("/eventImages/**")
				.excludePathPatterns("/images/**")
				.excludePathPatterns("/reviewImages/**")
				.excludePathPatterns("/user/css/**")
				.excludePathPatterns("/user/fonts/**")
				.excludePathPatterns("/user/images/**")
				.excludePathPatterns("/user/js/**")
				.excludePathPatterns("/user/vendor/**")
				.excludePathPatterns("/files/**")
				.excludePathPatterns("/imagess/**")
				.excludePathPatterns("/favicon.ico");

		WebMvcConfigurer.super.addInterceptors(registry);
	}

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
