package com.backstopsolutions.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import java.net.ServerSocket;
import java.io.IOException;

public class GetFreePort extends Task {
    private String propertyName = "availablePort";

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyName() {
        return this.propertyName;
    }

    public void execute() {
        try {
            ServerSocket socket = new ServerSocket(0);
            int port = socket.getLocalPort();
            getProject().setProperty(this.propertyName, Integer.toString(port));
            socket.close();
        } catch (IOException ioe) {
            throw new BuildException("Hit an IO exception", ioe);
        }
    }
}