package com.zhs.bo;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @project: formwork
 * @author: zhs
 * @date: 2020/3/31 15:25
 * @package: com.zhs.bo
 * @description:
 */
public class ImageCode {

    private BufferedImage image;
    private String code;
    //过期时间点
    private LocalDateTime expireTime;

    /**
     *
     * <p>Description: </p>
     * @param image
     * @param code
     * @param expireTn 多少秒过期
     */
    public ImageCode(BufferedImage image, String code, int expireTn) {
        super();
        this.image = image;
        this.code = code;
        //过期时间=当前时间+过期秒数
        this.expireTime = LocalDateTime.now().plusSeconds(expireTn);
    }
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        super();
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }
    /**
     * 验证码是否过期
     * @Description: 验证码是否过期
     * @param @return true 过期，false 没过期
     * @return boolean true 过期，false 没过期
     * @throws
     * @author lihaoyang
     * @date 2018年3月2日
     */
    public boolean isExpired(){
        return LocalDateTime.now().isAfter(expireTime);
    }
    public BufferedImage getImage() {
        return image;
    }
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public LocalDateTime getExpireTime() {
        return expireTime;
    }
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
}
