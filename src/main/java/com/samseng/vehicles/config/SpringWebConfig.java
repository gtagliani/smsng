package com.samseng.vehicles.config;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class SpringWebConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/")
        .addResourceLocations("/webjars/");   
     }
	
	@Bean
	  public MessageSource messageSource() {
	      ReloadableResourceBundleMessageSource bean = new ReloadableResourceBundleMessageSource();
	      bean.setBasename("classpath:messages");
	      //bean.setDefaultEncoding("UTF-8");
	      return bean;
	  }
	
	//externalizing Messages from code
	//https://teamtreehouse.com/library/displaying-validation-messages

	  @Bean
	  public LocalValidatorFactoryBean validator() {
	      LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
	      bean.setValidationMessageSource(messageSource());
	      return bean;
	  }

	  @Override
	  public Validator getValidator() {
	      return validator();
	  }
	  //////////////////////////////////////////
	  //
	  // I18N
	  //
	  //http://www.baeldung.com/spring-boot-internationalization
	  //////////////////////////////////////////
	  
	  @Bean
	  public LocaleResolver localeResolver() {
	      SessionLocaleResolver slr = new SessionLocaleResolver();
	      slr.setDefaultLocale(Locale.US);
	      return slr;
	  }
	  
	  @Bean
	  public LocaleChangeInterceptor localeChangeInterceptor() {
	      LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
	      lci.setParamName("lang");
	      return lci;
	  }
	  
	  @Override
	  public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(localeChangeInterceptor());
	  }
	

}
