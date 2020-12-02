package sun.net.www.protocol.x;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandler;

/**
 * @Description:   x 协议 {@link URLStreamHandler} 实现
 * @Author Xiaoyaoyou
 * @Date: 2020/12/2 19:33
 * @Version 1.0
 */
public class Handler extends URLStreamHandler{
    @Override
    protected URLConnection openConnection(URL u) throws IOException {
        return new XURLConnection(u);
    }
}
