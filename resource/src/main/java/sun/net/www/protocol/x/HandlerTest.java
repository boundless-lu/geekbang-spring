package sun.net.www.protocol.x;

import org.apache.commons.io.IOUtils;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * @Description: HandlerTest
 * @Author Xiaoyaoyou
 * @Date: 2020/12/2 19:42
 * @Version 1.0
 */
public class HandlerTest {

    public static void main(String[] args) throws IOException {
        URL url =new URL("x:///META-INF/default.properties");
        final InputStream inputStream = url.openStream();
        System.out.println(IOUtils.toString(inputStream,"UTF-8"));
//        System.out.println(StreamUtils.copyToString(inputStream, Charset.forName("UTF-8")));
    }
}
