package com.study.thinking.in.spring.resource.util;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.Reader;

/**
 * @Description: {@link Resource} 工具类
 * @Author Xiaoyaoyou
 * @Date: 2020/12/2 16:45
 * @Version 1.0
 */
public interface ResourceUtils {

    static String getContent(Resource resource){
        return getContent(resource,"utf-8");
    }

    static String getContent(Resource resource, String encoding){
        EncodedResource encodedResource = new EncodedResource(resource,encoding);
        try(Reader reader = encodedResource.getReader()){
            return IOUtils.toString(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}



