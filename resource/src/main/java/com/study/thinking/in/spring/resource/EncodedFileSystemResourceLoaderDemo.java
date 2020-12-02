package com.study.thinking.in.spring.resource;

import org.apache.commons.io.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @Description: 带有字符编码的 {@link FileSystemResourceLoader}
 * @Author Xiaoyaoyou
 * @Date: 2020/11/12 10:46
 * @Version 1.0
 * @see FileSystemResource
 * @see EncodedResource
 */
public class EncodedFileSystemResourceLoaderDemo {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir")+"\\resource\\src\\main\\java\\com\\study\\thinking\\in\\spring\\resource\\EncodedFileSystemResourceLoaderDemo.java";
        FileSystemResourceLoader loader = new FileSystemResourceLoader();
        Resource resource = loader.getResource(path);
        EncodedResource encodedResource = new EncodedResource(resource,"UTF-8");
        try(Reader reader = encodedResource.getReader()){
            System.out.println(IOUtils.toString(reader));
        }
    }
}
