//package com.goat.config;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.MediaType;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.List;
//import java.util.TimeZone;
//
///**
// * Created by 64274 on 2019/2/14.
// * doit  需要增加 @condition 知识 来让一个项目里 配置多个配置bean
// * @ Description: TODO
// * @ author  山羊来了
// * @ date 2019/2/14---16:05
// */
//@Configuration
//public class Configurer extends WebMvcConfigurationSupport {
//
////    @Autowired
////    HttpInterceptor httpInterceptor;
//
//    //定义时间格式转换器
//    @Bean
//    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")); // 功能同配置文件  这里先不配置
//        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8"));//解决时区差8小时问题
//        converter.setObjectMapper(mapper);
//        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_OCTET_STREAM));
//        return converter;
//    }
//
//    //添加转换器
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        //将我们定义的时间格式转换器添加到转换器列表中,
//        //这样jackson格式化时候但凡遇到Date类型就会转换成我们定义的格式
//        converters.add(jackson2HttpMessageConverter());
//    }
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        // TODO Auto-generated method stub
//        registry.addInterceptor(null).addPathPatterns("/**");
//        super.addInterceptors(registry);
//    }
//}
//
