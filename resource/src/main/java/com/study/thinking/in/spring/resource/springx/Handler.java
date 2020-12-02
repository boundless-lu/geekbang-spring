package com.study.thinking.in.spring.resource.springx;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * @Description: Handler
 * @Author Xiaoyaoyou
 * @Date: 2020/12/2 19:51
 * @Version 1.0
 */
public class Handler extends sun.net.www.protocol.x.Handler {

    //增加Java启动参数
    //-Djava.protocol.handler.pkgs=com.study.thinking.in.spring.resource
    public static void main(String[] args) throws IOException {
        URL url =new URL("springx:///META-INF/default.properties");
        final InputStream inputStream = url.openStream();
        System.out.println(IOUtils.toString(inputStream,"UTF-8"));
    }
}
