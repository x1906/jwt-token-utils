import com.alibaba.fastjson.JSONObject;
import com.ybveg.jwt.config.TokenProperties;
import com.ybveg.jwt.token.Token;
import com.ybveg.jwt.token.TokenFactory;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import java.io.Serializable;
import org.junit.Before;
import org.junit.Test;

/**
 * @auther zbb
 * @create 2017/8/9
 */
public class TokenCase {


  private TokenProperties properties;
  private TokenFactory factory;

  @Before
  public void init() {
    properties = new TokenProperties();
    properties.setIssuer("http://www.ybveg.com");
    properties.setSecert("fhaksdfaweoufajfskldjfkls");
    properties.setExpire(1);
    properties.setRefreshExpire(10);
    factory = new TokenFactory(properties);

  }

  @Test
  public void createToken() {
    User user = new User();
    user.setId("123");
    user.setId("zhangbinbin");

    Token accessToken = factory.createAccessToken(user.getId(), user);

    System.out.println(JSONObject.toJSONString(accessToken));
    Jws<Claims> jws = Jwts.parser().setSigningKey(properties.getSecert())
        .parseClaimsJws(accessToken.getToken());
    Claims claims = jws.getBody();
    System.out.println(JSONObject.toJSONString(claims));
  }


  public class User implements Serializable {

    private static final long serialVersionUID = 4603102090426293787L;
    private String id;
    private String name;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }
  }


}
