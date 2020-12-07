package com.study.thinking.in.spring.i18n;

import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Description:  {@link MessageFormat} 示例
 * @Author Xiaoyaoyou
 * @Date: 2020/12/3 16:25
 * @Version 1.0
 * @see MessageFormat
 */
public class MessageFormatDemo {

    public static void main(String[] args) {
        int planet = 7;
        String event = "a disturbance in the Force";
        String massageFormatPattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        MessageFormat messageFormat = new MessageFormat(massageFormatPattern);
        String result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);
        System.out.println("==========================================================");

        //重置MessageFormatPattern
        massageFormatPattern = "The text content is: {0},{1}";
        messageFormat.applyPattern(massageFormatPattern);
        result = messageFormat.format(new Object[]{"hello world", "666"});
        System.out.println(result);
        System.out.println("==========================================================");

        //重置Locale
        messageFormat.setLocale(Locale.ENGLISH);
        massageFormatPattern = "At {1,time,long} on {1,date,full}, there was {2} on planet {0,number,integer}.";
        messageFormat.applyPattern(massageFormatPattern);
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);
        System.out.println("==========================================================");

        //重置Format
        messageFormat.setFormat(1,new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        result = messageFormat.format(new Object[]{planet, new Date(), event});
        System.out.println(result);


    }
}
