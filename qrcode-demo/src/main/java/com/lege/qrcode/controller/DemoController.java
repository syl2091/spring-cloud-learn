package com.lege.qrcode.controller;

import cn.hutool.extra.qrcode.QrCodeUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;

/**
 * @author lege
 * @Description
 * @create 2022-10-31 14:28
 */
@RequestMapping("/demo")
@RestController
public class DemoController {


    @GetMapping(value = "/qrcode",produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage QRcode(HttpServletResponse response){
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        BufferedImage image = QrCodeUtil.generate("https://www.baidu.com", 300, 300);
        return image;
    }
}
