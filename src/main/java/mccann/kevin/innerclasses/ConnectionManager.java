package mccann.kevin.innerclasses;

import java.io.Closeable;
import java.util.ArrayList;

/**
 * Created by kevinmccann on 2/2/17.
 */
public class ConnectionManager {
    ArrayList<ManagedConnection> connectionList = new ArrayList<ManagedConnection>();
    final int MAXCONNECTION;

    ConnectionManager(int max) {
        this.MAXCONNECTION = max;
    }

    class ManagedConnection implements Connection, Closeable {
        String IP;
        int port;
        String protocol;
        boolean closed = false;

        ManagedConnection(String IP, int port, String protocol) {
            this.IP = IP;
            this.port = port;
            this.protocol = protocol;
        }

        public String connect() {
            String response = "";
            if (closed)
                response = response.concat("This connection has been closed!");
            else
                response = response.concat("Connected to " + getIP() + ":" + getPort() + " via " + getProtocol() + "! Good for you.");
            return response;
        }

        public String getIP() {
            if (!closed)
                return this.IP;
            else
                return "ERROR";
        }

        public int getPort() {
            if (!closed)
                return this.port;
            else
                return 0;
        }

        public String getProtocol() {
            if (!closed)
                return this.protocol;
            else
                return "ERROR";
        }

        public void close() {
            this.closed = true;
        }
    }

    ManagedConnection buildConnection(String IP, String protocol) {
        if (checkMax()) {
            ManagedConnection connection = new ManagedConnection(IP, 80, protocol);
            connectionList.add(connection);
            return connection;
        }
        else
            return null;
    }

    ManagedConnection buildConnection(String Ip, int port, String protocol) {
        if (checkMax()) {
            ManagedConnection connection = new ManagedConnection(Ip, port, protocol);
            connectionList.add(connection);
            return connection;
        }
        else
            return null;
    }

    ManagedConnection buildConnection(String IP, int port) {
        if (checkMax()) {
            ManagedConnection connection = new ManagedConnection(IP, port, "http");
            connectionList.add(connection);
            return connection;
        }
        else
            return null;
    }

    ManagedConnection getConnectionByProtocol(String protocol) {
        for (ManagedConnection connection : connectionList) {
            if (connection.getProtocol() == protocol)
                return connection;
        }
        return null;
    }

    ManagedConnection getConnectionByIP(String IP) {
        for (ManagedConnection connection : connectionList) {
            if (connection.getIP() == IP)
                return connection;
        }
        return null;
    }

    int numberOfConnections() {
        return connectionList.size();
    }

    boolean checkMax() {
        int counter = 0;
        for (ManagedConnection connection : connectionList) {
            if (!connection.closed)
                counter++;
        }
        return counter < MAXCONNECTION;
    }
}

//    void removedClosedConnection(ManagedConnection connection) {}
//}
