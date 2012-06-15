Purpose
=======

During the build, some tasks require a server to be started (js-test-driver, fitnesse, etc.), but the port the server uses doesn't matter.
If the port number is hardcoded, then two builds can't run on the same machine concurrently.
Use get-free-port to grab a random free port to use instead.

Usage
=====

Define the task:

    <path id="ant.get.free.port.classpath">
        <fileset dir="FillThisIn" includes="ant-get-free-port-*.jar" />
    </path>
    <taskdef name="get-free-port" classname="com.backstopsolutions.ant.GetFreePort"
                     classpathref="ant.get.free.port.classpath"/>

Grab a free port:

    <get-free-port propertyname="some-property-name"/>
    <get-free-port propertyname="another-property-name"/>