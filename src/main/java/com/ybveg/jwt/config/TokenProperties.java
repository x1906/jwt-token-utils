package com.ybveg.jwt.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @auther zbb
 * @create 2017/8/9
 */
@Configuration
@ConfigurationProperties("spring.token")
public class TokenProperties {

  /**
   * token 有效时间 在有效时间内可以更新token
   */
  private int expire;
  /**
   * 签发者
   */
  private String issuer;
  /**
   * 秘钥
   */
  private String secert;

  /**
   * token 可用时间
   * 超过可用时间 会自动刷新token
   * 一般有效时间的一半
   */
  private int refreshExpire;


  public int getExpire() {
    return expire;
  }

  public void setExpire(int expire) {
    this.expire = expire;
  }

  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  public String getSecert() {
    return secert;
  }

  public void setSecert(String secert) {
    this.secert = secert;
  }

  public int getRefreshExpire() {
    return refreshExpire;
  }

  public void setRefreshExpire(int refreshExpire) {
    this.refreshExpire = refreshExpire;
  }
}
