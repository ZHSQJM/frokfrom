package com.zhs;

import com.zhs.entity.SysUser;
import com.zhs.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/19 16:41
 * @package: com.zhs
 * @description:
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class CommonTest {



    @Test
    public void  testGeneJwt(){
        SysUser sysUser = new SysUser();
        sysUser.setUsername("脾气很好的钢铁侠");
        sysUser.setId("123");

        final String token = JwtUtils.geneJsonWebToken(sysUser);
        System.out.println(token);
    }


    @Test
    public void testCheck(){
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJaSE9VSFVBU0hFTkciLCJpZCI6IjEyMyIsIm5hbWUiOiLohL7msJTlvojlpb3nmoTpkqLpk4HkvqAiLCJpYXQiOjE1ODQ2MDc0NDEsImV4cCI6MTU4NTIxMjI0MX0.OczaActw6uMNwxZu_6WvWg3uD9rW90pXiMuyEoqYUwU";
        final Claims claims = JwtUtils.checkJwt(token);
        if(claims!=null){
            String name = claims.get("name").toString();
            final String id = claims.get("id").toString();
            System.out.println(name);
            System.out.println(id);
        }
    }

    @Test
    public void testIsExitClass(){

        try {
            Class.forName("com.zhs.quartz.ChickenJob");
        } catch (ClassNotFoundException e) {

        }
    }

    @Test
    public  void Test(){
        try {
            Thumbnails.of("C:\\Users\\Iron man\\Desktop\\图片\\12.png")
                    .scale(0.4f)
                    .outputQuality(0.7f) //0-1 压缩质量
                    .toFile("C:\\Users\\Iron man\\Desktop\\图片\\12");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
