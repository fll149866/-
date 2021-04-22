package com.nysb.demo01.config;

import com.nysb.demo01.interceptor.CorsInterceptor;
import com.nysb.demo01.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig  implements WebMvcConfigurer {

    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Bean
    LoginInterceptor loginInterceptor(){return new LoginInterceptor();}

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /**
         * 跨域拦截，拦截全部路径
         */
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        /**
         * 拦截全部
         */
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截哪些路径 斜杠一定要加上
            .excludePathPatterns("/api/v1/pri/user/login","/api/v1/pri/user/register");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
