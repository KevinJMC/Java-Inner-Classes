package mccann.kevin.innerclasses;

import java.io.Closeable;

/**
 * Created by kevinmccann on 2/2/17.
 */
public interface Connection extends Closeable{
    String connect();

    String getIP();

    int getPort();

    String getProtocol();

    void close();
}
