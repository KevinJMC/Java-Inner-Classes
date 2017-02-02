package mccann.kevin.innerclasses;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/2/17.
 */
public class ConnectionManagerTest {

    ConnectionManager cm = new ConnectionManager(4);


    @Test
    public void buildConnectionTest() {
        int expected = 1;
        cm.buildConnection("100.100.100.100", "ftp");
        int actual = cm.numberOfConnections();
        assertEquals("number of connections should be 1",expected, actual);
    }

    @Test
    public void buildConnection1Test() {
        int expected = 1;
        cm.buildConnection("100.100.100.100", 2);
        int actual = cm.numberOfConnections();
        assertEquals("number of connections should be 1",expected, actual);
    }

    @Test
    public void buildConnection2Test() {
        int expected = 1;
        cm.buildConnection("100.100.100.100",1234, "tcp");
        int actual = cm.numberOfConnections();
        assertEquals("number of connections should be 1",expected, actual);
    }

    @Test
    public void getConnectionByProtocolTest() {
        cm.buildConnection("100.100.100.100",1234,"http");
//        assertNotNull(cm.getConnectionByProtocol("http"));
        String expected = "http";
        String actual = cm.getConnectionByProtocol("http").getProtocol();
        assertEquals("http expected", expected, actual);
    }

    @Test
    public void getConnectionByIPTest() {
        cm.buildConnection("100.100.100.100",1234,"http");
//        assertNotNull(cm.getConnectionByProtocol("http"));
        String expected = "100.100.100.100";
        String actual = cm.getConnectionByIP("100.100.100.100").getIP();
        assertEquals("100.100.100.100 expected", expected, actual);
    }

    @Test
    public void numberOfConnectionsTest() {
        cm.buildConnection("1.1.1.1",1234);
        int expected = 1;
        int actual = cm.numberOfConnections();
        assertEquals("1 expected", expected,actual);
    }

    @Test
    public void checkMaxTest() {
        boolean expected = true;
        boolean actual = cm.checkMax();
        assertEquals("false expected", expected, actual);
    }

//    @Test
//    public void removedClosedConnectionTest() {
//        cm.buildConnection("1.2.3.4", 80, "tcp");
//
//    }

}