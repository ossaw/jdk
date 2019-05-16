package com.sun.corba.se.spi.activation.RepositoryPackage;

/**
 * com/sun/corba/se/spi/activation/RepositoryPackage/ServerDef.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/spi/activation/activation.idl Friday, July 21, 2017
 * 9:58:51 PM PDT
 */

public final class ServerDef implements org.omg.CORBA.portable.IDLEntity {
    public String applicationName = null;

    // serverName values.
    public String serverName = null;

    // Class name of server's main class.
    public String serverClassPath = null;

    // class path used to run the server.
    public String serverArgs = null;
    public String serverVmArgs = null;

    public ServerDef() {} // ctor

    public ServerDef(String _applicationName, String _serverName, String _serverClassPath, String _serverArgs,
            String _serverVmArgs) {
        applicationName = _applicationName;
        serverName = _serverName;
        serverClassPath = _serverClassPath;
        serverArgs = _serverArgs;
        serverVmArgs = _serverVmArgs;
    } // ctor

} // class ServerDef
