package com.sun.corba.se.spi.activation;

/**
 * com/sun/corba/se/spi/activation/ServerHeldDown.java . Generated by the
 * IDL-to-Java compiler (portable), version "3.2" from
 * c:/re/workspace/8-2-build-windows-amd64-cygwin/jdk8u144/9417/corba/src/share/
 * classes/com/sun/corba/se/spi/activation/activation.idl Friday, July 21, 2017
 * 9:58:51 PM PDT
 */

public final class ServerHeldDown extends org.omg.CORBA.UserException {
    public int serverId = (int) 0;

    public ServerHeldDown() {
        super(ServerHeldDownHelper.id());
    } // ctor

    public ServerHeldDown(int _serverId) {
        super(ServerHeldDownHelper.id());
        serverId = _serverId;
    } // ctor

    public ServerHeldDown(String $reason, int _serverId) {
        super(ServerHeldDownHelper.id() + "  " + $reason);
        serverId = _serverId;
    } // ctor

} // class ServerHeldDown
