/* ==========================================================
 * ant-get-free-port
 * https://github.com/backstop/ant-get-free-port
 * ==========================================================
 * Copyright 2012 Backstop Solutions Group, LLC.
 * Authors: George Shakhnazaryan (gshakhnazaryan@backstopsolutions.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ========================================================== */

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