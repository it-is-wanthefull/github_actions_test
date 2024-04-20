package com.travelland.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 배포시 허용할 출처 추가하기
                .allowedOrigins("http://localhost:8080", "http://localhost:80", "http://localhost:3000", "https://localhost:443", "https://spparta.store", "https://www.travly.site", "http://www.travly.site", "https://kauth.kakao.com", "https://kapi.kakao.com") // 허용할 출처
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // 허용할 HTTP method
                .allowCredentials(true) // 쿠키 인증 요청 허용
                .allowedHeaders("*")
                .exposedHeaders("Authorization")
                .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }
}
