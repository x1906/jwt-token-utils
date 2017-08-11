package com.ybveg.jwt.config;

import com.ybveg.jwt.token.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zbb
 * @create 2017/8/10
 */
@Configuration
@EnableConfigurationProperties(TokenProperties.class)
public class JwtTokenAutoConfiguration {

  @Autowired
  private TokenProperties properties;

  @Bean
  public TokenFactory initTokenFactory() {
    return new TokenFactory(properties);
  }
}
