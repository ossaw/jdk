package com.sun.corba.se.PortableActivationIDL;

/**
 * com/sun/corba/se/PortableActivationIDL/ServerAlreadyActive.java . Generated
 * by the IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/PortableActivationIDL/activation.idl Friday, July
 * 21, 2017 9:58:51 PM PDT
 */

public final class ServerAlreadyActive extends org.omg.CORBA.UserException {
    public String serverId = null;

    public ServerAlreadyActive() {
        super(ServerAlreadyActiveHelper.id());
    } // ctor

    public ServerAlreadyActive(String _serverId) {
        super(ServerAlreadyActiveHelper.id());
        serverId = _serverId;
    } // ctor

    public ServerAlreadyActive(String $reason, String _serverId) {
        super(ServerAlreadyActiveHelper.id() + "  " + $reason);
        serverId = _serverId;
    } // ctor

} // class ServerAlreadyActive
