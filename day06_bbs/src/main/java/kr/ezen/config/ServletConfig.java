package kr.ezen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//servlet-context.xml 대체
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"kr.ezen.bbs", "kr.ezen.controller"}) //컨트롤러 객체 만드는 것 = ezen/bbs/ 내 모든 객체를 컴퍼넌트가 만들겠다.
// 이렇게하면 문제점. service안에 있는 객체들도 같이 만들어지는데 서비스 내 객체는 rootconfig안에 들어가야 함.
public class ServletConfig implements WebMvcConfigurer{
	private final int MAX_SIZE = 10*1024*1024;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {		
		registry.addResourceHandler("/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(MAX_SIZE);
		multipartResolver.setMaxUploadSizePerFile(MAX_SIZE);
		multipartResolver.setMaxInMemorySize(0);
		
		return multipartResolver;
	}
	
	
}
