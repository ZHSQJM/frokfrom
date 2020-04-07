package com.zhs.utils;

import com.zhs.entity.SysUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.security.auth.Subject;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/19 16:23
 * @package: com.zhs.utils
 * @description: jwt工具类
 */
public class JwtUtils {


    public static final String SUBJECT = "ZHOUHUASHENG";

    public static  long EXPIRE = 1000*60*60*24*7;
    /**密钥*/
    public static  final  String APPSECRET = "ZHOUHUASHENG";

    /**
     * 生成jwt
     * @param user
     * @return
     */
    public static String geneJsonWebToken(SysUser user){
        return Jwts.builder().setSubject(SUBJECT)
                .claim("id",user.getId())
                .claim("name",user.getUsername())
                //设置签发时间
                .setIssuedAt(new Date())
                //设置过去时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256,APPSECRET).compact();
    }

    /**
     * 校验token
     * @param token
     * @return
     */
    public static Claims checkJwt(String token){
          try {
              return Jwts.parser().setSigningKey(APPSECRET)
                      .parseClaimsJws(token)
                      .getBody();
          }catch (Exception e){ }
          return null;
    }
}
