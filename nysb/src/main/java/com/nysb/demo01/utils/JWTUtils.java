package com.nysb.demo01.utils;

import com.nysb.demo01.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JWTUtils {
    /**
     * 过期时间，一周
     */
    static final long EXPIRE = 60000 * 60 * 24 * 7;

    /**
     * 加密秘钥
     */
    private static final String SECRET = "zbsys.com";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "zbsys";

    /**
     * subject主题
     */

    private static final String SUBJECT = "zbsys";
    /**
     * 根据用户信息，生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebToken(User user){

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("head_img",user.getHeadImg())
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()+EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX + token;

        return token;
    }

    public static Claims checkJWT(String token){
       try {
           final Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
           return claims;
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }

    }


}
