package mccann.kevin.innerclasses;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kevinmccann on 2/2/17.
 */
public class ManagedConnectionTest {
    ConnectionManager.ManagedConnection connection = new ConnectionManager(4).new ManagedConnection("1.2.3.4",80,"http");

    @Test
    public void connect() {
        String expected = "Connected to 1.2.3.4:80 via http! Good for you.";
        String actual = connection.connect();
        assertEquals("success message expected",expected,actual);
    }

    @Test
    public void close() {
        connection.close();
        assertTrue(connection.closed);
    }

}