package io.github.cloudoas.waffle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.github.cloudoas.waffle.rest.AuthorizationInterceptor;
import waffle.servlet.NegotiateSecurityFilter;

@Configuration
public class WaffleConfig implements WebMvcConfigurer{

    @Bean
    public FilterRegistrationBean<NegotiateSecurityFilter> waffleNegotiateSecurityFilterRegistration() {
    	Map<String, String> initParams = new HashMap<>();
    	initParams.put("allowGuestLogin", "false");
    	
    	FilterRegistrationBean<NegotiateSecurityFilter> registrationBean = new FilterRegistrationBean<>();
    	NegotiateSecurityFilter waffleNegotiateSecurityFilter = new NegotiateSecurityFilter();
    	registrationBean.setFilter(waffleNegotiateSecurityFilter);
    	registrationBean.setName("waffleFilter");
    	registrationBean.addUrlPatterns("/api/*");
    	registrationBean.setInitParameters(initParams);
    	registrationBean.setOrder(2);
    	return registrationBean;
    }
    
    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(new AuthorizationInterceptor());
    }
}
