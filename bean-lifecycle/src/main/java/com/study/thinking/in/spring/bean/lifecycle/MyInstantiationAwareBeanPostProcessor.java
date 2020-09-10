package com.study.thinking.in.spring.bean.lifecycle;

import com.study.thinking.in.spring.ioc.overview.domain.SuperUser;
import com.study.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.util.ObjectUtils;

/**
 * @Description: MyInstantiationAwareBeanPostProcessor
 * @Author Xiaoyaoyou
 * @Date: 2020/9/10 9:31
 * @Version 1.0
 */
 class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("user", beanName) && User.class.equals(beanClass)) {
            return new User();
        }
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("superUser", beanName) && SuperUser.class.equals(bean.getClass())) {
            User user = (User) bean;
            user.setId(3L);
            user.setName("Boundless");
            return false;
        }
        return true;
    }

    //superUser  postProcessAfterInstantiation方法返回false，跳过了属性赋值阶段，不受该方法影响
    //user  postProcessBeforeInstantiation方法返回非null值，完全跳过了Bean的实例化阶段，不受该方法影响
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {

        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            final MutablePropertyValues propertyValues;
            if (pvs instanceof MutablePropertyValues) {
                propertyValues = (MutablePropertyValues) pvs;
            } else {
                propertyValues = new MutablePropertyValues();
            }
            propertyValues.addPropertyValue("number", 18);

            //不做包含判断，不使用removePropertyValue移除方法也可以，相同属性名的情况下会直接覆盖配置文件的原始值
            if (propertyValues.contains("description")) {
                propertyValues.removePropertyValue("description");
                propertyValues.addPropertyValue("description", "This is user holder V2!");
            }else{
                propertyValues.addPropertyValue("description", "This is user holder V2!");
            }
            return propertyValues;
        }
        return null;
    }

    //初始化前回调
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("This is user holder V3!");
        }
        return bean;
    }

    //初始化后回调
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (ObjectUtils.nullSafeEquals("userHolder", beanName) && UserHolder.class.equals(bean.getClass())) {
            UserHolder userHolder = (UserHolder) bean;
            userHolder.setDescription("This is user holder V7!");
            System.out.println("postProcessAfterInitialization() = " + userHolder.getDescription());
        }
        return bean;
    }
}
