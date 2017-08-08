package com.ybveg.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

/**
 * @auther zbb
 * @create 2017/8/8
 */
public class TokenManager {

  ObjectMapper mapper = new ObjectMapper();

  public SecretKey generalKey() {
    byte[] encodedKey = Base64.decodeBase64(JWT.JWT_SECERT);
    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    return key;
  }

  /**
   * 签发JWT
   */
  public String createJWT(String id, String subject, long ttlMillis) {
    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
    long nowMillis = System.currentTimeMillis();
    Date now = new Date(nowMillis);
    SecretKey secretKey = generalKey();
    JwtBuilder builder = Jwts.builder()
        .setId(id)
        .setSubject(subject)
        .setIssuedAt(now)
        .signWith(signatureAlgorithm, secretKey);
    if (ttlMillis >= 0) {
      long expMillis = nowMillis + ttlMillis;
      Date expDate = new Date(expMillis);
      builder.setExpiration(expDate);
    }
    return builder.compact();
  }

  /**
   * 验证JWT
   */
  public Boolean validToken(String jwtToken) {
    Claims claims = null;
    try {
      claims = parseJWT(jwtToken);
    } catch (ExpiredJwtException e) {
    } catch (SignatureException e) {
    } catch (Exception e) {
    }
    return true;
  }


  /**
   * 解析JWT字符串
   */
  public Claims parseJWT(String jwt) throws Exception {
    SecretKey secretKey = generalKey();
    return Jwts.parser()
        .setSigningKey(secretKey)
        .parseClaimsJws(jwt)
        .getBody();
  }


  /**
   * 生成subject信息
   */
  public String generalSubject(Token token) throws JsonProcessingException {
    return mapper.writeValueAsString(token);
  }
}
