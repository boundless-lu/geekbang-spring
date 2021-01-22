package com.study.thinking.in.spring.environment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @Description: {@link TestPropertySource} 测试示例
 * @Author Xiaoyaoyou
 * @Date: 2021/1/22 16:06
 * @Version 1.0
 */
@ContextConfiguration(classes = TestPropertySourceTest.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(
        properties = "user.name = 逍遥游", //Inlined Test Properties
        locations = "/META-INF/test.properties")
public class TestPropertySourceTest {

    @Value("${user.name}") //spring应用上下文启动后，不具备动态更新能力
    private String userName;

    @Autowired
    private ConfigurableEnvironment environment;

    @Test
    public void test(){
        assertEquals("逍遥游",userName);
        for (PropertySource ps : environment.getPropertySources()){
            System.out.printf("PropertySource[name = %s]-->'user.name' = %s\n",ps.getName(),ps.getProperty("user.name"));
        }
    }

}
