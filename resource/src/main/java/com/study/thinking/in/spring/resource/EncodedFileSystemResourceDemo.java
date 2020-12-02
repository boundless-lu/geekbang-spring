package com.study.thinking.in.spring.resource;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

/**
 * @Description: 带有字符编码的 {@link FileSystemResource}
 * @Author Xiaoyaoyou
 * @Date: 2020/11/12 10:46
 * @Version 1.0
 * @see FileSystemResource
 * @see EncodedResource
 */
public class EncodedFileSystemResourceDemo {

    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "\\resource\\src\\main\\java\\com\\study\\thinking\\in\\spring\\resource\\EncodedFileSystemResourceDemo.java";
        File file = new File(path);
        //FileSystemResource => WritableResource => Resource
        FileSystemResource fileSystemResource = new FileSystemResource(file);
        EncodedResource encodedResource = new EncodedResource(fileSystemResource, "UTF-8");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(encodedResource.getReader());
            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
